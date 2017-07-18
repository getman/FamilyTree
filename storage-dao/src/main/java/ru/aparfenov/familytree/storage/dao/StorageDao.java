package ru.aparfenov.familytree.storage.dao;


import ru.aparfenov.familytree.model.Param;
import ru.aparfenov.familytree.model.elements.Element;
import ru.aparfenov.familytree.model.ElementFactory;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

/**
 * Created by ArtemParfenov on 27.05.2017.
 */
@Local
public interface StorageDao {
    public List<Element> getElementList(List<Param> params, ElementFactory elementFactory);
    public Element getElement(String id, ElementFactory elementFactory);
    public Element getElementByParams(List<Param> params, ElementFactory elementFactory);
    public void addElement(Element newElement, ElementFactory elementFactory);
    public void removeElement(String id, ElementFactory elementFactory);
    /**инициализация ресурсов хранилища*/
    public void init();
}
