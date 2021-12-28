package org.example.autoPractice;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage extends AbstractPage{
    @FindBy (xpath = "//a[@title='Addresses']")
    private WebElement submitAddresses;

    @FindBy (xpath = "//a[@title='Log me out']")
    private WebElement submitLogOut;

    @FindBy (xpath = "//*[@id='center_column']/ul/li[1]/a")
    private WebElement submitBackAccountPage;

    @FindBy (xpath = "//a[@title='View my shopping cart']")
    private WebElement submitViewCart;

    @FindBy (xpath = "//a[@title='Credit slips']")
    private WebElement submitCreditSlips;


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить title кнопки 'Sign out' ")
    public String submitLogOutChek() {
        return submitLogOut.getAttribute("title");

    }
    @Step("Получить title кнопки 'View my shopping cart' ")
    public String submitViewCartChek() {
        return submitViewCart.getAttribute("title");}


    @Step("Получить title кнопки 'Credit slips', кликнуть на нее, затем вернуться на страницу личного кабинета ")
    public  String submitCreditSlipsClick () {
        submitCreditSlips.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[@id='order-slip']")));
        submitBackAccountPage.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[@id='my-account']")));
        return submitCreditSlips.getAttribute("title");

    }

    public  AccountPage addressClick () {
        this.submitAddresses.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[@id='addresses']")));
return this;
    }

}
