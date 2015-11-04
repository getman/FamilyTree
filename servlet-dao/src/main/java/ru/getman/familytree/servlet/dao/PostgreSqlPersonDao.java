package ru.getman.familytree.servlet.dao;

import ru.getman.familytree.servlet.model.Person;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Artem Parfenov on 05.11.15.
 */
public class PostgreSqlPersonDao implements PersonDAO{
    //----------------Data members----------------
    private final Connection connection;

    //----------------Methods----------------
    public PostgreSqlPersonDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Person getPerson(int personId) {

        Person testPerson = new Person();
        testPerson.setAge((short) 32);
        testPerson.setName("Me");
        return testPerson;
    }

    @Override
    public void updatePerson(int personId) {

    }

    @Override
    public void addPerson(Person newPerson) {

    }

    @Override
    public void deletePerson(int personId) {

    }

    @Override
    public List<Person> getAllPerson() {
        return null;
    }
}
