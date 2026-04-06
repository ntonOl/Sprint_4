import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.OrderForm;

public class OrderFormErrorsTests {
    private WebDriver driver;

    @Test
    public void NameErrorCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        orderForm.isNameErrorVisible();
    }

    @Test
    public void LastNameErrorCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        orderForm.isLastNameErrorVisible();
    }

    @Test
    public void AddressErrorCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        orderForm.isAddressErrorVisible();
    }

    @Test
    public void MetroErrorCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        orderForm.isMetroErrorVisible();
    }

    @Test
    public void PhoneErrorCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        orderForm.isPhoneErrorVisible();
    }


    @Test
    public void DateErrorCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderForm orderForm = new OrderForm(driver);

        orderForm.setName("Полина");
        orderForm.setLastName("Сергеевна");
        orderForm.setAddress("Москва");
        orderForm.setMetro("Сокольники");
        orderForm.setPhone("+7234234234");
        orderForm.nextButtonClick();

        orderForm.orderButtonEndClick();
        orderForm.isDateErrorVisible();
    }


    @Test
    public void RentPeriodErrorCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderForm orderForm = new OrderForm(driver);

        orderForm.setName("Полина");
        orderForm.setLastName("Сергеевна");
        orderForm.setAddress("Москва");
        orderForm.setMetro("Сокольники");
        orderForm.setPhone("+7234234234");
        orderForm.nextButtonClick();

        orderForm.orderButtonEndClick();
        orderForm.isRentPeriodErrorVisible();
    }

    @Test
    public void ColorChooseErrorCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderForm orderForm = new OrderForm(driver);

        orderForm.setName("Полина");
        orderForm.setLastName("Сергеевна");
        orderForm.setAddress("Москва");
        orderForm.setMetro("Сокольники");
        orderForm.setPhone("+7234234234");
        orderForm.nextButtonClick();

        orderForm.orderButtonEndClick();
        orderForm.isColorChooseErrorVisible();
    }


    @Test
    public void CommentFieldErrorCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderForm orderForm = new OrderForm(driver);

        orderForm.setName("Полина");
        orderForm.setLastName("Сергеевна");
        orderForm.setAddress("Москва");
        orderForm.setMetro("Сокольники");
        orderForm.setPhone("+7234234234");
        orderForm.nextButtonClick();

        orderForm.orderButtonEndClick();
        orderForm.isCommentFieldErrorVisible();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
