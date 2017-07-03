package com.javacodegeeks.examples.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

//    @Bean
////    @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//        dsLookup.setResourceRef(true);
//        //DataSource dataSource = dsLookup.getDataSource(this.env.getProperty("database.jndi"));
////        DataSource dataSource = dsLookup.getDataSource("java:/quickbookPostgresDS");
//        DataSource dataSource = dsLookup.getDataSource("jdbc/dbwrfadmin");
//        return dataSource;
//    }
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@192.168.1.53:1521:xe");
        dataSource.setUsername("dbwrf");
        dataSource.setPassword("MAmail786");
        dataSource.setMaxActive(300);
        dataSource.setMaxIdle(30);
        dataSource.setMaxWait(2000);
System.out.print("connection establised...");
        return dataSource;
    }
}
