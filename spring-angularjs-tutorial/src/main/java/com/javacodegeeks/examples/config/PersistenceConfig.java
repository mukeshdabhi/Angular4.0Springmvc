/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacodegeeks.examples.config;

import java.util.Collections;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.javacodegeeks")
class PersistenceConfig {

    @Autowired
    private Environment env;
    @Autowired
    private DataSource dataSource;

//     @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//        dataSource.setUsername("MA_WOMEN_RELIGIOUS");
//        dataSource.setPassword("MA_78652__dbwrf");
//        dataSource.setMaxActive(300);
//        dataSource.setMaxIdle(30);
//        dataSource.setMaxWait(2000);
//
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//        HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
//        hibernateJpa.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
//        hibernateJpa.setShowSql(false);
//
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource());
//        emf.setPackagesToScan("com.dbwrf");
//        emf.setJpaVendorAdapter(hibernateJpa);
//        emf.setPersistenceUnitName("dw");
//        emf.setJpaPropertyMap(Collections.singletonMap("javax.persistence.validation.mode", "none"));
//        return emf;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager txnMgr = new JpaTransactionManager();
//        txnMgr.setEntityManagerFactory(entityManagerFactory().getObject());
//        return txnMgr;
//    }
    
    
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
        hibernateJpa.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
        hibernateJpa.setShowSql(false);
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.javacodegeeks");
        emf.setJpaVendorAdapter(hibernateJpa);
        emf.setPersistenceUnitName("dw");
        emf.setJpaPropertyMap(Collections.singletonMap("javax.persistence.validation.mode", "none"));
        return emf;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txnMgr = new JpaTransactionManager();
        txnMgr.setEntityManagerFactory(entityManagerFactory().getObject());
        return txnMgr;
    }
}
