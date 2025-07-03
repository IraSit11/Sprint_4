import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.PageMain;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestList {
   private final int questionIndex;
    private final String expectedAnswer;


    public TestList (int questionIndex, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] checkList() {
        return new Object[][] {
                {1,"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {2,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {3,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {4,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {5,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {6,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {7,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {8,"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    //Тест в Chrome
    @Test
    public void checkTest() {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        WebElement element = driver.findElement(By.className("Home_FourPart__1uthg"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        String actualAnswer = pageMain.clickQuestion(questionIndex);
        assertEquals(expectedAnswer, actualAnswer);
        driver.quit();
    }

    //Тест в Firefox
    @Test
    public void checkTestFirefox () {
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        WebElement element = driver.findElement(By.className("Home_FourPart__1uthg"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        String actualAnswer = pageMain.clickQuestion(questionIndex);
        assertEquals(expectedAnswer, actualAnswer);
        driver.quit();
    }
}