package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportApartmentRootDto {

    @XmlElement(name = "apartment")
    private List<ImportApartmentDto> apartments;

    public List<ImportApartmentDto> getApartments() {
        return apartments;
    }

    public void setApartments(List<ImportApartmentDto> apartments) {
        this.apartments = apartments;
    }
}
