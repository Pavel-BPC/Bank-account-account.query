package com.techbank.account.query.infrastructure.consumers;

import com.techbank.account.common.events.AccountOpenedEvent;
import com.techbank.account.common.events.AccountsClosedEvent;
import com.techbank.account.common.events.FundsDepositedEvent;
import com.techbank.account.common.events.FundsWithdrawnEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
    void consume(@Payload AccountOpenedEvent event, Acknowledgment acknowledgment);

    void consume(@Payload FundsDepositedEvent event, Acknowledgment acknowledgment);

    void consume(@Payload FundsWithdrawnEvent event, Acknowledgment acknowledgment);

    void consume(@Payload AccountsClosedEvent event, Acknowledgment acknowledgment);
}
