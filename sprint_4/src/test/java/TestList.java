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
public class TestList {
    private WebDriver driver ;
    private final String browser;

   private final int questionIndex;
    private final String expectedAnswer;


    public TestList (String browser, int questionIndex, String expectedAnswer) {
        this.browser = browser;
        this.questionIndex = questionIndex;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters (name = "Браузер: {0}, Тестовые данные: {1} {2}")
    public static Object[][] checkList() {
        return new Object[][] {
                {"chrome", 1,"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"chrome", 2,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"chrome", 3,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"chrome", 4,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"chrome", 5,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"chrome", 6,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"chrome", 7,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"chrome", 8,"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
                {"firefox", 1,"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"firefox", 2,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"firefox", 3,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"firefox", 4,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"firefox", 5,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"firefox", 6,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"firefox", 7,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"firefox", 8,"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
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
    public void checkTestList () {
        driver.get(PageMain.URL);

        PageMain pageMain = new PageMain(driver);
        pageMain.clickButtonCookie();
        pageMain.scrollImportantQuestionTitle();
        String actualAnswer = pageMain.clickQuestion(questionIndex);
        assertEquals(expectedAnswer, actualAnswer);

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}