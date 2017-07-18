package ru.aparfenov.familytree.model.elements;

import ru.aparfenov.familytree.model.ElementTypes;

import java.util.Date;

/**
 * Created by ArtemParfenov on 04.12.2016.
 * Представляет java-объект Персоны
 */
public class Person extends Element {
    {
        type = ElementTypes.PERSON;
    }

    public Person(String id) {
        super(id);
    }

    /**Имя персоны*/
    private String firstName;
    /**Фамилия персоны*/
    private String lastName;
    /**Имя отца персоны*/
    private String fatherName;
    /**Время рождения в миллисекундах*/
    private Date birthDay;
    /**Место рождения*/
    private Place birthPlace;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Place getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Place birthPlace) {
        this.birthPlace = birthPlace;
    }
}
