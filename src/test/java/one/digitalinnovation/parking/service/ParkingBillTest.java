package one.digitalinnovation.parking.service;

import io.restassured.RestAssured;
import one.digitalinnovation.parking.controller.AbstractContainerBase;
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.parking.controller.dto.ParkingDTO;
import one.digitalinnovation.parking.controller.mapper.ParkingMapper;
import one.digitalinnovation.parking.model.Parking;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBillTest {

    @Test
    void getOneHourBill() {
        Parking parking = new Parking("fc4e1bcbf1fa450d8ca7e9da06d3bb12","hki-1222","RS", "Corolla","Branco");

        parking.setEntryDate(LocalDateTime.now());
        parking.setExitDate(LocalDateTime.now().plusMinutes(5));
        parking.setBill(ParkingBill.calculateBill(parking));


        assertEquals(5,parking.getBill());
    }
    @Test
    void getManyHoursBill() {
        Parking parking = new Parking("fc4e1bcbf1fa450d8ca7e9da06d3bb12","hki-1222","RS", "Corolla","Branco");

        parking.setEntryDate(LocalDateTime.now());
        parking.setExitDate(LocalDateTime.now().plusMinutes(360));
        parking.setBill(ParkingBill.calculateBill(parking));
        assertEquals(15,parking.getBill());

        parking.setEntryDate(LocalDateTime.now());
        parking.setExitDate(LocalDateTime.now().plusMinutes(480));
        parking.setBill(ParkingBill.calculateBill(parking));
        assertEquals(19, parking.getBill());
    }

    @Test
    void getDayBill() {
        Parking parking = new Parking("fc4e1bcbf1fa450d8ca7e9da06d3bb12","hki-1222","RS", "Corolla","Branco");

        parking.setEntryDate(LocalDateTime.now());
        parking.setExitDate(LocalDateTime.now().plusDays(1));
        parking.setBill(ParkingBill.calculateBill(parking));
        assertEquals(70,parking.getBill());

        parking.setEntryDate(LocalDateTime.now());
        parking.setExitDate(LocalDateTime.now().plusDays(3));
        parking.setBill(ParkingBill.calculateBill(parking));
        assertEquals(210, parking.getBill());
    }

}