package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver driver;
    private final By buttonEnter = By.xpath(".//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажать на кнопку Войти")// переименовать
    public void clickEnterButton() {
        driver.findElement(buttonEnter).click();
    }
}
