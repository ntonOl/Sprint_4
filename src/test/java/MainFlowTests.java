import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.MainPage;
import pageObject.OrderForm;


@RunWith(Parameterized.class)
public class MainFlowTests {
    private WebDriver driver;

    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String rentPeriod;
    private final String color;
    private final String comment;

    public MainFlowTests(String name, String lastName,
                         String address, String metro, String phone, String date,
                         String rentPeriod, String color, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.rentPeriod = rentPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDataSetForOrder() {
        return new Object[][]{
                {"Яна", "Павловна", "Казинца 99, Москва", "Сокольники",
                        "+7234234234", "20.04.2026", "сутки", "black", "Комментарий"},
                {"Наталья", "Семченко", "Москва", "Бульвар Рокоссовского",
                        "00000000000", "01.01.2000", "семеро суток", "grey", ""}
        };
    }

    @Test
    public void OrderWithTopButtonTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        /*FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");*/

        MainPage mainPage = new MainPage(driver);

        mainPage.topOrderButtonClick();

        OrderForm orderForm = new OrderForm(driver);

        orderForm.fillingOutOrderForm(name, lastName, address, metro,
                phone, date, rentPeriod, color, comment);

        orderForm.isSuccessfulOrder();

        driver.quit();

    }


    @Test
    public void OrderWithBottomButtonTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        /*FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");*/

        MainPage mainPage = new MainPage(driver);

        mainPage.bottomOrderButtonClick();

        OrderForm orderForm = new OrderForm(driver);

        orderForm.fillingOutOrderForm(name, lastName, address, metro,
                phone, date, rentPeriod, color, comment);

        orderForm.isSuccessfulOrder();

        driver.quit();

    }

    /*@After
    public void tearDown() {
        driver.quit();
    }*/

}
