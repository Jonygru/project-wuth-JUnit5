package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //Локатор основного меню
    @FindBy(xpath ="//input[@type='search']")
    WebElement fieldSearch; //Поле поиска
    @FindBy(xpath = "//button[@class='css-c064wa ebli37a0' and @type='submit']")
    WebElement buttonSearch; //Кнопка поиска

    @FindBy(xpath = "//a[@title='Игровая консоль PlayStation 5 Slim CFI-2000A01, 1000ГБ' and @data-meta-name]")
    WebElement playStationFiveSlim; //

    @FindBy(xpath = "//a[@title='Игра PlayStation The Last of Us Part 2. Remastered,  RUS (игра и субтитры), для  PlayStation 5' and @class='app-catalog-9gnskf e1259i3g0']")
    WebElement lastOfUs; //

    @FindBy(xpath = "//div[@data-meta-name='BasketButton'and @class='css-1vb2hqj e38q5fc0']")
    WebElement basket;



    public HomePage inputFieldSearch(String s){
        fillInputField(fieldSearch, s);
        Assertions.assertEquals(s, fieldSearch.getAttribute("value"));
        return pageManager.getHomePage();
    }

    public HomePage clickButtonSearch(){
        clickOnElement(buttonSearch);
        return pageManager.getHomePage();
    }

    public PageCartProduct clickOnPlayStationFiveSlim(){
        return clickOnProduct(playStationFiveSlim);
    }

    public PageCartProduct clickOnLastOfUs(){
        return clickOnProduct(lastOfUs);
    }

    public PageCartProduct clickOnProduct(WebElement element){
        clickOnElement(element);
        return  pageManager.getPageCartProduct();
    }

    public PageProductsAfterSearch searchProduct(String s){
        inputFieldSearch(s);
        clickButtonSearch();
        return pageManager.getPageProductsAfterSearch();
    }

    public PageBasket clickOnBasket(){
        clickOnElement(basket);
        return pageManager.getPageBasket();
    }



    public HomePage checkCountProductsInBasket(String expectedCountProductInBasket){
        checkElementAttribute(expectedCountProductInBasket, basket, "data-meta-count");
        return pageManager.getHomePage();
    }








}
