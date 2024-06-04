package com.craftshop.testsRA;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBaseRA {

    public static final String TOKEN="";
    public static final String AUTH="Authorization";

    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "api/";

    }


}
