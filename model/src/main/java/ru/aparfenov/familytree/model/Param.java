package ru.aparfenov.familytree.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ArtemParfenov on 04.12.2016.
 * Представляет параметр со свойствами элемента {Element}
 */
public class Param<T> implements Serializable{
    /**Название параметра*/
    private String name;
    /**ЗНачение параметра*/
    private T value;

    public Param(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public void setTypeName(String typeName) {

    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return (T) value;
    }
}

