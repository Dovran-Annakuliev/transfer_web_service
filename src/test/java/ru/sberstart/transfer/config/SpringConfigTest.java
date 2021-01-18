package ru.sberstart.transfer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.sql.DataSource;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Configuration
@EnableTransactionManagement
@ComponentScan("ru.sberstart.transfer")
public class SpringConfigTest {
    private final ApplicationContext applicationContext;

    @Autowired
    public SpringConfigTest(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public DataSource dataSource() throws IOException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/transfer");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:/schema.sql';MODE=PostgreSQL;\n");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("password");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws IOException {
        return new JdbcTemplate(dataSource());
    }


}