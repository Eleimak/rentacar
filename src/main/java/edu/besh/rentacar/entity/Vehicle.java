package edu.besh.rentacar.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;

@Document
public class Vehicle {
    @Id
    private int id;
    private String brand;
    private String model;
    private double cost;
    private String licensePlate;
    private Types type;
    private int yearOfIssue;
    private int rentalFee;
    private boolean maintenance;
    private boolean taken;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, double cost, String licensePlate, Types type, int yearOfIssue,
                   int rentalFee, boolean maintenance, boolean taken) {
        this.brand = brand;
        this.model = model;
        this.cost = cost;
        this.licensePlate = licensePlate;
        this.type = type;
        this.yearOfIssue = yearOfIssue;
        this.rentalFee = rentalFee;
        this.maintenance = maintenance;
        this.taken = taken;
    }

    public Vehicle(int id, String brand, String model, double cost, String licensePlate, Types type, int yearOfIssue,
                   int rentalFee, boolean maintenance, boolean taken) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.cost = cost;
        this.licensePlate = licensePlate;
        this.type = type;
        this.yearOfIssue = yearOfIssue;
        this.rentalFee = rentalFee;
        this.maintenance = maintenance;
        this.taken = taken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public int getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(int rentalFee) {
        this.rentalFee = rentalFee;
    }

    public boolean isMaintenance() {
        return maintenance;
    }

    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                ", licensePlate='" + licensePlate + '\'' +
                ", type=" + type +
                ", yearOfIssue=" + yearOfIssue +
                ", rentalFee=" + rentalFee +
                ", maintenance=" + maintenance +
                ", taken=" + taken +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return getId() == vehicle.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}