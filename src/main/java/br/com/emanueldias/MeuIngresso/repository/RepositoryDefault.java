package br.com.emanueldias.MeuIngresso.repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class RepositoryDefault{
    private final DataSource dataSource;
    protected Connection conn;

    public RepositoryDefault(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        this.conn = dataSource.getConnection();
    }

}
