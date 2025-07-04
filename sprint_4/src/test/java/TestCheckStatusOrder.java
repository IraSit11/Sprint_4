import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.PageMain;
import pages.PageStatusOrder;

@RunWith(Parameterized.class)
public class TestCheckStatusOrder {
    private WebDriver driver;
    private final String browser;

    public TestCheckStatusOrder(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Браузер: {0}")
    public static Object[][] checkBrowser() {
        return new Object[][]{
                {"chrome"},
                {"firefox"},
        };
    }

    @Before
    public void setBrowser () {

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        }
    }
    @Test
    public void checkStatusOrder() {
        String number = "554";

        driver.get(PageMain.URL);
        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        pageMain.checkStatusOrder(number);
        PageStatusOrder pageStatusOrder = new PageStatusOrder(driver);
        pageStatusOrder.checkSearchResult();

    }

        @After
    public void tearDown() {
        driver.quit();
    }
}
