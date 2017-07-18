package ru.aparfenov.familytree.model.dao;

import ru.aparfenov.familytree.model.Param;
import ru.aparfenov.familytree.model.elements.Element;

import java.util.List;

/**
 * Отвечает за работу c хранилищем (файловое, БД) элементов дерева - персоны, фото, обучение и т.д.
 * Created by ArtemParfenov on 01.12.2016.
 */
public interface ElementDao {
    public List<Element> getElementList(List<Param> params);
    public Element getElement(String id);
    public Element getElementByParams(List<Param> params);
    /**Добавление нового элемента в хранилище
     * @param newElement новый элемент*/
    public void addElement(Element newElement);
    /**Удалить элемент по его идентификатору
     * @param id идентификатор удаляемого элемента*/
    public void remove(String id);
}
