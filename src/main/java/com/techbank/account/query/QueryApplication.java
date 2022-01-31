package com.techbank.account.query;

import com.techbank.account.query.api.query.*;
import com.techbank.cqrs.core.infrastructure.QueryDispatcher;
import com.techbank.cqrs.core.queries.BaseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class QueryApplication {
    @Autowired
    private QueryDispatcher queryDispatcher;
    @Autowired
    private QueryHandler queryHandler;

    public static void main(String[] args) {
        SpringApplication.run(QueryApplication.class, args);
    }

    @PostConstruct
    public void registerHandlers() {
        queryDispatcher.registerHandler(FindAccountByHolderQuery.class, queryHandler::handler);
        queryDispatcher.registerHandler(FindAccountWithBalanceQuery.class, queryHandler::handler);
        queryDispatcher.registerHandler(FindAllAccountByIdQuery.class, queryHandler::handler);
        queryDispatcher.registerHandler(FindAllAccountQuery.class, queryHandler::handler);
    }
}
