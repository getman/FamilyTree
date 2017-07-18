package ru.aparfenov.familytree.manager;

import ru.aparfenov.familytree.model.elements.Element;
import ru.aparfenov.familytree.model.ElementTypes;
import ru.aparfenov.familytree.model.Param;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ArtemParfenov on 04.12.2016.
 * Управляет загрузкой элементов, уровнями детализации, осуществляет поиск, оперирует сущностями: хранит сущности,
 * добавление, удаление
 */

@Stateless
public class ElementManager {
    @EJB
    private ElementDaoFactory daoFactory;


    public List<Element> getElements(List<Param> params, ElementTypes elementType) {
        return daoFactory.getList(params, elementType);
    }

    /**Поиск элемента {ru.aparfenov.familytree.model.elements.Element} по параметрам
     * @param params список параметров {ru.aparfenov.familytree.util.OLdParam} для поиска элемента
     * @return элемент удовлетворяющий условиям поиска*/
    public Element findElementByParams(List<Param> params, ElementTypes elementType) {
        return daoFactory.getElement(params, elementType);
    }

    /**Поиск элемента {ru.aparfenov.familytree.model.elements.Element} по ID
     * @param id идентификатор элемента*/
    public Element findElementById(String id, ElementTypes elementType) {
        return daoFactory.getElement(id, elementType);
    }

    /**Добавляет в хранилище новый элемент {ru.aparfenov.familytree.model.elements.Element}
     * @param newElement новый элемент*/
    public void addNewElement(Element newElement) {
        daoFactory.addElement(newElement);
    }

    /**Удаляет элемент по его идентификатору*/
    public void removeElement(String id, ElementTypes elementType) {
        daoFactory.remove(id, elementType);
    }

}
