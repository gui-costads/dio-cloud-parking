package one.digitalinnovation.parking.controller;

import io.restassured.RestAssured;
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalManagementPort;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import java.awt.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest extends AbstractContainerBase {
    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setRandomPort(){
        RestAssured.port = randomPort;
    }

    @Test
    void    whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode(200)
                .body("license", Matchers.contains("hki-1222"));
    }

    @Test
    void whenCreateThenCheckIsCreated() {
        ParkingCreateDTO createDTO = new ParkingCreateDTO();
        createDTO.setColor("Branco");
        createDTO.setLicense("hki-1222");
        createDTO.setModel("corolla");
        createDTO.setState("RS");

        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(201)
                .body("license", Matchers.equalTo("hki-1222"))
                .body("color", Matchers.equalTo("Branco"))
                .body("model", Matchers.equalTo("corolla"))
                .body("state", Matchers.equalTo("RS"));
    }
}