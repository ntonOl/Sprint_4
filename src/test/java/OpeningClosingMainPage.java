import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.services.qa.scooter.MainPage;

public class OpeningClosingMainPage {

    protected WebDriver driver;

    @Before
    public void openMainPageInChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(MainPage.getMainPageUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
