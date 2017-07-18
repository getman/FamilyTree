package ru.aparfenov.familytree.photo.dao;

import ru.aparfenov.familytree.model.ElementDto;
import ru.aparfenov.familytree.model.ElementFactory;
import ru.aparfenov.familytree.model.Param;
import ru.aparfenov.familytree.model.elements.*;
import ru.aparfenov.familytree.storage.dao.StorageDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

/** Компонент, отвечающий за операции с представлением элемента фото в хранилище
 * Created by ArtemParfenov on 04.12.2016.
 */
@Stateless
public class PhotoDaoBean implements PhotoDao{
    @EJB(beanInterface = ru.aparfenov.familytree.storage.dao.FileDao.class)
    StorageDao storageDao;

    @Override
    public List<Element> getElementList(List<Param> params) {
        return null;
    }

    @Override
    public Element getElement(String id) {
        Element resultPerson = storageDao.getElement(id, new PhotoFactory() {

            @Override
            public Element buidlElement(ElementDto elementDto) {
                //формируем Photo из данных, полученных их Dao. Dao формирует список этих параметров на основе
                //информации из ru.aparfenov.familytree.model.ElementFactory.elementParamNames
                Photo newPhoto = new Photo(elementDto.getId());
                setupParam(elementDto, newPhoto);
                return newPhoto;
            }
        });
        return resultPerson;
    }

    @Override
    public Element getElementByParams(List<Param> params) {
        return storageDao.getElementByParams(params, new PhotoFactory() {
            @Override
            public Element buidlElement(ElementDto elementDto) {
                Photo newPhotoElement = new Photo(elementDto.getId());
                newPhotoElement.setComment((String) elementDto.getParam(COMMENT).getValue());
                return newPhotoElement;
            }
        });
    }

    @Override
    public void addElement(Element newElement) {

    }

    @Override
    public void remove(String id) {

    }

    public static abstract class PhotoFactory extends ElementFactory {
        {
            elementParamNames.add(CREATION_DATE);
            elementParamNames.add(COMMENT);
        }
        public static final String COMMENT = "comment";
        public static final String CREATION_DATE = "creation_date";

        @Override
        public void setupParam(ElementDto elementDto, Element elementToSetup){
            Photo updatingPhoto = (Photo)elementToSetup;
            updatingPhoto.setPhotoDate((Date) elementDto.getParam(CREATION_DATE).getValue());
            updatingPhoto.setComment((String) elementDto.getParam(COMMENT).getValue());
        }
    }
}
