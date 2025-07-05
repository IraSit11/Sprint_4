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
import pages.PageOrder;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class TestOrder {
    private WebDriver driver ;
    private final String browser;

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final boolean isPlaced;

    public TestOrder (String browser, String name, String surname, String address, String metro, String phone, String date, boolean isPlaced) {
        this.browser = browser;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.isPlaced = isPlaced;
    }
    @Parameterized.Parameters (name = "Браузер: {0}, Тестовые данные: {1} {2} {3} {4} {5} {6} {7}")
    public static Object[][] getOrderDetails() {
        return new Object[][] {
                {"chrome","Петр", "Петров", "Комсомольский пр., 36", "Фрунзенская", "89814566545", "02.07.2025", true},
                {"firefox","Петр", "Петров", "Комсомольский пр., 36", "Фрунзенская", "89814566545", "02.07.2025", true},
                {"chrome","Мария", "Сидорова", "Молочный пер., 4", "Парк Культуры", "89814567898", "14.07.2025", true},
                {"firefox","Мария", "Сидорова", "Молочный пер., 4", "Парк Культуры", "89814567898", "14.07.2025", true},
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

    //Тест  кнопка "Заказать" наверху
    @Test
    public void orderTestOnTop () {
        driver.get(PageMain.URL);
        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        pageMain.clickOrderButtonTop();

        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.order(name,surname, address,metro,phone,date);
        pageOrder.waitOrderModalIsDisplayed();

         assertEquals(isPlaced,driver.findElement(pageOrder.orderModal).isDisplayed());
         }


    //Тест кнопка "Заказать" внизу
    @Test
    public void orderTestOnBottom () {
        driver.get(PageMain.URL);

        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        pageMain.clickOrderButtonBottom();

        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.order(name,surname, address,metro,phone,date);
        pageOrder.waitOrderModalIsDisplayed();

        assertEquals(isPlaced,driver.findElement(pageOrder.orderModal).isDisplayed());
        }

    @After
    public void tearDown() {
        driver.quit();
    }
}
