package com.chinmaya.library.config;

import com.chinmaya.library.manager.DBFactoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBFactory {

    @Value("${databaseName}")
    int dbFactoryType;

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public DBFactoryManager getDbAdapterFactory() {
        return DBFactoryManager.getFactory(dbFactoryType, dataSource);
    }
}
