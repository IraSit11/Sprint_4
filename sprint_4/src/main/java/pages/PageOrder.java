package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageOrder {
    private WebDriver driver;

    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriodField = By.xpath(".//div[@class='Dropdown-root']");
    private By orderButton = By.xpath(".//button[contains(@class,'Button_Middle__1CSJM') and contains(text(),'Заказать')]");
    private By consentButton = By.xpath(".//button[text()='Да']");
    public By orderModal = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(),'Заказ оформлен')]");

    public PageOrder (WebDriver driver) {
        this.driver = driver;
    }

//Заполнение полей с персональной информацией
    public void fillOrderForm (String name, String surname, String address, String metro, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys(metro);
        driver.findElement(By.xpath(".//div[@class='select-search__select']")).click();
        driver.findElement(phoneField).sendKeys(phone);
    }
//Нажатие на кнопку далее
    public void clickNextButton () {
        driver.findElement(nextButton).click();
    }
//Заполнение полей даты и срока заказа
    public void fillRentalData (String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(By.xpath(".//div[contains(@class,'react-datepicker__day--selected')]")).click();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.className("Dropdown-option")).click();
    }
//Нажатие на кнопку "Заказать"
    public void  clickOrderButton () {
        driver.findElement(orderButton).click();
    }
//Нажатие на кнопку подтвержедения
    public void clickConsentButton() {
        driver.findElement(consentButton).click();
    }
//Объединение шагов в один метод
    public  void order (String name, String surname, String address, String metro, String phone, String date) {
        fillOrderForm(name, surname, address, metro, phone);
        clickNextButton();
        fillRentalData(date);
        clickOrderButton();
        clickConsentButton();

    }
//Дождаться появления окна "Заказ оформлен"
    public void waitOrderModalIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderModal));
    }
}
