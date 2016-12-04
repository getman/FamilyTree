package ru.aparfenov.familytree.util;

/**
 * Created by ArtemParfenov on 04.12.2016.
 * Представляет параметр со свойствами элемента {Element}
 */
public class Param {
    /**Название параметра*/
    private String name;
    /**ЗНачение параметра*/
    private String value;

    public Param(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
