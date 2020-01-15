package edu.besh.rentacar.forms;

import edu.besh.rentacar.entity.Types;

public class VehicleForm {
    private int id;
    private String brand;
    private String model;
    private double cost;
    private String licensePlate;
    private String type;
    private int yearOfIssue;
    private int rentalFee;
    private boolean maintenance;
    private boolean taken;

    public VehicleForm() {
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
    public String getType() {
        return type;
    }

    public void setType(String type) {
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
        return "VehicleForm{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                ", licensePlate='" + licensePlate + '\'' +
                ", type='" + type + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", rentalFee=" + rentalFee +
                ", maintenance=" + maintenance +
                ", taken=" + taken +
                '}';
    }

}