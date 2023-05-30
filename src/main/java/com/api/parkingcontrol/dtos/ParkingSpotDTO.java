package com.api.parkingcontrol.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ParkingSpotDTO {

    @NotBlank
    private String parkingSpotNumber;

    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;

    @NotBlank
    private String brandCar;

    @NotBlank
    private String modelCar;

    @NotBlank
    private String colorCar;

    @NotBlank
    private String responsibleName;

    @NotBlank
    private String apartment;

    @NotBlank
    private String block;

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public ParkingSpotDTO setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
        return this;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public ParkingSpotDTO setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
        return this;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public ParkingSpotDTO setBrandCar(String brandCar) {
        this.brandCar = brandCar;
        return this;
    }

    public String getModelCar() {
        return modelCar;
    }

    public ParkingSpotDTO setModelCar(String modelCar) {
        this.modelCar = modelCar;
        return this;
    }

    public String getColorCar() {
        return colorCar;
    }

    public ParkingSpotDTO setColorCar(String colorCar) {
        this.colorCar = colorCar;
        return this;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public ParkingSpotDTO setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
        return this;
    }

    public String getApartment() {
        return apartment;
    }

    public ParkingSpotDTO setApartment(String apartment) {
        this.apartment = apartment;
        return this;
    }

    public String getBlock() {
        return block;
    }

    public ParkingSpotDTO setBlock(String block) {
        this.block = block;
        return this;
    }
}
