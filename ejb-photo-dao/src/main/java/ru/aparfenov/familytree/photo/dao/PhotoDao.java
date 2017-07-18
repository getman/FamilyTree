package ru.aparfenov.familytree.photo.dao;

import ru.aparfenov.familytree.model.dao.ElementDao;
import ru.aparfenov.familytree.model.elements.Photo;

import javax.ejb.Remote;
import java.util.List;

/** DAO для доступа к представлению объекта Photo в хранилище (файловое, БД)
 * Created by ArtemParfenov on 05.05.2017.
 */
@Remote
public interface PhotoDao extends ElementDao {
}