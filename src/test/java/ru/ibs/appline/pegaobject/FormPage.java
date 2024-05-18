package ru.ibs.appline.pegaobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage {
    WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    By formPage = By.xpath("//div[@class= 'form-wrapper']");

    //Поле ФИО
    By fio = By.xpath("//*[text()='Ваши ФИО']");
    By fioInput = By.xpath("./..//input[@name='userName']");

    //Поле Телефон
    By phone = By.xpath("//*[text()='Номер телефона']");
    By phoneInput = By.xpath("./..//input[@name='userTel']");

    //Поле почта
    By mail = By.xpath("//*[text()='Ваша почта']");
    By mailInput = By.xpath("./..//input[@name='userEmail']");
    By mailInputTextError = By.xpath("./../*[text()='Введите корректный адрес электронной почты']");

    //Поле город
    By town = By.xpath("//*[text()='Ваш город']");
    By townInput = By.xpath("./..//input[@placeholder='Введите']");
    By choiseTown = By.xpath("/div//*[contains(string(), 'Петербург')]");

    //Чек бокс для соглашения
    By checkBoxAgreement = By.xpath("//input[@class='input' and @type = 'checkbox']");
    //Кнопка свяжитесь со мной
    By buttonContactToMe = By.xpath("//button[text()='Свяжитесь со мной']");



    public boolean checkVisibalyFormPage(){
        return driver.findElement(formPage).isEnabled();
    }

    public void enterTextInInputFIO(String s){
        driver.findElement(fio).findElement(fioInput).sendKeys(s);
    }
    public void enterTextInInputPhone(String s){
        driver.findElement(phone).findElement(phoneInput).sendKeys(s);
    }

    public void enterTextInInputMail(String s){
        driver.findElement(mail).findElement(mailInput).sendKeys(s);
    }

    public void enterTextInInputTown(String s){
        driver.findElement(town).findElement(townInput).sendKeys(s);
    }

    public void clickOnCheckBoxAgreement(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(checkBoxAgreement));
        driver.findElement(checkBoxAgreement).click();
    }
    public String  getMailInputTextError(){
        return driver.findElement(mail).findElement(mailInputTextError).getText();
    }

    public boolean checkVisibalyButtonContactToMe(){
        return driver.findElement(buttonContactToMe).isEnabled();
    }

}
