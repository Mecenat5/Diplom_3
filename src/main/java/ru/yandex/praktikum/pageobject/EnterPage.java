package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterPage {
    private final WebDriver driver;
    private final By enterEmailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By enterPasswordField = By.xpath(".//*[text()='Пароль']/following-sibling::input");
    private final By buttonEnter = By.xpath(".//button[text()='Войти']");
    private final By buttonRegister = By.xpath(".//a[text()='Зарегистрироваться']");//class = Auth_link__1fOlj
    private final By buttonRecoverPassword = By.xpath(".//a[text()='Восстановить пароль']");

    public EnterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнить поле Email")
    public void setEnterEmail(String email){
        driver.findElement(enterEmailField).sendKeys(email);
    }

    @Step("Заполнить поле Пароль")
    public void setEnterPassword(String password){
        driver.findElement(enterPasswordField).sendKeys(password);
    }

    @Step("Нажать на кнопку Войти")
    public void clickButtonEnter(){
        driver.findElement(buttonEnter).click();
    }
    @Step("Нажать на кнопку Зарегистрироваться")
    public void enterButtonRegister(){
        driver.findElement(buttonRegister).click();
    }

    @Step("Нажать на кнопку Восстановить пароль")
    public void enterButtonRecoverPassword(){
        driver.findElement(buttonRecoverPassword).click();
    }

}
