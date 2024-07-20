package com.example.b2c_integration.config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;

@Configuration
public class MongoConfig {

    private static final String DATABASE_NAME = "your_database_name";
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";

    @Bean
    public MongoTemplate mongoTemplate() {
        SimpleMongoClientDatabaseFactory factory = new SimpleMongoClientDatabaseFactory(MongoClients.create(CONNECTION_STRING), DATABASE_NAME);
        MongoMappingContext context = new MongoMappingContext();
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null)); 
        return new MongoTemplate(factory, converter);
    }
}
