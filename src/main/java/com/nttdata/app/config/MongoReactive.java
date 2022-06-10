package com.nttdata.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages ="com.nttdata.app.repository")
@EnableMongoAuditing
public class MongoReactive {
}
