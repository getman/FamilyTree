package ru.getman.familytree.servlet.dao;

import ru.getman.familytree.servlet.model.Person;

import java.util.List;

/**
 * Created by Artem Parfenov on 31.10.15.
 */
public interface PersonDAO {
    public Person getPerson(int personId);
    public void updatePerson(int personId);
    public void addPerson(Person newPerson);
    public void deletePerson(int personId);
    public List<Person> getAllPerson();
}
