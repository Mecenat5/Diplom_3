package ru.yandex.praktikum;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Constants {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    public static final String CREATE_USER = "api/auth/register";
    public static final String LOGIN_USER = "api/auth/login";
    public static final String AUTH_USER = "api/auth/user";
    public static final String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";
    public static final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site";
    public static final String YANDEX_BROWSER_PATH = "C:/Users/Юля/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";
    public static RequestSpecification spec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .log()
                .all();
    }
}
