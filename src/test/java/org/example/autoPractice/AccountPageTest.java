package org.example.autoPractice;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountPageTest extends AbstractTest {

   @Test
   @Epic("Личный кабинет")
   @Description("Наличие кнопки выхода с соответствующим текстом")
   void submitLogOut() {
      new LoginPage(getWebDriver()).emailSend("martiniz1901@gmail.com").passwordSend("Test124Test").submitLoginClick();
      Assertions.assertTrue(new AccountPage(getWebDriver()).submitLogOutChek().equals("Log me out"),"");
   }

   @Test
   @Epic("Личный кабинет")
   @Description("Наличие и кликабельность кнопки 'View my shopping cart'")
   void submitViewCart () {
      new LoginPage(getWebDriver()).emailSend("martiniz1901@gmail.com").passwordSend("Test124Test").submitLoginClick();
      Assertions.assertTrue(new AccountPage(getWebDriver()).submitViewCartChek().equals("View my shopping cart"),"");
   }

   @Test
   @Epic("Личный кабинет")
   @Description("Наличие кнопки и кликабельность 'Credit slips'")
   void submitCreditSlips() {
      MyUtils.makeScreenshot(getWebDriver(),"failure-org.example.autoPractice.AccountPageTest.submitCreditSlips"+ System.currentTimeMillis()+".pnd");
      new LoginPage(getWebDriver()).emailSend("martiniz1901@gmail.com").passwordSend("Test124Test").submitLoginClick();
      Assertions.assertTrue(new AccountPage(getWebDriver()).submitCreditSlipsClick().equals("Credit slips"),"");
   }

}
