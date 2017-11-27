package com.hzcf.operation.mongo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * Create by hanlin on 2017年11月27日
 **/
@Configuration
public class HJDecisionMongoTemplate {
    @Autowired
    @Qualifier("decisionMongoProperties")
    private MongoProperties mongoProperties;

    @Bean(name = "hjDecisionMongoTemplate")
    public MongoTemplate hjDecisionMongoTemplate() throws Exception {
        return new MongoTemplate(decisionFactory(this.mongoProperties));
    }

    @Bean
    public MongoDbFactory decisionFactory(MongoProperties mongoProperties) throws Exception {

        ServerAddress serverAdress = new ServerAddress(mongoProperties.getUri());

        return new SimpleMongoDbFactory(new MongoClient(serverAdress), mongoProperties.getDatabase());

    }
}