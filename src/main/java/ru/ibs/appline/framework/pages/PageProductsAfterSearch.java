package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageProductsAfterSearch extends BasePage {

    @FindBy(xpath = "//a[@data-meta-name= 'Snippet__title' and @class='app-catalog-9gnskf e1259i3g0']")
    List<WebElement> productWasSearchable;
//Клик по элементу после поиска по тексту
    public PageCartProduct goToCartProductForText(String s) {
        for (WebElement item : productWasSearchable) {
            if (item.getText().contains(s)) {
                clickOnElement(item);
                return pageManager.getPageCartProduct();
            }

        }
        Assertions.fail("Элемент: " + s + " не присутствует в результатах поиска");
        return pageManager.getPageCartProduct();
    }
    //Клик по элементу после поиска по порядковому номеру (Пока без скрола)
    public PageCartProduct goToCartProductForNumber(int number) {
        checkResultSearch();
        if (number > productWasSearchable.size() || number <=0)
            Assertions.fail("В результатах поиска меньше " + number + " элементов");
        else clickOnElement(productWasSearchable.get(number - 1));
        return pageManager.getPageCartProduct();
    }

    //Проверка что результат поиска не пустой
    public PageProductsAfterSearch checkResultSearch() {
        Assertions.assertFalse(productWasSearchable.isEmpty(), "Результат поиска не дал результата");
        return pageManager.getPageProductsAfterSearch();
    }

//    public PageCartProduct goToCartProduct2(String s){
//        boolean fail = false;
//        productWasSearchable.forEach((item, fail) -> {
//            if(item.getText().contains(s)){
//                clickOnElement(item);
//                return fail;
//            }
//
//        });
//        if(!fail) Assertions.fail("Элемента: "+ s + " не существует");
//        return pageManager.getPageCartProduct();
//    }
}
