package ru.getman.familytree.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Artem Parfenov on 04.11.15.
 */
public class PostgreSqlDaoFactory implements DAOFactory {
    //-------------Data members-----------------
    private String user = "postgres";
    private String password = "postgres";
    private String host = "127.0.0.1";
    private String port = "5432";
    private String dbname = "family_tree";
    private String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbname;
    private String driverName = "org.postgresql.Driver";

    //---------------Methods-----------------
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public PersonDAO getPersonDao(Connection connection) {
        return new PostgreSqlPersonDao(connection);
    }
}
