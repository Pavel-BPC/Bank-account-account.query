package com.techbank.account.query.api.query;

import com.techbank.cqrs.core.domain.BaseEntity;

import java.util.List;

public interface QueryHandler {
    List<BaseEntity> handler(FindAccountByHolderQuery query);

    List<BaseEntity> handler(FindAccountWithBalanceQuery query);

    List<BaseEntity> handler(FindAllAccountByIdQuery query);

    List<BaseEntity> handler(FindAllAccountQuery query);
}
