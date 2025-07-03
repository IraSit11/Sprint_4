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
    private final String name;
    private final String surname;
    private final String adress;
    private final String metro;
    private final String phone;
    private final String date;
    private final boolean isPlaced;

    public TestOrder (String name, String surname, String address, String metro, String phone, String date, boolean isPlaced) {
        this.name = name;
        this.surname = surname;
        this.adress = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.isPlaced = isPlaced;
    }
    @Parameterized.Parameters
    public static Object[][] getOrderDetails() {
        return new Object[][] {
                {"Петр", "Петров", "Комсомольский пр., 36", "Фрунзенская", "89814566545", "02.07.2025", true},
                {"Мария", "Сидорова", "Молочный пер., 4", "Парк Культуры", "89814567898", "14.07.2025", true},
        };
    }

    //Тест в Chrome, кнопка "Заказать" наверху
    @Test
    public void orderTestOnTop () {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        pageMain.clickOrderButtonTop();

        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.order(name,surname,adress,metro,phone,date);
        pageOrder.waitOrderModalIsDisplayed();

         assertEquals(isPlaced,driver.findElement(pageOrder.orderModal).isDisplayed());
          driver.quit();
    }

    //Тест в Firefox, кнопка "Заказать" наверху
    @Test
    public void orderTestOnTopFirefox () {
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        pageMain.clickOrderButtonTop();

        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.order(name,surname,adress,metro,phone,date);
        pageOrder.waitOrderModalIsDisplayed();

         assertEquals(isPlaced,driver.findElement(pageOrder.orderModal).isDisplayed());
          driver.quit();
    }

    //Тест в Chrome, кнопка "Заказать" внизу
    @Test
    public void orderTestOnBottom () {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        pageMain.clickOrderButtonBottom();

        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.order(name,surname,adress,metro,phone,date);
        pageOrder.waitOrderModalIsDisplayed();

        assertEquals(isPlaced,driver.findElement(pageOrder.orderModal).isDisplayed());
        driver.quit();
    }

    //Тест в Firefox, кнопка "Заказать" внизу
    @Test
    public void orderTestOnBottomFirefox () {
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        pageMain.clickOrderButtonBottom();

        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.order(name,surname,adress,metro,phone,date);
        pageOrder.waitOrderModalIsDisplayed();

        assertEquals(isPlaced,driver.findElement(pageOrder.orderModal).isDisplayed());
        driver.quit();
    }


}
