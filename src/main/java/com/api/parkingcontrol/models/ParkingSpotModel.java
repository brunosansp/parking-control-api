package com.api.parkingcontrol.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;

    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;

    @Column(nullable = false, length = 70)
    private String brandCar;

    @Column(nullable = false, length = 70)
    private String modelCar;

    @Column(nullable = false, length = 70)
    private String colorCar;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false, length = 130)
    private String responsibleName;

    @Column(nullable = false, length = 30)
    private String apartment;

    @Column(nullable = false, length = 30)
    private String block;

    public UUID getId() {
        return id;
    }

    public ParkingSpotModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public ParkingSpotModel setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
        return this;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public ParkingSpotModel setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
        return this;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public ParkingSpotModel setBrandCar(String brandCar) {
        this.brandCar = brandCar;
        return this;
    }

    public String getModelCar() {
        return modelCar;
    }

    public ParkingSpotModel setModelCar(String modelCar) {
        this.modelCar = modelCar;
        return this;
    }

    public String getColorCar() {
        return colorCar;
    }

    public ParkingSpotModel setColorCar(String colorCar) {
        this.colorCar = colorCar;
        return this;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public ParkingSpotModel setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public ParkingSpotModel setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
        return this;
    }

    public String getApartment() {
        return apartment;
    }

    public ParkingSpotModel setApartment(String apartment) {
        this.apartment = apartment;
        return this;
    }

    public String getBlock() {
        return block;
    }

    public ParkingSpotModel setBlock(String block) {
        this.block = block;
        return this;
    }
}
