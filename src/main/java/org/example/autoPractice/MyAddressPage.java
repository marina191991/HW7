package org.example.autoPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyAddressPage extends AbstractPage {
    @FindBy(xpath = "//a[@title='Add an address']")
    private WebElement addressAdd;

    @FindBy (xpath = "//ul[@class='last_item alternate_item box']/li[@class='address_update']/a[@title='Delete']")
    private WebElement submitDelete;

    public MyAddressPage(WebDriver driver) {
        super(driver);
    }
    public  MyAddressPage addressAddClick () {
        addressAdd.click();

        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='center_column']/ul/li/a")));
        return this;
    }
public void setSubmitDeleteClick() {
        submitDelete.click();

}

    public void alertClick() {

        Alert  alert =  getDriver().switchTo().alert();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        alert.accept();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[@id='addresses']")));


    }
}
