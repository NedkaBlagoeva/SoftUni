package softuni.exam.instagraphlite.models.dto;

import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPostDto {

    @XmlElement
    @Size(min = 21)
    @NotNull
    private String caption;

    @XmlElement
    @NotNull
    private UserNameDto user;

    @XmlElement
    @NotNull
    private PicturePathDto picture;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public UserNameDto getUser() {
        return user;
    }

    public void setUser(UserNameDto user) {
        this.user = user;
    }

    public PicturePathDto getPicture() {
        return picture;
    }

    public void setPicture(PicturePathDto picture) {
        this.picture = picture;
    }
}
