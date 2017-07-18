package ru.aparfenov.familytree.model;

import ru.aparfenov.familytree.model.elements.Element;

import java.io.Serializable;
import java.util.*;

/**
 * Created by ArtemParfenov on 27.05.2017.
 */
public abstract class ElementFactory implements Serializable{
    /**наименование параметра для идентификатора Element*/
    public static final String ELEMENT_ID_PARAM_NAME = "id";
    /**список имен параметров для формирования элемента. Заполняется в статических инициализаторах
     * каждой реализации ElementFactory*/
    protected final List<String> elementParamNames = new ArrayList<>();

    /**ElementDto хранит данные об элементе Element, которые он получил по запросу от хранилища, на основании
     * этих данных формируется объект Element */
    public abstract Element buidlElement(ElementDto elementDto);
    public List<Element> buidlElementList(List<ElementDto> elementDtoList) {
        List<Element> result = new ArrayList<>();
        for (ElementDto nextDto: elementDtoList) {
            Element nextElement = this.buidlElement(nextDto);
            result.add(nextElement);
        }
        return result;
    }

    /**Возвращает список имен параметров
     * @return массив имен параметров */
    public List<String> getElementParamNames() {
        return elementParamNames;
    }

    /**назначает параметры указанному элементу
     * @param elementDto - содержит параметры элемента
     * @param elementToSetup - элемент для приема паратетров
     * @return Element */
    public abstract void setupParam(ElementDto elementDto, Element elementToSetup);
}
