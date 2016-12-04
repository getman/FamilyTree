package ru.aparfenov.familytree.dao;

import ru.aparfenov.familytree.elements.Element;
import ru.aparfenov.familytree.util.Param;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by ArtemParfenov on 01.12.2016.
 * Отвечает за работу c хранилищем элементов дерева - персоны, фото, обучение и т.д.
 */
@Remote
public interface ElementDao {
    /**Поиск элемента по совокупности его свойств
     * @param params свойства искомого элемента
     * @return элемент удовлетворяющий условиям поиска*/
    public Element findByParams(List<Param> params);
    /**Поиск элемента по его идентификатору
     * @param id идентификатор искомого элемента
     * @return элемент удовлетворяющий условиям поиска*/
    public Element findById(String id);
    /**Добавление нового элемента в хранилище
     * @param newElement новый элемент*/
    public void addNew(Element newElement);
    /**Обновление элемента в хранилище
     * @param targetElement элемент, свойства и данные которого нужно обновить*/
    public void update(Element targetElement);
    /**Удалить элемент по его идентификатору
     * @param id идентификатор удаляемого элемента*/
    public void remove(String id);

}
