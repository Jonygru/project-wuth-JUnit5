package ru.ibs.appline.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.ibs.appline.framework.managers.DriverManager;
import ru.ibs.appline.framework.managers.PageManager;
import ru.ibs.appline.framework.managers.TestPropertiesManager;
import ru.ibs.appline.framework.utils.Basket;


import static ru.ibs.appline.framework.utils.PropertiesConst.BASE_URL;


public class BaseTests {


    private DriverManager driverManager = DriverManager.getDriverManager();

    private TestPropertiesManager testPropertiesManager = TestPropertiesManager.getTestPropertiesManager();
    protected PageManager app = PageManager.getPageManager();
    @BeforeEach()
    public void beforeEach(){
        driverManager.getDriver().get(testPropertiesManager.getProperty(BASE_URL));
    }

//    @AfterEach()
//    public void afterEach(){
//        driverManager.quitDriver();
//    }


}
