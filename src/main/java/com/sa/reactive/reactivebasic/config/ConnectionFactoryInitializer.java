package com.sa.reactive.reactivebasic.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.stereotype.Component;


@Component
public  class 	ConnectionFactoryInitializer  {
    private final ConnectionFactory connectionFactory;
    ConnectionFactoryInitializer(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }


}
