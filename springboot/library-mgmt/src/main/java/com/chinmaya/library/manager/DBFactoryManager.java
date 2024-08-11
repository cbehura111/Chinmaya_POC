package com.chinmaya.library.manager;

import javax.sql.DataSource;

public abstract class DBFactoryManager {
    public static final int PSQL = 0;
    public static final int ORACLE = 1;

    public DBFactoryManager() {
    }

    public static DBFactoryManager getFactory(int factoryType, IDBParameter dbParameters) {
        switch (factoryType) {
            case 0:
                return new PostgresSQLFactoryManager((new DataSourceFactory()).getPostgresSqlDataSource(dbParameters));
            case 1:
                return new OracleFactoryManager((new DataSourceFactory()).getOracleDataSource(dbParameters));
            default:
                return null;
        }
    }

    public static DBFactoryManager getFactory(int factoryType, DataSource dataSource) {
        switch (factoryType) {
            case 0:
                return new PostgresSQLFactoryManager(dataSource);
            case 1:
                return new OracleFactoryManager(dataSource);
            default:
                return null;
        }
    }

}
