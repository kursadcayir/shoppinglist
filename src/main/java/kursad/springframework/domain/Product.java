package kursad.springframework.domain;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Locale;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String description;
private BigDecimal price;
private String imageUrl;
private String cat;

@Version
private Integer version;



    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat=cat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
