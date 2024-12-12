package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.pageobject.MainPage;

import static org.junit.Assert.assertEquals;
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
    @DisplayName("Переход в конструкторе к разделу Булки")
    @Description("Проверка - успешный переход к разделу Булки")
    public void transitionSectionBun() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonFillings();
        mainPage.clickButtonBuns();
        assertEquals("Булки", mainPage.buttonTextMenuDesigner());

    }
    @Test
    @DisplayName("Переход в конструкторе к разделу Соусы")
    @Description("Проверка - успешный переход к разделу Соусы")
    public void transitionSectionSauces() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonSauces();
        assertEquals("Соусы", mainPage.buttonTextMenuDesigner());
    }
    @Test
    @DisplayName("Переход в конструкторе к разделу Начинки")
    @Description("Проверка - успешный переход к разделу Начинки")
    public void transitionSectionFillings() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonFillings();
        assertEquals("Начинки", mainPage.buttonTextMenuDesigner());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
