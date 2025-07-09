package br.com.emanueldias.MeuIngresso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Configuration
public class BeansConfig {

    @Bean
    public DataSource dataSource(){
        return new DataSource() {
            @Override
            public Connection getConnection() throws SQLException {
                return DriverManager.getConnection("jdbc:postgresql://localhost:5432/MeuIngresso?user=admin&password=admin123");
            }

            @Override
            public Connection getConnection(String s, String s1) throws SQLException {
                return null;
            }

            @Override
            public PrintWriter getLogWriter() throws SQLException {
                return null;
            }

            @Override
            public void setLogWriter(PrintWriter printWriter) throws SQLException {

            }

            @Override
            public void setLoginTimeout(int i) throws SQLException {

            }

            @Override
            public int getLoginTimeout() throws SQLException {
                return 0;
            }

            @Override
            public <T> T unwrap(Class<T> aClass) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> aClass) throws SQLException {
                return false;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        };
    }
}
