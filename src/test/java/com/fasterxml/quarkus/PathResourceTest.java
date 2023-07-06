package com.fasterxml.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PathResourceTest {
    @BeforeAll
    public static void init() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void pathAsList() {
        given()
          .when().get("/path/list/{seg1}/{seg2}", "ab/cd", "ef/gh")
          .then()
             .statusCode(200)
             .body(is("As List/std (2) -> [ab/cd, ef/gh]"));
    }

    @Test
    public void pathAsStringList() {
        given()
                .when().get("/path/listString/{seg1}/{seg2}", "ab/cd", "ef/gh")
                .then()
                .statusCode(200)
                .body(is("As List/String (1) -> [ab/cd/ef/gh]"));
    }

    @Test
    public void pathAsListEncoded() {
        given()
                .when().get("/path/listEncoded/{seg1}/{seg2}", "ab/cd", "ef/gh")
                .then()
                .statusCode(200)
                .body(is("As List/encoded (1) -> [ab%2Fcd/ef%2Fgh]"));
    }

    @Test
    public void pathAsString() {
        given()
                .when().get("/path/string/{seg1}/{seg2}", "ab/cd", "ef/gh")
                .then()
                .statusCode(200)
                .body(is("As String -> ab/cd/ef/gh"));
    }
}
