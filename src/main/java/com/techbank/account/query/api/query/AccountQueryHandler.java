package com.techbank.account.query.api.query;

import com.techbank.account.query.api.dto.EqualityType;
import com.techbank.account.query.domain.AccountRepository;
import com.techbank.account.query.domain.BankAccount;
import com.techbank.cqrs.core.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountQueryHandler implements QueryHandler {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<BaseEntity> handler(FindAccountByHolderQuery query) {
        var bankAccounts = accountRepository.findByAccountHolder(query.getHolder());
        if (bankAccounts.isEmpty()) {
            return null;
        }
        List<BaseEntity> bankAccountList = new ArrayList<>();
        bankAccountList.add(bankAccounts.get());
        return bankAccountList;
    }

    @Override
    public List<BaseEntity> handler(FindAccountWithBalanceQuery query) {
        List<BaseEntity> bankAccounts = query.getEqualityType() != EqualityType.GREATER_THAN ?
                accountRepository.findAllByBalanceLessThan(query.getBalance()) :
                accountRepository.findAllByBalanceGreaterThan(query.getBalance());
        return bankAccounts;
    }


    @Override
    public List<BaseEntity> handler(FindAllAccountByIdQuery query) {
        var bankAccounts = accountRepository.findById(query.getId());
        if (bankAccounts.isEmpty()) {
            return null;
        }
        List<BaseEntity> bankAccountList = new ArrayList<>();
        bankAccountList.add(bankAccounts.get());
        return bankAccountList;
    }

    @Override
    public List<BaseEntity> handler(FindAllAccountQuery query) {
        Iterable<BankAccount> bankAccounts = accountRepository.findAll();
        List<BaseEntity> bankAccountList = new ArrayList<>();
        bankAccounts.forEach(bankAccountList::add);
        return bankAccountList;
    }
}
