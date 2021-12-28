package org.example.autoPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage extends AbstractPage {
    @FindBy (xpath = "//div[@class='header_user_info']/a[@title='Log in to your customer account']")
    private WebElement submitSignIn;

    public MainPage (WebDriver driver) {
        super(driver);
    }

    public void submitSignInClick (){
        submitSignIn.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[@id='authentication']")));
    }


}
