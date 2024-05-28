package ru.ibs.appline.framework.managers;

import ru.ibs.appline.framework.pages.PageBasket;
import ru.ibs.appline.framework.pages.PageCartProduct;
import ru.ibs.appline.framework.pages.HomePage;
import ru.ibs.appline.framework.pages.PageProductsAfterSearch;

public class PageManager {
    private static PageManager INSTANCE = null;



    private HomePage homePage;
    private PageCartProduct pageCartProduct;

    private PageProductsAfterSearch pageProductsAfterSearch;

    private PageBasket pageBasket;



    private PageManager() {
    }



    public static PageManager getPageManager() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }
//Геттеры
    public HomePage getHomePage() {
        if(homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }



    public PageCartProduct getPageCartProduct() {
        if(pageCartProduct == null){
            pageCartProduct = new PageCartProduct();
        }
        return pageCartProduct;
    }





    public PageProductsAfterSearch getPageProductsAfterSearch() {
        if(pageProductsAfterSearch == null){
            pageProductsAfterSearch = new PageProductsAfterSearch();
        }
        return pageProductsAfterSearch;
    }

    public PageBasket getPageBasket() {
        if(pageBasket == null){
            pageBasket = new PageBasket();
        }
        return pageBasket;
    }

}
