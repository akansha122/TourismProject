package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class ProjectTrackerApplication {

	@Autowired
	private Environment env;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectTrackerApplication.class, args);
	}

	/*
	 * @Autowired
	 * 
	 * @Bean(name = "hibernateTemplate") public HibernateTemplate
	 * getHibernateTemplate(SessionFactory sessionFactory) { HibernateTemplate
	 * hibernateTemplate = new HibernateTemplate(sessionFactory); return
	 * hibernateTemplate; }
	 * 
	 * 
	 * 
	 * 
	 * @Autowired
	 * 
	 * @Bean(name = "transactionManager") public HibernateTransactionManager
	 * getHibernateTransactionManager(SessionFactory sessionFactory) {
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager(sessionFactory); return transactionManager; }
	 * 
	 * 
	 * @Autowired
	 * 
	 * @Bean(name = "transactionManager") public PlatformTransactionManager
	 * dbTransactionManager() { JpaTransactionManager transactionManager = new
	 * JpaTransactionManager();
	 * transactionManager.setEntityManagerFactory(getSessionFactory(dataSource).
	 * getObject()); return transactionManager; }
	 */
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		LOGGER.info("Debug: getDataSource :: " + dataSource);
		return dataSource;
	}

	@Bean(name = "entityManagerFactory") // JPA by default searches sessionFactory by name 'entityManagerFactory'
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
		Properties properties = new Properties();
		LOGGER.info("Debug: In getSessionFactory");
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		LOGGER.info("Debug: Hibernate properties set :: " + properties);

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan(new String[] { "com.zensar" });
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		LOGGER.info("Debug: factoryBean object set :: " + factoryBean);

		SessionFactory sessionFactory = factoryBean.getObject();
		LOGGER.info("Debug: getSessionFactory object: " + sessionFactory);
		return sessionFactory;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
