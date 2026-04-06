package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    // Пункты списка Вопросы о важном
    private By listItems = By.className("accordion__item");

    // Список описаний пунктов Вопросы о важном
    private By listOfTexts = By.xpath(".//div[@class='accordion__panel']/p");

    //Верхняя кнопка заказа
    private By topOrderButton = By.className("Button_Button__ra12g");

    //Нижняя кнопка заказа
    private By bottomOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //логотип Самоката
    private By scooterLogo = By.className("Header_LogoScooter__3lsAR");

    //логотип Яндекса
    private By yandexLogo = By.className("Header_LogoYandex__3TSOI");

    //Кнопка Статус Заказа
    private By orderStatusButton = By.className("Header_Link__1TAG7");

    //Поле ввода номера заказа
    private By orderNumberInput = By.xpath(".//input[@class" +
            "='Input_Input__1iN_Z Header_Input__xIoUq']");

    //Кнопка Go! для просмотра статуса введённого номера заказа
    private By goButton = By.xpath(".//button[@class" +
            "='Button_Button__ra12g Header_Button__28dPO']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Клик по одному пункту списка Вопросы о важном
    public void listItemClick (int index) {
        List<WebElement> elements = driver.findElements(listItems);

        List<WebElement> cookies = driver.findElements(CookieConsent.getCookieButton());
        if (!cookies.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(CookieConsent.getCookieButton()));
        }

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(elements.get(index)))
                .click();
    }

    //Получить текст элемента списка Вопросы о важном
    public String getItemText (int index) {
        List<WebElement> elements = driver.findElements(listOfTexts);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(elements.get(index)));
        return elements.get(index).getText();
    }

    // Клик по верхней кнопке заказа
    public void topOrderButtonClick() {
        List<WebElement> cookies = driver.findElements(CookieConsent.getCookieButton());
        if (!cookies.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(CookieConsent.getCookieButton()));
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(topOrderButton)))
                .click();

    }

    // Клик по нижней кнопке заказа
    public void bottomOrderButtonClick() {
        List<WebElement> cookies = driver.findElements(CookieConsent.getCookieButton());
        if (!cookies.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(CookieConsent.getCookieButton()));
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(bottomOrderButton)))
                .click();

    }

    //Клик по логотипу самоката
    public void scooterLogoClick() {
        List<WebElement> cookies = driver.findElements(CookieConsent.getCookieButton());
        if (!cookies.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(CookieConsent.getCookieButton()));
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(scooterLogo)))
                .click();

    }

    //Клик по логотипу яндекса
    public void yandexLogoClick() {
        List<WebElement> cookies = driver.findElements(CookieConsent.getCookieButton());
        if (!cookies.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(CookieConsent.getCookieButton()));
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(yandexLogo)))
                .click();

    }

    //Перейти на страницу заказа с указанным номером
    public void orderStatusCheck(String orderNumber) {
        List<WebElement> cookies = driver.findElements(CookieConsent.getCookieButton());
        if (!cookies.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(CookieConsent.getCookieButton()));
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(orderStatusButton)))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(orderNumberInput)))
                .sendKeys(orderNumber);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(goButton)))
                .click();
    }
}
