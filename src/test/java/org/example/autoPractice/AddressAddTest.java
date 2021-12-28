package org.example.autoPractice;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;



public class AddressAddTest extends AbstractTest {


    @Test
    @Epic("Личный кабинет: адрес")
    @Description("Создание дополнительного адреса")
    void addressAdd () {
        new LoginPage(getWebDriver()).emailSend("martiniz1901@gmail.com").passwordSend("Test124Test").submitLoginClick();
        new AccountPage(getWebDriver()).addressClick();
        new MyAddressPage(getWebDriver()).addressAddClick();

        Assertions.assertEquals("Марина",new AddressAddPage(getWebDriver()).firstnameNotEmpty(),"Форма First name пустая");
        Assertions.assertEquals("Зубкова",new AddressAddPage(getWebDriver()).lastnameNotEmpty(),"Форма Last name пустая");

        new AddressAddPage(getWebDriver()).valueEnter("Moscow","Moscow","11145","79034864555","79034864555");
        new AddressAddPage(getWebDriver()).aliasEnter("My next address");
        new AddressAddPage(getWebDriver()).selectState("Alabama");

        Assertions.assertEquals(new AddressAddPage(getWebDriver()).selectCountryNotEmpty(),"United States", "Форма Country имеет неверное значение");
        Assertions.assertTrue(new AddressAddPage(getWebDriver()).companyIsEmpty().isEmpty(),"Форма Company должна быть пустой");
        Assertions.assertTrue(new AddressAddPage(getWebDriver()).addressSecondIsEmpty().isEmpty(),"Форма AddressSecond должна быть пустой");
        Assertions.assertTrue(new AddressAddPage(getWebDriver()).additionalInformationIsEmpty().isEmpty(),"Форма Additional Information должна быть пустой");
        MyUtils.makeScreenshot(getWebDriver(),"failure-org.example.autoPractice.AddressAddTest.addressAdd"+ System.currentTimeMillis()+".pnd");
        new AddressAddPage(getWebDriver()).submitSentAddress();
        new MyAddressPage(getWebDriver()).setSubmitDeleteClick();
        new MyAddressPage(getWebDriver()).alertClick();


    }

}
