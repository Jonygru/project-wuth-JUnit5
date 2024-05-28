package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.framework.managers.DriverManager;
import ru.ibs.appline.framework.managers.PageManager;

import java.time.Duration;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofMillis(1000));
    protected PageManager pageManager = PageManager.getPageManager();

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected void fillInputField(WebElement element, String value) {
        waitUtilElementToBeClickable(element);
        element.click();
        element.clear();
        element.sendKeys(value);

    }


    protected void waitUtilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUtilElementToBeVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitUtilElementAttributeContains(WebElement element, String attribute, String value){
        wait.until(ExpectedConditions.attributeContains(element,attribute,value));
    }
    protected void checkElementAttribute(String value,WebElement element, String attribute ){
        Assertions.assertEquals(value, element.getAttribute(attribute), "Сравниваемый атрибут не найден");
    }

    protected void waiting(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected Integer getPrice(WebElement element){
        return Integer.parseInt(element.getText().replace(" ", ""));
    }

    protected String getName(WebElement element){
        return element.getText();
    }

    public void clickOnElement(WebElement element){
        waitUtilElementToBeVisibility(element);
        waitUtilElementToBeClickable(element);
        element.click();
    }

    public void checkElementForText(WebElement element, String s){
        waitUtilElementToBeVisibility(element);
        Assertions.assertTrue(element.getText().contains(s),"Элемент: с текстом"  + s + " не найден!");
    }


}
