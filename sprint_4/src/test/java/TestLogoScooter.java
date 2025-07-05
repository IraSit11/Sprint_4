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
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLogoScooter {
    private WebDriver driver ;
    private final String browser;

    public TestLogoScooter(String browser) {
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
    public void clickLogoScooter() {

        driver.get("https://qa-scooter.praktikum-services.ru/track?t=");
        PageMain pageMain = new PageMain(driver);
        pageMain.clickLogoScooter();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = PageMain.URL;

        assertEquals(expectedUrl, currentUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
