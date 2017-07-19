package ru.aparfenov.familytree.photo.dao;

import ru.aparfenov.familytree.model.dao.ElementDao;

import javax.ejb.Local;

/** DAO для доступа к представлению объекта Photo в хранилище (файловое, БД)
 * Created by ArtemParfenov on 05.05.2017.
 */
@Local
public interface PhotoDao extends ElementDao {
}