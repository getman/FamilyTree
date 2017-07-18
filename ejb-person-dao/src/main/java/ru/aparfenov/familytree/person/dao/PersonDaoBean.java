package ru.aparfenov.familytree.person.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.aparfenov.familytree.model.ElementDto;
import ru.aparfenov.familytree.model.ElementFactory;
import ru.aparfenov.familytree.model.Param;
import ru.aparfenov.familytree.model.elements.Element;
import ru.aparfenov.familytree.model.elements.Person;
import ru.aparfenov.familytree.storage.dao.StorageDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/** Компонент, отвечающий за операции с представлением элемента персоны в хранилище
 * Created by ArtemParfenov on 04.12.2016.
 * */
@Stateless
public class PersonDaoBean implements PersonDao {
    private static final Logger logger = LogManager.getLogger(PersonDaoBean.class);

    //    @EJB(lookup = "java:global/ejb-postges-dao/PersonDaoBean")
//    @EJB(lookup = "java:global/ear-person-processor/ejb-person-dao/PersonDaoBean!ru.aparfenov.familytree.person.dao.PersonDao")
//    @EJB(beanName = "ru.aparfenov.familytree.dao.db.porstgres.PostgesDaoBean")
    @EJB(beanInterface = ru.aparfenov.familytree.storage.dao.DbDao.class)
    StorageDao storageDao;

    @Override
    public List<Element> getElementList(List<Param> params) {
        List<Element> resultPersonList = storageDao.getElementList(params, new PersonFactory() {
            @Override
            public Element buidlElement(ElementDto elementDto) {
                //формируем Person из данных, полученных их Dao. Dao формирует список этих параметров на основе
                //информации из ru.aparfenov.familytree.model.ElementFactory.elementParamNames
                Person newPerson = new Person(elementDto.getId());
                setupParam(elementDto, newPerson);
                return newPerson;
            }
        });
        return resultPersonList;
    }

    @Override
    public Element getElement(String id) {
        Element resultPerson = storageDao.getElement(id, new PersonFactory() {
            @Override
            public Person buidlElement(ElementDto elementDto) {
                //формируем Person из данных, полученных их Dao. Dao формирует список этих параметров на основе
                //информации из ru.aparfenov.familytree.model.ElementFactory.elementParamNames
                Person newPerson = new Person(elementDto.getId());
                setupParam(elementDto, newPerson);
                return newPerson;
            }
        });
        return resultPerson;
    }

    @Override
    public Element getElementByParams(List<Param> params) {
        return null;
    }

    @Override
    public void addElement(Element newElement) {
        storageDao.addElement(newElement, new PersonFactory() {
            @Override
            public Element buidlElement(ElementDto elementDto) {
                return null;
            }
        });
    }

    @Override
    public void remove(String id) {
        storageDao.removeElement(id, new PersonFactory() {
            @Override
            public Element buidlElement(ElementDto elementDto) {
                return null;
            }
        });
    }

    public static abstract class PersonFactory extends ElementFactory {
        {
            elementParamNames.add(FIRST_NAME);
            elementParamNames.add(LAST_NAME);
            elementParamNames.add(BIRTHDAY);
        }
        public static final String FIRST_NAME = "FIRST_NAME";
        public static final String LAST_NAME = "LAST_NAME";
        public static final String BIRTHDAY = "BIRTH_DAY";

        @Override
        public void setupParam(ElementDto elementDto, Element elementToSetup){
            Person updatingPersnon = (Person)elementToSetup;
            logger.debug("Setup parameters from element DTO:" + elementDto);
            updatingPersnon.setFirstName((String) elementDto.getParam(FIRST_NAME).getValue());
            updatingPersnon.setLastName((String) elementDto.getParam(LAST_NAME).getValue());
        }
    }
}
