package ru.ibs.appline.tests;

import org.junit.jupiter.api.Test;
import ru.ibs.appline.base.BaseTests;

public class ForTest extends BaseTests {
    @Test
    void testForBasket(){
        app.getHomePage().clickOnBasket();
    }
}
