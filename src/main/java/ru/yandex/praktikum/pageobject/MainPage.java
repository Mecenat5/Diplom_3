package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    private final By logToAccount = By.xpath(".//button[text()='Войти в аккаунт']"); //локатор кнопки Войти в аккаунт
    private final By buttonPersonalАccount = By.xpath(".//p[text()='Личный Кабинет']"); //локатор кнопки Личный кабинет
    private By buttonBuns = By.xpath(".//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Булки']]");
    private By buttonSauces = By.xpath(".//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Соусы']]");
    private By buttonFillings = By.xpath(".//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Начинки']]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку Войти в аккаунт")// переименовать
    public void сlickButtonLogToAccount() { // переименовать
        driver.findElement(logToAccount).click();
    }
    @Step("Нажать на кнопку Личный кабинет")
    public void сlickButtonPersonalAccount() {
        driver.findElement(buttonPersonalАccount).click();
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
}


