package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageMain {
    private WebDriver driver;
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private By orderButtonTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    private By orderButtonBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    private By cookieButton = By.xpath(".//button[text()='да все привыкли']");
    private By importantQuestionTitle = By.className("Home_FourPart__1uthg");
    private By question(int index) {
        return By.xpath("(.//div[contains(@class, 'accordion__heading')])[" + index + "]");
    }

    private By answerText(int index) {
        return By.xpath("(.//div[contains(@id, 'accordion__panel')])[" + index + "]");
    }
    private By logoScooter = By.className("Header_LogoScooter__3lsAR");
    private By statusOrderButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private By numberOrder =  By.xpath(".//input[contains(@placeholder,'Введите номер заказа')]");
    private By goButton = By.xpath(".//button[contains(@class,'Button_Button__ra12g') and contains(text(),'Go!')]");


    public PageMain(WebDriver driver) {

        this.driver = driver;
    }

    //Принять куки
    public void clickButtonCookie (){
        driver.findElement(cookieButton).click();
    }

    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    public void scrollImportantQuestionTitle() {
        WebElement element = driver.findElement(importantQuestionTitle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String clickQuestion (int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(question(index)));
        driver.findElement(question(index)).click();
        WebElement answerElement = driver.findElement(answerText(index));
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerText(index)));
        return answerElement.getText();
    }

    public void clickLogoScooter () {
        driver.findElement(logoScooter).click();
    }


    public void clickStatusOrderButton () {
        driver.findElement(statusOrderButton).click();
    }

    public void inputNumberOrder (String number) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(numberOrder));
        driver.findElement(numberOrder).click();
        driver.findElement(numberOrder).sendKeys(number);
    }

    public void clickGoButton () {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(goButton));
        driver.findElement(goButton).click();
    }

    //Объединение методов на проверку статуса заказа
    public void checkStatusOrder (String number) {
        clickStatusOrderButton();
        inputNumberOrder(number);
        clickGoButton();
    }
}





