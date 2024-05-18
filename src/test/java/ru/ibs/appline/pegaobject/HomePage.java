package ru.ibs.appline.pegaobject;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.base.BaseTests;

import java.time.Duration;

public class HomePage extends BaseTests {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    By popUpCookie = By.xpath("//button[text()='Понятно']");
    //Локаторы основного меню
    By generalMenu = By.xpath("//div[contains(@class, 'header-main')]"); // Локатор самого меню
    By generalMenuForCompanie = By.xpath(".//a[text()='Компаниям']");

    //Локаторы секции категории

    By sectionCategory = By.xpath("//*[contains(@class, 'section-categories')]");
     By sectionCategoriesHealth = By.xpath("//*[text()='Здоровье']/..");

     By pageforCompany = By.xpath("//h2[text()='Поможем выбрать нужное направление']");





    public boolean serchPageForCloseCookie(){
        return driver.findElement(popUpCookie).isEnabled();
    }
    public void approveCookie(){
        if(serchPageForCloseCookie()){
            driver.findElement(popUpCookie).click();
        }
        Assertions.assertFalse(serchPageForCloseCookie(), "Изменилась плашка закрытия кук");
    }

    public void clickOnGeneralMenuForCompany(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(generalMenu));
        driver.findElement(generalMenu).findElement(generalMenuForCompanie).click();
    }

    public void clickOnSectionCategoriesHealth(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(pageforCompany));
        driver.findElement(sectionCategory).findElement(sectionCategoriesHealth).click();
    }


}
