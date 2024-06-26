package ru.ibs.appline.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ibs.appline.base.BaseTests;


public class ParametrizedFirstTest extends BaseTests {
    @ParameterizedTest
    @DisplayName("Параметризованная проверка отображения ошибки при не корректном вводе поля Email")
    @MethodSource("ru.ibs.appline.data.DataClass#argForFirstParametrazedTests")
    @Tag("ParTest")
    @Disabled
    public void testForGettingErrorOnFieldMailParametrized(String fio, String phone, String mail, String town) {

//        HomePage homePage = new HomePage(driver);
//        DMSPage dmsPage = new DMSPage(driver);
//        FormPage formPage = new FormPage(driver);

//
////Нажимаем в главном меню на пункт "Компаниям"
//        homePage.clickOnGeneralMenuForCompany();
////Нажимаем на под-меню "Здоровье"
//        homePage.clickOnSectionCategoriesHealth();
////Нажимаем на Добровольное медицинское страхование
//        dmsPage.clickOnDMS();
////Проверяем что отобразилась страница добровольного медицинского страхования
//        Assertions.assertEquals("Добровольное медицинское страхование",
//                dmsPage.getTextHeadingDMS(), "Наименование заголовка не для ДМС");
//
//        dmsPage.clickOnButtonSendRequest();
////Провеярем что форма отправки заявки отобразилась
//        Assertions.assertTrue(formPage.checkVisibalyFormPage());
////Заполняем форму оптравки
//        formPage.enterTextInInputFIO(fio);
//
//        formPage.enterTextInInputPhone(phone);
//
//        formPage.enterTextInInputMail(mail);
//
//        formPage.enterTextInInputTown(town);
////Проверяем текст ошибки и что кнпока отпарвки формы не активна
//        Assertions.assertAll(
//                () ->
//                        Assertions.assertEquals("Введите корректный адрес электронной почты",
//                                formPage.getMailInputTextError(), "Текст ошибки отсутствует")
//                ,
//                () ->
//                        Assertions.assertFalse(formPage.checkVisibalyButtonContactToMe(), "Кнопка активна")
//
//        );

    }





}
