package viko_web_service.restservice.services;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import org.junit.Test;
import org.junit.runner.RunWith;

public class ControllerTest {

    @Test
    public void test() {
        RestAssured.get("/student").then().statusCode(200);
       // .body("student.firstName", name -> Matchers.equalTo("Vasya"));
    }
}
