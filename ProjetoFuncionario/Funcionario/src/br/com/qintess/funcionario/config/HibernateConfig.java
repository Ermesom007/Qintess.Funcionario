package br.com.qintess.funcionario.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean
	public LocalSessionFactoryBean sessionFactor() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("br.com.qintess.funcionario.entidades");
		sessionFactory.setHibernateProperties(hibernateProperties());
			
		return sessionFactory;		
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/db_funcionario");
		dataSource.setUsername("postgres");
		dataSource.setPassword("ma123");
		
		return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactor().getObject());
		
		
		return transactionManager;
	}
	
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(Environment.SHOW_SQL, "false");
		hibernateProperties.setProperty(Environment.HBM2DDL_AUTO, "update");
		hibernateProperties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		
		return hibernateProperties;
		
	}

}
