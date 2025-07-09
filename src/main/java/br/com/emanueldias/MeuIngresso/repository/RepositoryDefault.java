package br.com.emanueldias.MeuIngresso.repository;

import java.sql.Connection;

public class RepositoryDefault{
    private Connection conn;

    public RepositoryDefault(Connection connection){
        this.conn = connection;
    }

}
