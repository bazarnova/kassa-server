package com.kassa.configs;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import(FlyWayConfig.class)
public class PersistenceConfig {

    @Autowired
    private DBProperties dbProperties;

    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setURL(dbProperties.getUrl());
        source.setUser(dbProperties.getUser());
        source.setPassword(dbProperties.getPassword());
        source.setCurrentSchema(dbProperties.getSchemas());

        return source;
    }

}