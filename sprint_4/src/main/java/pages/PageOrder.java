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
    private By selectMetro = By.xpath(".//div[@class='select-search__select']");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By selectDate = By.xpath(".//div[contains(@class,'react-datepicker__day--selected')]");
    private By rentalPeriodField = By.xpath(".//div[@class='Dropdown-root']");
    private By periodList = By.className("Dropdown-option");
    private By orderButton = By.xpath(".//button[contains(@class,'Button_Middle__1CSJM') and contains(text(),'Заказать')]");
    private By consentButton = By.xpath(".//button[text()='Да']");
    public By orderModal = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(),'Заказ оформлен')]");

    public PageOrder (WebDriver driver) {
        this.driver = driver;
    }

    public void sendNameField (String name) {driver.findElement(nameField).sendKeys(name);}
    public void sendSurnameField (String surname) {driver.findElement(surnameField).sendKeys(surname);}
    public void sendAddressField (String address) {driver.findElement(addressField).sendKeys(address);}
    public void sendMetroField (String metro) {driver.findElement(metroField).click(); driver.findElement(metroField).sendKeys(metro);}
    public void clickMetroStation () {driver.findElement(selectMetro).click();}
    public void sendPhoneField (String phone) {driver.findElement(phoneField).sendKeys(phone);}

//Заполнение полей с персональной информацией
    public void fillOrderForm (String name, String surname, String address, String metro, String phone) {
        sendNameField(name);
        sendSurnameField(surname);
        sendAddressField(address);
        sendMetroField(metro);
        clickMetroStation();
        sendPhoneField(phone);
    }
//Нажатие на кнопку далее
    public void clickNextButton () {
        driver.findElement(nextButton).click();
    }

    public void sendDateField (String date){driver.findElement(dateField).sendKeys(date);}
    public void clickSelectDate () { driver.findElement(selectDate).click();}
    public void clickRentalPeriodField () {driver.findElement(rentalPeriodField).click();}
    public void clickPeriodList () {driver.findElement(periodList).click();}

//Заполнение полей даты и срока заказа
    public void fillRentalData (String date) {
        sendDateField(date);
        clickSelectDate();
        clickRentalPeriodField();
        clickPeriodList();
    }
//Нажатие на кнопку "Заказать"
    public void  clickOrderButton () {
        driver.findElement(orderButton).click();
    }
//Нажатие на кнопку подтверждения
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
