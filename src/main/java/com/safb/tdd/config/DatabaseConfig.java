package com.safb.tdd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * The database configuration responsible for successfully making the database connections and mapping the entities.
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.safb.tdd.repository"})
@EnableTransactionManagement
public class DatabaseConfig {


    /**
     * The defined bean sets the driver class name, url to the database itself, username and password, for accessing the chosen schema.
     *
     * @return A datasource instance containing database connection description.
     * @author Atanas Yordanov Arshinkov
     * @since 1.0.0
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/testdb");
        dataSource.setUsername("testdb");
        dataSource.setPassword("Test-1234");

        return dataSource;
    }

    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        return jpaVendorAdapter;
    }

    /**
     * @return Database properties as dialects, showing and formatting the SQL query to the console.
     * @author Atanas Yordanov Arshinkov
     * @since 1.0.0
     */
    private Properties jpaProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        jpaProperties.setProperty("hibernate.show_sql", "true");
        jpaProperties.setProperty("hibernate.format_sql", "true");

        return jpaProperties;
    }

    /**
     * This method automatically maps the all created entities to their respective database tables in the schema.
     *
     * @return The entity manager factory bean
     * @author Atanas Yordanov Arshinkov
     * @since 1.0.0
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("com.safb.tdd.entity");
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory.setJpaProperties(jpaProperties());

        return entityManagerFactory;
    }

    /**
     * @return The jdbc instance for connecting to the database.
     * @author Atanas Yordanov Arshinkov
     * @since 1.0.0
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
