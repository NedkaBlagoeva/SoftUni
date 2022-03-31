package com.example.ex.model.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameAddDto {
    // AddGame|<title>|<price>|<size>|<trailer>|<thumbnailURL>|<description>|<releaseDate>
    @Pattern(regexp = "([A-Z])[^\\s]{2,100}", message = "Enter valid title")
    private String title;
    @Positive (message = "Enter valid price")
    private BigDecimal price;
    @Positive(message = "Enter valid size")
    private Double size;
    @Size(min = 11, max = 11, message = "Enter valid trailer id")
    private String trailer;
    @Pattern(regexp = "([h][t][t][p][s]*[:]\\/\\/).+", message = "Enter valid Thumbnail")
    private String imageThumbnail;
    @Size(min = 20, message = "Enter valid description")
    private String description;

    private LocalDate releaseDate;

    public GameAddDto(String title, BigDecimal price, Double size, String trailer, String imageThumbnail, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public GameAddDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
