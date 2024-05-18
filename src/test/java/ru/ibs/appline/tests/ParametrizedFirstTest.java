package ru.ibs.appline.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ibs.appline.base.BaseTests;
import ru.ibs.appline.pageobject.DMSPage;
import ru.ibs.appline.pageobject.FormPage;
import ru.ibs.appline.pageobject.HomePage;

public class ParametrizedFirstTest extends BaseTests {
    @ParameterizedTest
    @DisplayName("Параметризованная проверка отображения ошибки при не корректном вводе поля Email")
    @MethodSource("ru.ibs.appline.data.DataClass#argForFirstParametrazedTests")
    public void test(String fio, String phone, String mail, String town) {

        HomePage homePage = new HomePage(super.getDriver());
        DMSPage dmsPage = new DMSPage(super.getDriver());
        FormPage formPage = new FormPage(super.getDriver());


//Нажимаем в главном меню на пункт "Компаниям"
        homePage.clickOnGeneralMenuForCompany();
//Нажимаем на под-меню "Здоровье"
        homePage.clickOnSectionCategoriesHealth();
//Нажимаем на Добровольное медицинское страхование
        dmsPage.clickOnDMS();
//Проверяем что отобразилась страница добровольного медицинского страхования
        Assertions.assertEquals("Добровольное медицинское страхование",
                dmsPage.getTextHeadingDMS(), "Наименование заголовка не для ДМС");

        dmsPage.clickOnButtonSendRequest();
//Провеярем что форма отправки заявки отобразилась
        Assertions.assertTrue(formPage.checkVisibalyFormPage());
//Заполняем форму оптравки
        formPage.enterTextInInputFIO(fio);

        formPage.enterTextInInputPhone(phone);

        formPage.enterTextInInputMail(mail);

        formPage.enterTextInInputTown(town);
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

    private void waitAnymiliseconds(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
