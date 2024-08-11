package com.chinmaya.library.manager;

import javax.sql.DataSource;

public class PostgresSQLFactoryManager extends DBFactoryManager {
    private final DataSource dataSource;

    public PostgresSQLFactoryManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
