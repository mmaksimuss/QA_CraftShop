package com.craftshop.testsRA;


import com.craftshop.dto.AuthRequestDto;
import com.craftshop.dto.AuthResponseDto;
import com.craftshop.dto.LoginDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginTestsRA extends TestBaseRA {


    LoginDto auth = LoginDto.builder()
            .email("john1@gmail.com")
            .password("P12346578")
            .build();

    @Test
    public void loginSuccessTest1() {
//        RestAssured.defaultParser = Parser.JSON;
//        given()
//                .contentType(ContentType.JSON)
//                .body(auth)
//                .when()
//                .post("login")
//                .then()
//                .log().all()
//                .assertThat().statusCode(200);

          given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("login")
                .then()
                .log().all()
                .assertThat().statusCode(200);

    }

    @Test
    public void loginSuccessTest2() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("login")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response();

        String setCookie = response.getCookies().toString();

        if (setCookie != null && setCookie.contains("Access-Token=")) {
            String accessToken = setCookie.split("Access-Token=")[1].split(";")[0];
            System.out.println("Access Token: " + accessToken);
        } else {
            System.out.println("Access Token not found in the response headers.");
        }
    }

    @Test
    public void loginSuccessTest3() {
        RestAssured.defaultParser = Parser.JSON;
        Response response = given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("login")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        if (!responseBody.isEmpty()) {
            AuthResponseDto dto = response.as(AuthResponseDto.class);
            System.out.println(dto.getAccessToken());
        } else {
            System.out.println("Response body is empty.");
        }
    }

    @Test
    public void loginWithEmptyEmail() {
        given()
                .contentType(ContentType.JSON)
                .body(AuthRequestDto.builder()
                        .email("")
                        .password("P12345678")
                        .build())
                .when()
                .post("login")
                .then()
                .log().all()
                .assertThat().statusCode(403);
    }

    @Test
    public void loginWithEmptyPassword() {
        given()
                .contentType(ContentType.JSON)
                .body(AuthRequestDto.builder()
                        .email("john@gmail.com")
                        .password("")
                        .build())
                .when()
                .post("login")
                .then()
                .log().all()
                .assertThat().statusCode(403);
    }

    @Test
    public void loginWithInvalidEmail() {
        given()
                .contentType(ContentType.JSON)
                .body(AuthRequestDto.builder()
                        .email("john@gmail..")
                        .password("P12345678")
                        .build())
                .when()
                .post("login")
                .then()
                .log().all()
                .assertThat().statusCode(400)
                .body("email", equalTo("Invalid email format"));
    }

    @Test
    public void loginWithInvalidPassword() {
        given()
                .contentType(ContentType.JSON)
                .body(AuthRequestDto.builder()
                        .email("john@gmail.com")
                        .password("P1234567890123456789")
                        .build())
                .when()
                .post("login")
                .then()
                .log().all()
                .assertThat().statusCode(400)
                .body("password", equalTo("Invalid password format"));
    }
}
