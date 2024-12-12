package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationPage {

    private final WebDriver driver;
    private final By nameRegistration = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private final By emailRegistration = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private final By passwordRegistration = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private final By buttonRegistration = By.xpath("//button[text()='Зарегистрироваться']");
    private final By invalidPassword = By.xpath(".//*[text()='Некорректный пароль']");
    private final By enterButton = By.xpath(".//a[text()='Войти']");// переименовать

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнить поле Имя")
    public void setUserName(String name) {
        driver.findElement(nameRegistration).sendKeys(name);
    }
    @Step("Заполнить поле Email")
    public void setUserEmail(String email) {
        driver.findElement(emailRegistration).sendKeys(email);
    }
    @Step("Заполнить поле Пароль")
    public void setUserPassword(String password) {
        driver.findElement(passwordRegistration).sendKeys(password);
    }

    @Step("Ошибка при вводе невалидного пароля")
    public boolean errorInPassword() {
        return driver.findElement(invalidPassword).isDisplayed();
    }
    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }
    @Step("Нажать на кнопку Войти") //переименовать
    public void enterButtonClick() {
        driver.findElement(enterButton).click();
    }

}
