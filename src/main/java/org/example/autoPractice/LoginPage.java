package org.example.autoPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage extends AbstractPage {


    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage emailSend(String email) {
        this.email.click();
        this.email.sendKeys(email);
        return this;
    }

    public LoginPage passwordSend(String pass) {
        this.password.click();
        this.password.sendKeys(pass);
        return this;
    }

    public LoginPage submitLoginClick() {
        submitLogin.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[@id='my-account']")));
        return this;
    }
    public LoginPage submitLoginClickInvalid() {
        submitLogin.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[@id='authentication']")));
        return this;
    }

    public void authentication(String email, String pass) {
        Actions authentication = new Actions(getDriver()) ;
            authentication.click(this.email).sendKeys(this.email,email).click(this.password)
                    .sendKeys(this.password,pass).click(submitLogin).build().perform();

    }
}