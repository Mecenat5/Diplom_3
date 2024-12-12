package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.api.StepUser;
import ru.yandex.praktikum.pageobject.EnterPage;
import ru.yandex.praktikum.pageobject.MainPage;
import ru.yandex.praktikum.pageobject.PasswordRecoveryPage;
import ru.yandex.praktikum.pageobject.RegistrationPage;

import static ru.yandex.praktikum.Constants.MAIN_PAGE;
import static ru.yandex.praktikum.WebDriverCreator.createWebDriver;
import static ru.yandex.praktikum.api.GenerateUser.*;

public class EnterPageTest {
    private WebDriver driver;
    private String accessToken;


    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(MAIN_PAGE);
        Response response = StepUser.createUser(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        accessToken = response.then().log().all().extract().path("accessToken");
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    @Description("Проверка - успешно войти по кнопке «Войти в аккаунт» на главной странице под существующим пользователем")
    public void LogUsingLogToAccountButton() {
        MainPage mainPage = new MainPage(driver);
        EnterPage enterPage = new EnterPage(driver);
        mainPage.clickButtonLogToAccount();
        enterPage.setEnterEmail(RANDOM_EMAIL);
        enterPage.setEnterPassword(RANDOM_PASSWORD);
        enterPage.clickButtonEnter();
    }
    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверка - успешно войти по кнопке «Личный кабинет» на главной под существующим пользователем")
    public void LoginToPersonalAccountButton() {
        MainPage mainPage = new MainPage(driver);
        EnterPage enterPage = new EnterPage(driver);
        mainPage.clickButtonPersonalAccount();
        enterPage.setEnterEmail(RANDOM_EMAIL);
        enterPage.setEnterPassword(RANDOM_PASSWORD);
        enterPage.clickButtonEnter();
    }
    @Test
    @DisplayName("Вход через кнопку Войти в форме регистрации")
    @Description("Проверка - успешно войти по кнопке в форме регистрации под существующим пользователем")
    public void LoginButtonRegistrationForm() {
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        EnterPage enterPage = new EnterPage(driver);
        mainPage.clickButtonPersonalAccount();
        enterPage.enterButtonRegister();
        registrationPage.enterButtonClick();
        enterPage.setEnterEmail(RANDOM_EMAIL);
        enterPage.setEnterPassword(RANDOM_PASSWORD);
        enterPage.clickButtonEnter();
    }
    @Test
    @DisplayName("Вход через кнопку Войти в форме восстановления пароля.")
    @Description("Проверка - успешно через кнопку в форме восстановления пароля под существующим пользователем")
    public void LoginButtonPasswordRecoveryForm() {
        MainPage mainPage = new MainPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        EnterPage enterPage = new EnterPage(driver);
        mainPage.clickButtonPersonalAccount();
        enterPage.enterButtonRecoverPassword();
        passwordRecoveryPage.clickEnterButton();
        enterPage.setEnterEmail(RANDOM_EMAIL);
        enterPage.setEnterPassword(RANDOM_PASSWORD);
        enterPage.clickButtonEnter();
    }

    @After
    public void teardown() {
        if (accessToken != null) {
            StepUser.deleteUser(accessToken);
        }
        driver.quit();
    }
}


