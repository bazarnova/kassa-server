package com.kassa.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("db.properties")
@ConfigurationProperties(prefix = "db")
public class DBProperties {
    private String schemas;
    private String user;
    private String password;
    private String url;

    public DBProperties() {
    }

    public DBProperties(String schemas, String user, String password, String url) {
        this.schemas = schemas;
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public String getSchemas() {
        return schemas;
    }

    public void setSchemas(String schemas) {
        this.schemas = schemas;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}


