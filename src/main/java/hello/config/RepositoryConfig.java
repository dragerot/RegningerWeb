package hello.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//http://stackoverflow.com/questions/25185023/spring-jpa-org-springframework-orm-jpa-localcontainerentitymanagerfactorybean

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = { "hello.persistence" })
public class RepositoryConfig {

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource()); //createEmbeddedDataSource());
//        em.setPackagesToScan("hello");
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//
//        Properties jpaProperties = new Properties();
//        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        jpaProperties.setProperty("hibernate.format_sql", "true");
//        jpaProperties.setProperty("hibernate.show_sql", "false");
//        //hibernate.implicit_naming_strategy hibernate.physical_naming_strategy
//        //jpaProperties.setProperty("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
//        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//        jpaProperties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
//        em.setJpaProperties(jpaProperties);
//
//        return em;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
//        return new PersistenceAnnotationBeanPostProcessor();
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//
//
//    @Bean
//    //@Profile("test")
//    public DataSource dataSource() {
//        DataSource dataSource =
//         new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
////                .setName("BETSYSTESTKOMPONENT")
////                .addScript("classpath:/sql/DROP_H2_SCHEMA.sql")
////               .addScript("classpath:/sql/H2_SCHEMA.sql")
////                .addScript("classpath:/sql/schema-h2.sql")
//                .build();
//        return dataSource;
//    }
//
//    @SuppressWarnings("unchecked")
//    public static <T> T getJndiObject(final String jndiName, final Class<T> expectedType) throws NamingException {
//        JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
//        factory.setJndiName(jndiName);
//        factory.setExpectedType(expectedType);
//        factory.afterPropertiesSet();
//
//        return (T) factory.getObject();
//    }

    //    @Bean(name = "entityManagerFactory")
//    @Profile({ "prod", "default" })
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(createProductionDataSource());
//        em.setPackagesToScan("hello.entities");
//        Properties jpaProperties = new Properties();
//        jpaProperties.setProperty("hibernate.show_sql", "true");
//        jpaProperties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
//        em.setJpaProperties(jpaProperties);
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//
//        return em;
//    }

//    @Bean
//    @Profile({ "prod", "default" })
//    public DataSource createProductionDataSource() throws NamingException {
//        return getJndiObject("java:jboss/datasources/BetsystestkomponentDS", DataSource.class);
//    }

}