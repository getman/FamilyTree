package ru.aparfenov.familytree.person.dao;

import ru.aparfenov.familytree.model.dao.ElementDao;

import javax.ejb.Local;
import javax.ejb.Remote;

/** DAO для доступа к представлению объекта Person в хранилище (файловое, БД)
 * Created by Artem Parfenov on 31.10.15.
 */
@Local
public interface PersonDao extends ElementDao {
}

