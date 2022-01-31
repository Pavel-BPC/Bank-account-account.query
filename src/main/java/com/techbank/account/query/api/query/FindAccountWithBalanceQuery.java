package com.techbank.account.query.api.query;

import com.techbank.account.query.api.dto.EqualityType;
import com.techbank.cqrs.core.queries.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindAccountWithBalanceQuery extends BaseQuery {
        private double balance;
        private EqualityType equalityType;
}
