package ru.aparfenov.familytree.dao.db;

import ru.aparfenov.familytree.dao.ElementDao;

import javax.ejb.Remote;

/**
 * Created by ArtemParfenov on 04.12.2016.
 * Отвечает за работу c элементами в БД
 */
@Remote
public interface ElementDbDao extends ElementDao {
}
