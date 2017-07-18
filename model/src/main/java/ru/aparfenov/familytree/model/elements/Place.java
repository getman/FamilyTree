package ru.aparfenov.familytree.model.elements;

import ru.aparfenov.familytree.model.ElementTypes;

/**
 * Created by ArtemParfenov on 06.12.2016.
 */
public class Place extends Element {
    {
        type = ElementTypes.PLACE;
    }

    public static enum LatitudeType {
        SOUTH,NORTH
    }
    public static enum LongitudeType {
        EAST, WEST
    }

    /**Страна*/
    private String countryName;
    /**Область, край*/
    private String regionName;
    /**Город, село*/
    private String cityName;
    /**Географическая широта*/
    private long latitude;
    /**Широта северная/южная*/
    private LatitudeType latitudeType;
    /**Географическая долгота*/
    private long longitude;
    /**Долгота восточная/западная*/
    private LongitudeType longitudeType;
}
