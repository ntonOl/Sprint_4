import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.MainPage;
import pageObject.OrderStatusPage;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class InvalidOrderNumberTests {
    private WebDriver driver;

    @Test
    public void CheckTransitionToStatusPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);

        mainPage.orderStatusCheck("-1");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track"));

    }

    @Test
    public void notFoundStatusTextCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.orderStatusCheck("-1");

        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
        MatcherAssert.assertThat(orderStatusPage.notFoundStatusTextGet(),
                anyOf(equalToIgnoringCase("Not found"),
                        equalToIgnoringCase("Такого заказа нет")));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
