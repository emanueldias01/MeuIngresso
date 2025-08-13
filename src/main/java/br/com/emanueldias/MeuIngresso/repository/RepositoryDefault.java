package br.com.emanueldias.MeuIngresso.repository;

import javax.sql.DataSource;
import java.sql.SQLException;

public class RepositoryDefault{
    protected final DataSource dataSource;

    public RepositoryDefault(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
    }

}
