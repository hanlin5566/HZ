package com.hzcf.operation.mongo.conf;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Create by hanlin on 2017年11月27日
 **/
@Configuration
public class MongoConfig {
    @Bean(name="apiMongoProperties")
    @Primary
    @ConfigurationProperties(prefix="spring.data.mongodb.hjapi")
    public MongoProperties apiMongoProperties() {
        return new MongoProperties();
    }

    @Bean(name="decisionMongoProperties")
    @ConfigurationProperties(prefix="spring.data.mongodb.hjdecision")
    public MongoProperties decisionMongoProperties() {
        return new MongoProperties();
    }

}