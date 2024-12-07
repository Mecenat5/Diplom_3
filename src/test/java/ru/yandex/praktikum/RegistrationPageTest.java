package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.pageobject.RegistrationPage;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.Constants.REGISTER_PAGE;
import static ru.yandex.praktikum.WebDriverCreator.createWebDriver;
import static ru.yandex.praktikum.api.GenerateUser.*;

public class RegistrationPageTest {
        private WebDriver driver;


    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(REGISTER_PAGE);
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description ("Проверка - успешная регистрация пользователя при заполении валидных значений")
    public void userRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setUserName(RANDOM_NAME);
        registrationPage.setUserEmail(RANDOM_EMAIL);
        registrationPage.setUserPassword(RANDOM_PASSWORD);
        registrationPage.clickButtonRegistration();
    }

    @Test
    @DisplayName("Ошибка при регистрации пользователя с невалидным паролем")
    @Description ("Проверка - появление ошибки в поле Пароль при заполнении невалидного значения")
    public void userRegistrationWithIncorrectPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setUserName(RANDOM_NAME);
        registrationPage.setUserEmail(RANDOM_EMAIL);
        registrationPage.setUserPassword(RANDOM_INCORRECT_PASSWORD);
        registrationPage.clickButtonRegistration();
        assertTrue("Некорректный пароль", registrationPage.errorInPassword());
    }
    @After
    public void teardown() {
        driver.quit();
    }
}





