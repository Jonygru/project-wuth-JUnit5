package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageBasket extends BasePage {

    @FindBy(xpath = "//main//span[text()='Корзина']")
    WebElement pageBasket;

    @FindBy(xpath = "//span[@class='e1j9birj0 e106ikdt0 css-1spb733 e1gjr6xo0']")
    WebElement totalPriceInBasket;

    @FindBy(xpath = "//div[@data-meta-type='Product']")
    List<WebElement> listProductsInBasket;

    public PageBasket checkPageBasket(){
        Assertions.assertEquals("Корзина", pageBasket.getText(),"Находимся не на странице корзины");
        return pageManager.getPageBasket();
    }

    public PageBasket checkTotalPriceInBasket(Integer price){
        Assertions.assertEquals(price, getPrice(totalPriceInBasket), "Ожидаемая цена всей корзины не соответствует фактической");
        return pageManager.getPageBasket();
    }




}
