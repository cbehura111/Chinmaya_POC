package com.chinmaya.cache.database.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "appzillonEntityManagerFactory", transactionManagerRef = "appzillonTransactionManager", basePackages = {
		"com.chinmaya.*.appzillon.repository","com.iexceed.appzillon.domain.repository" })
@ComponentScan(basePackages = { "com.chinmaya.*" })
public class AppzillonCBConfiguration {

	@Autowired
	Environment environment;

	@Value("${init-db:false}")
	private String initDatabase;

	@Value("${hibernate-generateDDL:false}")
	private String generateDDL;

	@Value("${hibernate-showSQL:true}")
	private String showSQL;

	@Primary
	@Bean(name = "appzillonDataSource")
	public DataSource dataSource() {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		return dsLookup.getDataSource(environment.getProperty("jndi.name"));

	}

	@Primary
	@Bean(name = "appzillonEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.parseBoolean(generateDDL));
		vendorAdapter.setShowSql(Boolean.parseBoolean(showSQL));
		vendorAdapter.setDatabasePlatform(environment.getProperty("database.type"));

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.archive.autodetection", "class");
		jpaProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl_auto"));

		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(vendorAdapter);
		//factory.setPackagesToScan("com.chinmaya.*.appzillon.model");
		factory.setPackagesToScan("com.chinmaya.*","com.iexceed.appzillon.*");
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory;
	}

	@Primary
	@Bean(name = "appzillonTransactionManager")
	public PlatformTransactionManager appzillonTransactionManager(
			@Qualifier("appzillonEntityManagerFactory") EntityManagerFactory appzillonEntityManagerFactory) {
		return new JpaTransactionManager(appzillonEntityManagerFactory);
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer() {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource());
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("db.sql"));
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
		return dataSourceInitializer;
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}

}
