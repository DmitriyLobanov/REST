package com.lobanov.rest.model;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "passport_number")
    String passportNumber;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private User user;

    public Long getId() {
        return id;
    }

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Passport() {

    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    /*public Passport(Long id, String passportNumber, User user) {
        this.id = id;
        this.passportNumber = passportNumber;
        this.user = user;
    }*/
}
