package ru.aparfenov.familytree.manager;

import ru.aparfenov.familytree.elements.Element;
import ru.aparfenov.familytree.dao.ElementDao;
import ru.aparfenov.familytree.util.Param;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ArtemParfenov on 04.12.2016.
 * Управляет загрузкой элементов, уровнями детализации, осуществляет поиск, оперирует сущностями: хранит сущности,
 * добавление, удаление
 */
@Stateless
public class Manager {

    @EJB
    private ElementDao elementDao;

    /**Поиск элемента {ru.aparfenov.familytree.elements.Element} по параметрам
     * @param params список параметров {ru.aparfenov.familytree.util.Param} для поиска элемента
     * @return элемент удовлетворяющий условиям поиска*/
    public Element findElement(List<Param> params) {
        return elementDao.findByParams(params);
    }

    /**Поиск элемента {ru.aparfenov.familytree.elements.Element} по ID
     * @param id идентификатор элемента*/
    public Element findElementById(String id) {
        return elementDao.findById(id);
    }

    /**Добавляет в хранилище новый элемент {ru.aparfenov.familytree.elements.Element}
     * @param newElement новый элемент*/
    public void addNewElement(Element newElement) {
        elementDao.addNew(newElement);
    }

    /**Удаляет элемент по его идентификатору*/
    public void removeElement(String id) {
        elementDao.remove(id);
    }

}
