package ru.aparfenov.familytree.elements;

/**
 * Created by ArtemParfenov on 04.12.2016.
 * Представление элементов - персона, фото, образование и т.д.
 */
public abstract class Element {
    /**Идентификатор элемента*/
    private String id;
    /**Тип элемента*/
    protected ElementTypes type;

    public Element() {}

    public Element(String id, ElementTypes type) {
        this.id = id;
        this.type = type;
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
