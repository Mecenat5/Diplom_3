package ru.yandex.praktikum.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.praktikum.Constants;

public class StepUser extends Constants {
    @Step("Создание пользователя")
    public static Response createUser(String email, String password, String name) {
        ParametersUser parametersUser = new ParametersUser (email, password, name);
        return spec()
                .body(parametersUser)
                .when()
                .post(CREATE_USER);
    }

    @Step("Логин пользователя")
    public static Response loginUser(String email, String password, String name) {
        ParametersUser parametersUser = new ParametersUser (email, password, name);
        return spec()
                .body(parametersUser)
                .when()
                .post(LOGIN_USER);
    }
    @Step("Удаление пользователя")
    public static Response deleteUser(String accessToken) {
        return spec()
                .delete(AUTH_USER);
    }
}
