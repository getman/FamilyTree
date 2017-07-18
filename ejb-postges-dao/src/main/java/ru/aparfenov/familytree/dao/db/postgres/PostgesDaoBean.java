package ru.aparfenov.familytree.dao.db.postgres;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import ru.aparfenov.familytree.model.elements.Element;
import ru.aparfenov.familytree.model.ElementFactory;
import ru.aparfenov.familytree.model.Param;
import ru.aparfenov.familytree.storage.dao.DbDao;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ArtemParfenov on 28.05.2017.
 */
@Stateless
public class PostgesDaoBean implements DbDao {

    private static final Logger logger = LogManager.getLogger(PostgesDaoBean.class);

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
        return null;
    }

    public void addElement(Element newElement, ElementFactory elementFactory) {
    }

    public void removeElement(String id, ElementFactory elementFactory) {
    }

    public void init() {

    }
}
