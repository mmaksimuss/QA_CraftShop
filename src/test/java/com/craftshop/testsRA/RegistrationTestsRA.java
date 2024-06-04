package com.craftshop.testsRA;

import com.craftshop.dto.UserRegisterDto;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationTestsRA extends TestBaseRA {
    public Response response;

    @Test(invocationCount = 1)
    public void registerUserWithValidRandomData() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        String name = "john" + randomNumber + "@gmail.com";
        System.out.println(name);
        UserRegisterDto user = UserRegisterDto.builder()
                .email(name)
                .firstName("John")
                .lastName("Doe")
                .password("P12345678")
                .build();

         response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("registration");
        response.prettyPrint();
        assertThat(response.getStatusCode(), is(200));

    }

    @Test(priority = 1)
    public void registerUserWithValidData() {
        UserRegisterDto user = UserRegisterDto.builder()
                .email("john1@gmail.com")
                .firstName("John")
                .lastName("Doe")
                .password("P12346578")
                .build();

        response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("registration");
        response.prettyPrint();
        assertThat(response.getStatusCode(), is(200));
    }


    @Test(priority = 5)
    public void registerUserWithExistingEmail() {
        UserRegisterDto user = UserRegisterDto.builder()
                .email("john1@gmail.com")
                .firstName("Petr")
                .lastName("Petrov")
                .password("P12345678")
                .build();

        response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("registration");
        response.prettyPrint();
        assertThat(response.getStatusCode(), is(403));
    }

    @Test
    public void registerUserWithInvalidEmail() {
        UserRegisterDto user = UserRegisterDto.builder()
                .email("john325@gmail..")
                .firstName("John")
                .lastName("Doe")
                .password("P12345678")
                .build();

        response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("registration");
        response.prettyPrint();
        //.then()
        assertThat(response.getStatusCode(), is(400));
    }

    @Test
    public void registerUserWithInvalidPassword() {
        UserRegisterDto user = UserRegisterDto.builder()
                .email("john325@gmail.com")
                .firstName("John")
                .lastName("Doe")
                .password("password")
                .build();

        response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("registration");
        response.prettyPrint();
        //.then()
        assertThat(response.getStatusCode(), is(400));
    }

}

