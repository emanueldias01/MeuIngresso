package br.com.emanueldias.MeuIngresso.repository;

import java.sql.Connection;

public class RepositoryDefault{
    protected Connection conn;

    public RepositoryDefault(Connection connection){
        this.conn = connection;
    }

}
