package ru.praktikum.services.qa.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderForm {
    private WebDriver driver;

    //Поле ввода имени
    private By nameInputField = By.xpath(".//input[@placeholder='* Имя']");

    //Поле ввода фамилии
    private By lastnameInputField = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле ввода адреса
    private By addressInputField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле выбора метро
    private By metroInputField = By.xpath(".//input[@placeholder='* Станция метро']");

    //Поле ввода телефона
    private By phoneInputField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка далее
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Поле выбора даты
    private By dateInputField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Выбранная в календаре дата
    private By selectedDate = By.xpath(".//div[contains(@class,'react-datepicker__day--selected')]");

    //Поле выбора срока аренды
    private By rentPeriodInputField = By.className("Dropdown-control");

    //Чекбокс чёрного цвета
    private By blackColorCheckbox = By.xpath(".//label[@for='black']");

    //Чекбокс серого цвета
    private By greyColorCheckbox = By.xpath(".//label[@for='grey']");

    //Поле комментария для курьера
    private By commentInputField = By.xpath(".//input[@placeholder" +
            "='Комментарий для курьера']");

    //Кнопка Заказать в конце формы
    private By orderButtonEnd = By.xpath(".//button[@class" +
            "='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка Да в окне Хотите оформить заказ
    private By yesButton = By.xpath(".//button[@class" +
            "='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //Сообщение об успешном заказе
    private By successfulOrderMessage = By.className("Order_ModalHeader__3FDaJ");

    //Ошибка поля Имя
    private By nameError = By.xpath(".//input[@placeholder='* Имя']" +
            "/parent::div/div[contains(@class,'Error')]");

    //Ошибка поля Фамилия
    private By lastNameError = By.xpath(".//input[@placeholder='* Фамилия']" +
            "/parent::div/div[contains(@class,'Error')]");

    //Ошибка поля адреса
    private By addressError = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']" +
            "/parent::div/div[contains(@class,'Error')]");

    //Ошибка поля ввода метро
    private By metroError = By.xpath(".//div[@class='Order_UnderError__1VSDB']" +
            "//div[contains(@class,'Error')]");

    //Ошибка поля телефона
    private By phoneError = By.xpath(".//input[@placeholder='* Телефон: на " +
            "него позвонит курьер']/parent::div/div[contains(@class,'Error')]");

    //Ошибка поля даты
    private By dateError = By.xpath(".//div[@class='Order_MixedDatePicker__3qiay']" +
            "//div[contains(@class,'Error')]");

    //Ошибка поля срока аренды
    private By rentPeriodError = By.xpath(".//div[@class='Dropdown-root']" +
            "//div[contains(@class,'Error')]");

    //Ошибка поля выбора цвета
    private By colorChooseError = By.xpath(".//div[@class='Order_Checkboxes__3lWSI']" +
            "//div[contains(@class,'Error')]");

    //Ошибка поля с комментарием
    private By commentFieldError = By.xpath(".//input[@placeholder='Комментарий для курьера']" +
            "/parent::div/div[contains(@class,'Error')]");

    public OrderForm(WebDriver driver) {
        this.driver = driver;
    }

    //Ввод имени
    public void setName(String name) {
        List<WebElement> cookies = driver.findElements(CookieConsent.getCookieButton());
        if (!cookies.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(CookieConsent.getCookieButton()));
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(nameInputField))
                .clear();
        driver.findElement(nameInputField).sendKeys(name);
    }

    //Ввод фамилии
    public void setLastName(String lastName) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(lastnameInputField))
                .clear();
        driver.findElement(lastnameInputField).sendKeys(lastName);
    }

    //Ввод адреса
    public void setAddress(String address) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(addressInputField))
                .clear();
        driver.findElement(addressInputField).sendKeys(address);
    }

    //Выбор станции метро
    public void setMetro(String metro) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(metroInputField))
                .sendKeys(metro);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class" +
                        "='Order_Text__2broi' and contains(text(), '" + metro + "')]")))
                .click();
    }

    //Ввод телефона
    public void setPhone(String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(phoneInputField))
                .clear();
        driver.findElement(phoneInputField).sendKeys(phone);
    }

    //Клик по кнопке Далее
    public void nextButtonClick() {
        List<WebElement> cookies = driver.findElements(CookieConsent.getCookieButton());
        if (!cookies.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(CookieConsent.getCookieButton()));
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(nextButton))
                .click();
    }

    //Ввод даты
    public void setDate(String date) {
        List<WebElement> cookies = driver.findElements(CookieConsent.getCookieButton());
        if (!cookies.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(CookieConsent.getCookieButton()));
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(dateInputField))
                .clear();
        driver.findElement(dateInputField).sendKeys(date);
        driver.findElement(selectedDate).click();

    }

    //Выбор срока аренды
    public void setRentPeriod(String rentPeriod) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(rentPeriodInputField))
                .click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[" +
                        "@class='Dropdown-option' and text()='" + rentPeriod + "']")))
                .click();
    }

    //Выбор цвета
    public void setColor(String color) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(blackColorCheckbox));
        if (color.equalsIgnoreCase("black")) {
            driver.findElement(blackColorCheckbox).click();
        } else if (color.equalsIgnoreCase("grey")) {
            driver.findElement(greyColorCheckbox).click();
        }
    }

    //Ввод комментария
    public void setComment(String comment) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(commentInputField))
                .clear();
        driver.findElement(commentInputField).sendKeys(comment);
    }

    //Нажать кнопку Заказать
    public void orderButtonEndClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderButtonEnd))
                .click();
    }

    //Нажать кнопку Да в окне Хотите оформить заказ
    public void yesButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(yesButton))
                .click();
    }

    //Заполнить и отправить форму заказа
    public void fillingOutOrderForm(String name, String lastName,
                                    String address, String metro, String phone, String date,
                                    String rentPeriod, String color, String comment) {
        setName(name);
        setLastName(lastName);
        setAddress(address);
        setMetro(metro);
        setPhone(phone);
        nextButtonClick();
        setDate(date);
        setRentPeriod(rentPeriod);
        setColor(color);
        setComment(comment);
        orderButtonEndClick();
        yesButtonClick();
    }

    //Проверка сообщения об успешном заказе
    public void isSuccessfulOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(successfulOrderMessage,
                        "Заказ оформлен"));
    }

    //Проверка ошибки поля Имя
    public void isNameErrorVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(nameError));
    }

    //Проверка ошибки поля Фамилия
    public void isLastNameErrorVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(lastNameError));
    }

    //Проверка ошибки поля Адрес
    public void isAddressErrorVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(addressError));
    }

    //Проверка ошибки поля метро
    public void isMetroErrorVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(metroError));
    }

    //Проверка ошибки поля ввода телефона
    public void isPhoneErrorVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(phoneError));
    }

    //Проверка ошибки поля даты
    public void isDateErrorVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(dateError));
    }

    //Проверка ошибки поля срока аренды
    public void isRentPeriodErrorVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(rentPeriodError));
    }

    //Проверка ошибки поля срока аренды
    public void isColorChooseErrorVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(colorChooseError));
    }

    //Проверка ошибки поля срока аренды
    public void isCommentFieldErrorVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(commentFieldError));
    }

}
