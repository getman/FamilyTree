package ru.aparfenov.familytree.model.elements;

import ru.aparfenov.familytree.model.ElementTypes;

import java.util.Date;

/**
 * Created by ArtemParfenov on 04.12.2016.
 * Представляет один экземпляр фотографии персоны
 */
public class Photo extends Element{
    {
        type = ElementTypes.PHOTO;
    }

    /**дата создания фото*/
    private Date photoDate;
    /**комментарий к фотографии*/
    private String comment;

    public Photo(String id) {
        super(id);
    }

    public Date getPhotoDate() {
        return photoDate;
    }

    public void setPhotoDate(Date photoDate) {
        this.photoDate = photoDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
