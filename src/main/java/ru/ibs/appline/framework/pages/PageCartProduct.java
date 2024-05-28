package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.appline.framework.utils.Product;

public class PageCartProduct extends BasePage{


    @FindBy(xpath = "//div[@data-meta-name='PriceBlock__price']//span[@class='e1j9birj0 e106ikdt0 app-catalog-8hy98m e1gjr6xo0']")
    WebElement priceProduct;
    @FindBy(xpath = "//h1[@class='e1ubbx7u0 eml1k9j0 app-catalog-lc5se5 e1gjr6xo0']")
    WebElement nameProduct;

    @FindBy(xpath = "//button[@data-meta-name='BasketDesktopButton']")
    WebElement buttonBasket;
    @FindBy(xpath = "//div/span[contains(text(),'Товар добавлен')]")
    WebElement windowAdditionalServices;


    @FindBy(xpath = "//div[@class='css-1ovqn8g eyoh4ac0']//span[contains(text(),'Страховой полис')]/../../../div[@data-meta-name='UpsaleBasketAdditionalServicesItem__price']//span[@class='e1j9birj0 e106ikdt0 css-rx1cfc e1gjr6xo0']")
    WebElement priceGarantee;


    @FindBy(xpath = "//div[@class='css-1ovqn8g eyoh4ac0']//span[contains(text(),'Страховой полис')]/../../../..//input[@class='css-1un0tuq e1slepq00']")
    WebElement checkboxInsurance;
    @FindBy(xpath = "//label[@class='css-105zng3 e1no5vnt0']")
    WebElement activeGarantie;
    @FindBy(xpath = "//button/span[text()='Продолжить покупки']/..")
    WebElement buttonContinueShopping;

    @FindBy(xpath = "//div[@data-meta-row-count]//div[@data-meta-name='Logo' and @class='css-ow05wu etq0gq00']/..")
    WebElement logo;

    @FindBy(xpath = "//div[@data-meta-name='BasketButton'and @class='css-1vb2hqj e38q5fc0']")
    WebElement basket;


    public Product clickForButtonVBaskcet() {
        clickOnElement(buttonBasket);
        waiting();
        return new Product(getName(nameProduct), getPrice(priceProduct));
    }

     public PageCartProduct checkOpenWindowAdditionalServices(){
        checkElementForText(windowAdditionalServices, "Товар добавлен");
        return pageManager.getPageCartProduct();
     }

    public Product getGarantee2Years(){
        return new Product("Гарантия 2 года", getPrice(priceGarantee));
    }



    public PageCartProduct enterOnCheckboxInsurance (){
        checkboxInsurance.click();
        return pageManager.getPageCartProduct();
    }
    public PageCartProduct checkGarantee2Years(){
        Assertions.assertEquals("+2 года", activeGarantie.getText(), "Выбрана гарантия не 2 года");
        return pageManager.getPageCartProduct();
    }

    public PageCartProduct clickOnButtonContinueShopping(){
        clickOnElement(buttonContinueShopping);
        return pageManager.getPageCartProduct();
    }

    public HomePage goToHomePage(){
        clickOnElement(logo);
        return pageManager.getHomePage();
    }





}
