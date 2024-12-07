package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.pageobject.MainPage;

import static ru.yandex.praktikum.Constants.MAIN_PAGE;
import static ru.yandex.praktikum.WebDriverCreator.createWebDriver;

public class ConstructorTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(MAIN_PAGE);
    }
    @Test
    @DisplayName("Переход к разделам Конструктора")
    @Description("Проверка - успешный переход по разделам Конструктора")
    public void switchToBunTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonSauces();
        mainPage.clickButtonBuns();
        mainPage.clickButtonFillings();
        mainPage.clickButtonBuns();
        mainPage.clickButtonSauces();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
