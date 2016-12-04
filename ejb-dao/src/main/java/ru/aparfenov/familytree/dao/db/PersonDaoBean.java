package ru.aparfenov.familytree.dao.db;

import ru.aparfenov.familytree.elements.Element;
import ru.aparfenov.familytree.util.Param;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.util.List;

/**
 * Created by ArtemParfenov on 04.12.2016.
 * Отвечает за операции с БД для элемента персоны
 */
@Stateless
public class PersonDaoBean implements ElementDbDao {
    /**Соединение с БД*/
    @Resource
    Connection dbConnection;

    public Element findByParams(List<Param> params) {
        return null;
    }

    public Element findById(String id) {
        return null;
    }

    public void addNew(Element newElement) {

    }

    public void update(Element targetElement) {

    }

    public void remove(String id) {

    }
}
