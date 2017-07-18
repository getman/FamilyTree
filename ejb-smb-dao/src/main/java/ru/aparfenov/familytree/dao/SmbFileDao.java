package ru.aparfenov.familytree.dao;


import ru.aparfenov.familytree.model.ElementDto;
import ru.aparfenov.familytree.model.ElementFactory;
import ru.aparfenov.familytree.model.Param;
import ru.aparfenov.familytree.model.elements.Element;
import ru.aparfenov.familytree.storage.dao.FileDao;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ArtemParfenov on 07.05.2017.
 */
@Stateless
public class SmbFileDao implements FileDao {
    private static final Logger logger = LogManager.getLogger(SmbFileDao.class);


    @Override
    public List<Element> getElementList(List<Param> params, ElementFactory elementFactory) {
        return null;
    }

    @Override
    public Element getElement(String id, ElementFactory elementFactory) {
        return null;
    }

    @Override
    public Element getElementByParams(List<Param> params, ElementFactory elementFactory) {
        ElementDto elementDto = new ElementDto();
        //подключение к удаленному Smb каталогу
//        SmbFile

        String personId = null;
        for (Param nextParam: params) {
            if (nextParam.getName().equals("photo_person_id")) {
                personId = (String) nextParam.getValue();
            }
        }
        String fileName = "my-file";
        String creationDate = "1970.01.01";
        List<String> elementParams = elementFactory.getElementParamNames();
        for (String nextParamName: elementParams) {
            logger.debug("Photo element parameters: " + nextParamName);
            elementDto.addParam(nextParamName, new Param(nextParamName, nextParamName +
                    ", person id: " + personId));
        }
        elementDto.setId("2");
        elementDto.addParam(elementParams.get(0), new Param(elementParams.get(0), ""));

        return elementFactory.buidlElement(elementDto);
    }

    @Override
    public void addElement(Element newElement, ElementFactory elementFactory) {

    }

    @Override
    public void removeElement(String id, ElementFactory elementFactory) {

    }

    @Override
    public void init() {

    }
}
