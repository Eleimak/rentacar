package edu.besh.rentacar.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Objects;

@Document
public class Customer {
    @Id
    private int id;
    private Person client;
    private String address;
    private String phone;
    private String email;
    //private int bonusPoints;
    private List<Vehicle> vehiclesList;
    private boolean taken;

    public Customer() {
    }

    public Customer(Person client, String address, String phone, String email, List<Vehicle> vehiclesList, boolean taken) {
        this.client = client;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.vehiclesList = vehiclesList;
        this.taken = taken;
    }

    public Customer(int id, Person client, String address, String phone, String email, List<Vehicle> vehiclesList, boolean taken) {
        this.id = id;
        this.client = client;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.vehiclesList = vehiclesList;
        this.taken = taken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", client=" + client +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", vehiclesList=" + vehiclesList +
                ", taken=" + taken +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

/* База - контроллер */