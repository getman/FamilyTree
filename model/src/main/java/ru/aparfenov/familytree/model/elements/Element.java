package ru.aparfenov.familytree.model.elements;

import ru.aparfenov.familytree.model.ElementTypes;

import java.io.Serializable;

/**
 * Created by ArtemParfenov on 04.12.2016.
 * Абстрактный класс для представления элементов - персона, фото, образование и т.д.
 */
public abstract class Element implements Serializable{
    /**Тип элемента*/
    protected ElementTypes type;

    /**Идентификатор элемента*/
    private String id;

    public Element() {}

    public Element(String id) {
        this.id = id;
    }

    /**Возвращает идентификатор элемента*/
    public String getId() {
        return id;
    }

    /**Возвращает тип элемента*/
    public ElementTypes getType() {
        return type;
    }
}
