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
    private List<Vehicle> vehiclesList;
    private boolean tookCar;

    public Customer() {
    }

    public Customer(Person client, String address, String phone, String email, List<Vehicle> vehiclesList, boolean tookCar) {
        this.client = client;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.vehiclesList = vehiclesList;
        this.tookCar = tookCar;
    }

    public Customer(int id, Person client, String address, String phone, String email, List<Vehicle> vehiclesList, boolean taken) {
        this.id = id;
        this.client = client;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.vehiclesList = vehiclesList;
        this.tookCar = tookCar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public List<Vehicle> getVehiclesList() {
        return vehiclesList;
    }

    public void setVehiclesList(List<Vehicle> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }

    public boolean isTookCar() {
        return tookCar;
    }

    public void setTookCar(boolean tookCar) {
        this.tookCar = tookCar;
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
        return tookCar;
    }

    public void setTaken(boolean taken) {
        this.tookCar = tookCar;
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
                ", tookCar=" + tookCar +
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
