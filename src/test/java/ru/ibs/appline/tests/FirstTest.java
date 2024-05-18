package ru.ibs.appline.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.ibs.appline.base.BaseTests;
import ru.ibs.appline.pegaobject.DMSPage;
import ru.ibs.appline.pegaobject.FormPage;
import ru.ibs.appline.pegaobject.HomePage;

import java.time.Duration;

public class FirstTest extends BaseTests {


    @Test
    @DisplayName("Проверка отображения ошибки при не корректном вводе поля Email")
    void test() {

        HomePage homePage = new HomePage(super.getDriver());
//Нажимаем в главном меню на пункт "Компаниям"
        homePage.clickOnGeneralMenuForCompany();
//Нажимаем на под меню "Здоровье"
        homePage.clickOnSectionCategoriesHealth();
        DMSPage dmsPage = new DMSPage(super.getDriver());
//Нажимаем на Добровольное медицинское страхование
        dmsPage.clickOnDMS();
//Проверяем что отобразилась страница добровольного медицинского страхования
        Assertions.assertEquals("Добровольное медицинское страхование",
                dmsPage.getTextHeadingDMS(), "Наименование заголовка не для ДМС");

        dmsPage.clickOnButtonSendRequest();
//Провеярем что форма отправки заявки отобразилась
        FormPage formPage = new FormPage(super.getDriver());
        Assertions.assertTrue(formPage.checkVisibalyFormPage());
//Заполняем форму оптравки
        formPage.enterTextInInputFIO("Иванов");

        formPage.enterTextInInputPhone("3453463634");

        formPage.enterTextInInputMail("qwertyqwerty");

        formPage.enterTextInInputTown("asdfsdfasdf");
//Проверяем текст ошибки и что кнпока отпарвки формы не активна
        Assertions.assertAll(
                () ->
                        Assertions.assertEquals("Введите корректный адрес электронной почты",
                                formPage.getMailInputTextError(), "Текст ошибки отсутствует")
                ,
                () ->
                        Assertions.assertFalse(formPage.checkVisibalyButtonContactToMe(), "Кнопка активна")

        );

    }


}

