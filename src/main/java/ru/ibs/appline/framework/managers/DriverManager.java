package ru.ibs.appline.framework.managers;

import org.apache.commons.exec.OS;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static ru.ibs.appline.framework.utils.PropertiesConst.PATH_CHROME_DRIVER_WINDOWS;
import static ru.ibs.appline.framework.utils.PropertiesConst.TYPE_BROWSER;

public class DriverManager {
    private WebDriver driver = null;
    private TestPropertiesManager testPropertiesManager = TestPropertiesManager.getTestPropertiesManager();

    private static DriverManager INSTANCE = null;

    private  DriverManager(){

    }
    //Паттерн singleton
    public static DriverManager getDriverManager(){
        if(INSTANCE == null){
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver(){
        if(driver == null) {
            initDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        }
        return driver;
    }

    private void initDriver(){
        if(OS.isFamilyWindows()){
            initDriverWindowsOsFamaly();
        }
    }

    private void initDriverWindowsOsFamaly(){
        initDriverAnyOsFamaly();
    }

    private void initDriverAnyOsFamaly(){
        switch (testPropertiesManager.getProperty(TYPE_BROWSER)){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", testPropertiesManager.getProperty(PATH_CHROME_DRIVER_WINDOWS));
                driver = new ChromeDriver();
                break;
            default:
                Assertions.fail("Типа браузера '" + testPropertiesManager.getProperty(TYPE_BROWSER) + "' не существует во вреймворке");
        }

    }

    public void quitDriver(){
        driver.quit();
    }
}
