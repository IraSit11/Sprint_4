package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageStatusOrder {
    private WebDriver driver;

    private By statusNotFound = By.xpath(".//img[@alt='Not found']");

    public PageStatusOrder (WebDriver driver){
        this.driver = driver;
    }

    public void checkSearchResult () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusNotFound));
        driver.findElement(statusNotFound).isDisplayed();
    }

    }
