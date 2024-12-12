package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By logToAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By buttonBuns = By.xpath(".//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Булки']]");
    private final By buttonSauces = By.xpath(".//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Соусы']]");
    private final By buttonFillings = By.xpath(".//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Начинки']]");
    private final By menuDesigner = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку Войти в аккаунт")// переименовать
    public void clickButtonLogToAccount() { // переименовать
        driver.findElement(logToAccount).click();
    }
    @Step("Нажать на кнопку Личный кабинет")
    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }
    @Step("Нажать на кнопку Булки")
    public void clickButtonBuns() {
        driver.findElement(buttonBuns).click();
    }

    @Step("Нажать на кнопку Соусы")
    public void clickButtonSauces() {
        driver.findElement(buttonSauces).click();
    }

    @Step("Нажать на кнопку Начинки")
    public void clickButtonFillings() {
        driver.findElement(buttonFillings).click();
    }
    @Step("Текст выбранной кнопки в Конструкторе")
    public String buttonTextMenuDesigner() {
        return driver.findElement(menuDesigner).getText();
    }
}






