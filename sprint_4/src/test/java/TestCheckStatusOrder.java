import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.PageMain;
import pages.PageStatusOrder;


public class TestCheckStatusOrder {

    @Test
    public void checkStatusOrderChrome() {
        String number = "554";
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        pageMain.checkStatusOrder(number);
        PageStatusOrder pageStatusOrder = new PageStatusOrder();
        pageStatusOrder.checkSearchResult();
        driver.quit();
    }

    @Test
    public void checkStatusOrderFirefox() {
        String number = "554";
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        pageMain.checkStatusOrder(number);
        PageStatusOrder pageStatusOrder = new PageStatusOrder();
        pageStatusOrder.checkSearchResult();
        driver.quit();
    }
}
