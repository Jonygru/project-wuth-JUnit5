package ru.ibs.appline.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DMSPage {

    WebDriver driver;

    public DMSPage(WebDriver driver) {
        this.driver = driver;
    }

    By DMS = By.xpath("//a[text()='Добровольное медицинское страхование']");

    //Заголовок
    By headingDMS = By.xpath("//h1[text()='Добровольное медицинское страхование']");
    //Кнопка отправить заявку
    By buttonSendRequest = By.xpath("//span[text()='Отправить заявку']/..");

    public void clickOnDMS(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(DMS));
        driver.findElement(DMS).click();
    }
    public String  getTextHeadingDMS(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headingDMS));
        return driver.findElement(headingDMS).getText();

    }

    public void clickOnButtonSendRequest(){
        driver.findElement(buttonSendRequest).click();

    }
}
