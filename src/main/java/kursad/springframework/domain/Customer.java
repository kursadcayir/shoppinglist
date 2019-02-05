package kursad.springframework.domain;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String surname;
    private String email;
    private String phonenumber;
    private String adressline;
    private String adressline2;
    private String city;
    private String state;
    private String zipcode;
    private Integer id;
    @Version
    private Integer version;



    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAdressline() {
        return adressline;
    }

    public void setAdressline(String adressline) {
        this.adressline = adressline;
    }

    public String getAdressline2() {
        return adressline2;
    }

    public void setAdressline2(String adressline2) {
        this.adressline2 = adressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

