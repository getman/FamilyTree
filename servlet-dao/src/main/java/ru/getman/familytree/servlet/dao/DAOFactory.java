package ru.getman.familytree.servlet.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Artem Parfenov on 31.10.15.
 * Factory of object for working with database objects
 */
public interface DAOFactory {
    /**generates a connection to the specific database*/
    public Connection getConnection() throws SQLException;
    /**returns an object to control the state of the Person object
     * @param connection Connection - DB connection object
     * @return PersonDAO - DAO object to control Person objects*/
    public PersonDAO getPersonDao(Connection connection);
}
