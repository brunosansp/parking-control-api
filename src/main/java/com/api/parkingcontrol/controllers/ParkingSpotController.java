package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDTO;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/parking-spot")
public class ParkingSpotController {

    final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @GetMapping(value = "/test")
    public String list() {
        return parkingSpotService.test();
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
        if (parkingSpotService.existsByLicensePlateCar(parkingSpotDTO.getLicensePlateCar()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
        if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDTO.getApartment(), parkingSpotDTO.getBlock()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<ParkingSpotModel>> listAllParkingSports(@PageableDefault(page = 0, size = 10, sort = "id",
                                                        direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpotById(@PathVariable UUID id) {
        Optional<ParkingSpotModel> result = parkingSpotService.findById(id);
        if (result.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found!");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable UUID id) {
        Optional<ParkingSpotModel> result = parkingSpotService.findById(id);
        if (result.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found!");
        parkingSpotService.delete(result);
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable UUID id,
                                                    @RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
        Optional<ParkingSpotModel> result = parkingSpotService.findById(id);
        if (result.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found!");
        ParkingSpotModel parkingSpotModel = result.get();
        BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
    }

}
