package ru.getman.familytree.servlet.test;

import org.junit.Test;
import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Artem Parfenov on 05.11.15.
 */
public class DbConnectionTest {
    //------------Data members-----------
    private static String host;
    private static String dbName;
    private static String user;
    private static String password;

    //------------Methods-----------
    @Test
    public void testDbConnection() throws IOException, SQLException {
        //property resource stores a source data for testing - schedule templates and launch time parameters
        Properties prop = loadProperties("db-test.properties");
        host = prop.getProperty("host");
        dbName = prop.getProperty("dbName");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
        DataSource ds = getPostgreDataSource();
        Connection connection = ds.getConnection();
        Statement callable = connection.createStatement();
        ResultSet rs = callable.executeQuery("SELECT * FROM test");
        if (rs.next()) {
            System.out.println("Data base is available");
        }
    }

    private static Properties loadProperties(String propertyFileName) throws IOException {
        Properties prop = new Properties();
        InputStream propertiesInputStream = DbConnectionTest.class.getClassLoader().getResourceAsStream(propertyFileName);
        if (propertiesInputStream != null) {
            prop.load(propertiesInputStream);
        } else {
            throw new FileNotFoundException("property file '" + propertyFileName + "' not found in the classpath");
        }
        return prop;
    }

    private static DataSource getPostgreDataSource() {
        PGPoolingDataSource source = new PGPoolingDataSource();
        source.setDataSourceName("A Data Source");
        source.setServerName(host);
        source.setDatabaseName(dbName);
        source.setUser(user);
        source.setPassword(password);
        source.setMaxConnections(10);
        return source;
    }
}
