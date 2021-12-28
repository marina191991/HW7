package org.example.autoPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public abstract class AbstractTest {

    static WebDriverWait wait;
    static EventFiringWebDriver eventDriver;

    @BeforeAll
    static void SetDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments ("start-maximized"); // открытие полноэкранного формата
        options.addArguments ("--incognito");// открытие страницы в режиме инкогнито
        options.addArguments ("version"); //
        options.addArguments ("disable-popup-blocking"); //блокировка всплывающих окон
        eventDriver=new EventFiringWebDriver(new ChromeDriver(options));
        eventDriver.register(new MyWebDriverEvenListener());
        wait = new WebDriverWait(eventDriver,Duration.ofSeconds(15));

    }

    @BeforeEach
    void initMainPage () {
        Assertions.assertDoesNotThrow(()->getWebDriver().navigate().to("http://automationpractice.com/index.php"),"Страница не найдена"); //открыли страницу
        new MainPage(getWebDriver()).submitSignInClick();
    }

    @AfterEach
public void checkBrowser() {
        List<LogEntry> allLogRows = getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
        if (!allLogRows.isEmpty()) {
            allLogRows.forEach(LogEntry -> {
                System.out.println(LogEntry.getMessage());
            });
        }
    }
    void deleteAllCookies() {
                eventDriver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void close(){
        eventDriver.close();
    }
    public WebDriver getWebDriver() {return this.eventDriver;}
}
