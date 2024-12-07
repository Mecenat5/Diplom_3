package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    private final WebDriver driver;
    private final By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    private final By buttonStellarBurgers = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By personalAccountPage = By.xpath(".//p[contains(text(), 'В этом разделе вы можете изменить')]");
    private final By buttonExit = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки страницы личного кабинета")
    public void waitingForPersonalAccountPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountPage));
    }

    @Step("Нажать на кнопку Конструктор")
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    @Step("Нажать на логотип StellarBurgers")
    public void сlickButtonStellarBurgers() {
        driver.findElement(buttonStellarBurgers).click();
    }

    @Step("Нажать на кнопку Выход")
    public void clickButtonExit() {
        driver.findElement(buttonExit).click();
    }
}

