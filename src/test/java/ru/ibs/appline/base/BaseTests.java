package ru.ibs.appline.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTests {


    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;



    @BeforeAll()
    public static void beforeAll(){
        System.out.println("Стартанул тестсьют");
    }

    @BeforeEach()
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.rgs.ru");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterEach()
    public void afterEach(){
        driver.quit();
        System.out.println("\nБраузер закрылся");
    }

    @AfterAll()
    public static void afterAll(){
        System.out.println("Завершился тестсьют");
    }
}
