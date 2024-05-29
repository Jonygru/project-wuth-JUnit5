package ru.ibs.appline.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ibs.appline.base.BaseTests;
import ru.ibs.appline.framework.utils.Basket;

import java.sql.SQLOutput;

public class CheckPriceBasketTest extends BaseTests {
    @Test
    @DisplayName("Проверка цены корзины")
    void testCheckPriceBasket() {
        Basket basket = new Basket();
        app.getHomePage().searchProduct("Sony playstation") //Поиск сони плейстейшн
                .goToCartProductForNumber(2);//Клик по второму продукту результата поиска
        basket.addProductInBasket(app.getPageCartProduct().clickForButtonVBaskcet()); //Добавление в корзину продукта

        //Добавление гарантии на 2 года для сони плейстейшн через модальное окно
        app.getPageCartProduct().checkOpenWindowAdditionalServices() //Проверка что модальное окно открылось
                .enterOnCheckboxInsurance() //Выбор чекбокса с доп гарантией
                .checkGarantee2Years();  //Проверка что выбрана гарантия в 2 года
        basket.addProductInBasket(app.getPageCartProduct().getGarantee2Years()); //Добавление в корзину продукта

        //Переход дальше к покупкам из модального окна доп услуг
        app.getPageCartProduct().clickOnButtonContinueShopping()
                .goToHomePage()
                .searchProduct("last of us") //Поиск ласт оф ас
                .goToCartProductForNumber(1);   //Клик по первому продукту результата поиска
        basket.addProductInBasket(app.getPageCartProduct().clickForButtonVBaskcet()); //Добавление в корзину продукта

        //Переход в корзину
        app.getPageCartProduct().goToHomePage()
                .checkCountProductsInBasket("3") //Проверка что в корзине именно три элемента
                .clickOnBasket()
                .checkPageBasket() //Проверяем что находимся в корзине
                .checkTotalPriceInBasket(basket.getPrice()); //Проверяем итоговую цену корзины


        System.out.println(basket.getProductsInBascet());

        System.out.println(basket.getPrice());



    }
}
