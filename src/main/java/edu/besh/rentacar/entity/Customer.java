package edu.besh.rentacar.entity;

import java.util.List;

public class Customer {
    private int id;
    private Person person;
    private String address;
    private String phone;
    private String eMail;
    private int bonusPoints;
    private List<Vehicle> vehiclesList;
    private boolean rent;
}

/* База - контроллер */