package ru.aparfenov.familytree.manager;

import ru.aparfenov.familytree.model.Param;
import ru.aparfenov.familytree.model.dao.ElementDao;
import ru.aparfenov.familytree.model.elements.Element;
import ru.aparfenov.familytree.model.ElementTypes;
import ru.aparfenov.familytree.person.dao.PersonDao;
import ru.aparfenov.familytree.photo.dao.PhotoDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/** Определяет соответствующие DAO для работы с представлениями объектов
 * {@link Element} в хранилище (файловое, БД,...)
 * Created by ArtemParfenov on 23.12.2016.
 */

@Stateless
public class ElementDaoFactory {
    @EJB
    private PersonDao personDao;

    @EJB
    private PhotoDao photoDao;

    private ElementDao getDao(ElementTypes elementType) {
        ElementDao result = null;
        switch (elementType) {
            case PERSON:
                result = personDao;
                break;
            case PHOTO:
                result = photoDao;
                break;
            default:
                break;
        }
        return result;
    }

    public List<Element> getList(List<Param> params, ElementTypes elementType) {
        return this.getDao(elementType).getElementList(params);
    }

    public Element getElement(String id, ElementTypes elemnType) {
        return this.getDao(elemnType).getElement(id);
    }

    public Element getElement(List<Param> params, ElementTypes elemnType) {
        return this.getDao(elemnType).getElementByParams(params);
    }

    public void addElement(Element newElement) {
        this.getDao(newElement.getType()).addElement(newElement);
    }

    public void remove(String id, ElementTypes elemnType) {
        this.getDao(elemnType).remove(id);
    }


}
