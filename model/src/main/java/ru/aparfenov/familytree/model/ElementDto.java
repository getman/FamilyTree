package ru.aparfenov.familytree.model;
import ru.aparfenov.familytree.model.elements.Element;

import java.util.HashMap;
import java.util.Map;

/**DTO для формирования элемента
 * Created by ArtemParfenov on 29.05.2017.
 */
public class ElementDto {
    /**идентификатор для Element*/
    private String id;
    //TODO Необходим рефакторинг - использование имени параметра в качестве ключа очевидный overhead
    /**перечень имен параметров и параметров для формирования {@link Element}*/
    private Map<String, Param> paramList = new HashMap<>();

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addParam(String paramName, Param newParam) {
        this.paramList.put(paramName, newParam);
    }

    public Param getParam(String paramName) {
        return paramList.get(paramName);
//        return new Param("hello", "world");
    }

    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry nextEntry: paramList.entrySet()) {
            sb.append(nextEntry.getKey());
            sb.append(":");
            sb.append(nextEntry.getValue());
            sb.append("/");
        }
        return sb.toString();
    }*/
}
