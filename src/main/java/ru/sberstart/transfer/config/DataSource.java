//package ru.sberstart.transfer.config;
//
//import com.zaxxer.hikari.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Properties;
//
//@Component
//public class DataSource {
//    private static HikariDataSource dataSource;
//
//    static {
//        try {
//            HikariConfig config = new HikariConfig();
//            Properties properties = new Properties();
//            properties.load(DataSource.class.getResourceAsStream("/db.properties"));
//            config.setJdbcUrl(properties.getProperty("db.url"));
//            config.setUsername(properties.getProperty("db.user"));
//            config.setPassword(properties.getProperty("db.password"));
//            config.setDriverClassName(properties.getProperty("db.driver.name"));
//            dataSource = new HikariDataSource(config);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private DataSource() {}
//
//    @Bean
//    public static HikariDataSource getDataSource() {
//        return dataSource;
//    }
//
//    @Bean
//    public static Connection getConnection() throws SQLException {
//        return dataSource.getConnection();
//    }
//}
