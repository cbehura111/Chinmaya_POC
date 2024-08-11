package com.chinmaya.library.manager;


import org.postgresql.ds.PGSimpleDataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataSourceFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceFactory.class);

    public DataSourceFactory() {
    }

    public DataSource getPostgresSqlDataSource(IDBParameter dbParameters) {
        PGSimpleDataSource pgSimpleDataSource = null;

        try {
            pgSimpleDataSource = new PGSimpleDataSource();
            pgSimpleDataSource.setURL(dbParameters.getUrl());
            pgSimpleDataSource.setUser(dbParameters.getUserName());
            pgSimpleDataSource.setPassword(dbParameters.getPassword());
        } catch (Exception var4) {
            LOGGER.error("Postgres database connection error ", var4);
        }

        return pgSimpleDataSource;
    }

    public DataSource getOracleDataSource(IDBParameter dbParameters) {
        OracleDataSource oracleDataSource = null;

        try {
            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(dbParameters.getUrl());
            oracleDataSource.setUser(dbParameters.getUserName());
            oracleDataSource.setPassword(dbParameters.getPassword());
        } catch (SQLException var4) {
            LOGGER.error("Oracle database connection error ", var4);
        }

        return oracleDataSource;
    }
}
