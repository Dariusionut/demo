package com.example.demo.university;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class University {
    @Id
    @SequenceGenerator(name = "university_sequence",
            sequenceName = "university_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "university_sequence"
    )
    private Long id;
    @NotBlank(message = "Name is mandatory!")
    private String name;
    @NotBlank(message = "Country is mandatory!")
    private String country;
    @NotBlank(message = "City is mandatory!")
    private String city;

    public University() {
    }

    public University(Long id, String name, String country, String city) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public University(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
