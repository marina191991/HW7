package org.example.autoPractice;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressAddPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstname;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastname;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//select[@id='id_state']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement postcode;

    @FindBy(xpath = "//select[@id='id_country']")
    private WebElement selectCountry;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    private WebElement phoneMobile;

    @FindBy(xpath = "//input[@id='alias']")
    private WebElement alias;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement company;

    @FindBy(xpath = "//input[@id='address2']")
    private WebElement addressSecond;

    @FindBy(xpath = "//textarea[@id='other']")
    private WebElement additionalInformation;

    @FindBy (xpath =("//button[@id='submitAddress']") )
            private WebElement submitSaveAddress;

    public AddressAddPage(WebDriver driver) {
        super(driver);
    }

    public String firstnameNotEmpty() {
        return firstname.getAttribute("value");
    }

    public String lastnameNotEmpty() {
        return lastname.getAttribute("value");

    }
    public AddressAddPage selectState (String stateValue) {
        Select sel = new Select(state);
        WebElement option = sel.getFirstSelectedOption();
        Assertions.assertEquals("-",option.getText()," Значение State не по умолчанию");
        state.click();
        sel.selectByVisibleText(stateValue);
        state.click();
        return this;
    }

        public String selectCountryNotEmpty() {
        return selectCountry.getText();
        }

        public String companyIsEmpty () {
        return company.getAttribute("value");
    }
    public String addressSecondIsEmpty () {
        return addressSecond.getAttribute("value");
    }
    public String additionalInformationIsEmpty () {
        return additionalInformation.getAttribute("value");
    }

   public AddressAddPage addressEnter (String addressCity) {
        this.address.click();
        this.address.sendKeys(addressCity);
        return this;
    }
    public void  valueEnter (String addressCity, String city, String postcode,String phone,String phoneMobile) {
        Actions valuesEnter = new Actions(getDriver()) ;
        valuesEnter.click(this.address).sendKeys(this.address,addressCity).click(this.city).sendKeys(this.city,city).click(this.postcode).sendKeys(this.postcode,postcode).
                click(this.phone).sendKeys(this.phone,phone).click(this.phoneMobile).sendKeys(this.phoneMobile,phoneMobile).build().perform();

            }
     public  AddressAddPage aliasEnter (String alias){
         this.alias.click();
         this.alias.clear();
         this.alias.sendKeys(alias);
         return this;
     }

     public void submitSentAddress(){
         submitSaveAddress.click();
         new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='first_item item box']")));
     }

}