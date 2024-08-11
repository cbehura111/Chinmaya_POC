package com.chinmaya.library.manager;

import javax.sql.DataSource;

public class OracleFactoryManager extends DBFactoryManager {
    private final DataSource dataSource;

    public OracleFactoryManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
