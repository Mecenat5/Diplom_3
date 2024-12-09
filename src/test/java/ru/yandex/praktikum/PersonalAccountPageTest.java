package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.api.StepUser;
import ru.yandex.praktikum.pageobject.EnterPage;
import ru.yandex.praktikum.pageobject.PersonalAccountPage;
import ru.yandex.praktikum.pageobject.MainPage;

import static ru.yandex.praktikum.Constants.MAIN_PAGE;
import static ru.yandex.praktikum.WebDriverCreator.createWebDriver;
import static ru.yandex.praktikum.api.GenerateUser.*;

public class PersonalAccountPageTest {
    private WebDriver driver;
    private String accessToken;

    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(MAIN_PAGE);
        StepUser.createUser(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
    }
    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка - успешный переход переход по клику на «Личный кабинет»")
    public void transferPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        EnterPage enterPage = new EnterPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickButtonLogToAccount();
        enterPage.setEnterEmail(RANDOM_EMAIL);
        enterPage.setEnterPassword(RANDOM_PASSWORD);
        enterPage.clickButtonEnter();
        mainPage.clickButtonPersonalAccount();
        personalAccountPage.waitingForPersonalAccountPageLoad();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на кнопку «Конструктор»")
    @Description ("Проверка - успешный переход в конструктор по клику на кнопку «Конструктор»")
    public void clickThroughConstructor() {
        MainPage mainPage = new MainPage(driver);
        EnterPage enterPage = new EnterPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickButtonLogToAccount();
        enterPage.setEnterEmail(RANDOM_EMAIL);
        enterPage.setEnterPassword(RANDOM_PASSWORD);
        enterPage.clickButtonEnter();
        mainPage.clickButtonPersonalAccount();
        personalAccountPage.waitingForPersonalAccountPageLoad();
        personalAccountPage.clickButtonConstructor();
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    @Description ("Проверка - успешный переход на главную страницу по клику на логотип Stellar Burgers")
    public void clickOnTheStellarBurgersLogo() {
        MainPage mainPage = new MainPage(driver);
        EnterPage enterPage = new EnterPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickButtonLogToAccount();
        enterPage.setEnterEmail(RANDOM_EMAIL);
        enterPage.setEnterPassword(RANDOM_PASSWORD);
        enterPage.clickButtonEnter();
        mainPage.clickButtonPersonalAccount();
        personalAccountPage.waitingForPersonalAccountPageLoad();
        personalAccountPage.clickButtonStellarBurgers();
    }
    @Test
    @DisplayName("Выход из аккаунта")
    @Description ("Проверка - успешный выход из аккаунта по кнопке Выйти в личном кабинете")
    public void logOutOfAccount() {
        MainPage mainPage = new MainPage(driver);
        EnterPage enterPage = new EnterPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickButtonLogToAccount();
        enterPage.setEnterEmail(RANDOM_EMAIL);
        enterPage.setEnterPassword(RANDOM_PASSWORD);
        enterPage.clickButtonEnter();
        mainPage.clickButtonPersonalAccount();
        personalAccountPage.waitingForPersonalAccountPageLoad();
        personalAccountPage.clickButtonExit();
    }

    @After
    public void teardown() {
        if (accessToken != null) {
            StepUser.deleteUser(accessToken);
        }
        driver.quit();
    }
}

