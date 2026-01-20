package com.example.backend.entity;

import jakarta.persistence.*;

@Entity //indique a jpa/hibernate que cette class correspond a une table en base
        // de donnees  par defaut la table s'appellera housing_location
public class HousingLocation {

    @Id //cle primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY => indique que l'id est autoincrement
    private Long id;

    private String name;
    private String city;
    private String state;
    private String photo;
    private int availableUnits;
    private boolean wifi;
    private boolean laundry;

    @ManyToOne
    @JoinColumn(name = "user_id") // this creates the foreign key column
    private User user;

    // Constructors
    public HousingLocation() {} //contructor vide obligatoire pour jpa

    public HousingLocation(String name, String city, String state, String photo,
                           int availableUnits, boolean wifi, boolean laundry, User user) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.photo = photo;
        this.availableUnits = availableUnits;
        this.wifi = wifi;
        this.laundry = laundry;
        this.user = user;
    } //ce constructor n'est pas obligatoire juste pour facilite la creation d'objets dans le code
    //jpa cree les objets sans parametres quand il lit les donnees depuis la base

    // Getters & Setters obligatoire pour jpa quand lire ou ecrire les valeurs depuis la base
    //getters quand spring returne du json -- spring -> angular
    //setters == angular -> spring
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }
    public int getAvailableUnits() { return availableUnits; }
    public void setAvailableUnits(int availableUnits) { this.availableUnits = availableUnits; }
    public boolean isWifi() { return wifi; }
    public void setWifi(boolean wifi) { this.wifi = wifi; }
    public boolean isLaundry() { return laundry; }
    public void setLaundry(boolean laundry) { this.laundry = laundry; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
