import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.PageMain;

import static org.junit.Assert.assertEquals;

public class TestLogoScooter {

    @Test
    public void clickLogoScooterChrome() {

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/track?t=");
        PageMain pageMain = new PageMain(driver);
        pageMain.clickLogoScooter();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";

        assertEquals(expectedUrl, currentUrl);
        driver.quit();
    }
    @Test
    public void clickLogoScooterFirefox() {

        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/track?t=");
        PageMain pageMain = new PageMain(driver);
        pageMain.clickLogoScooter();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";

        assertEquals(expectedUrl, currentUrl);
        driver.quit();
    }
}
