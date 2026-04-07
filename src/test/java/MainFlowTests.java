import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.services.qa.scooter.MainPage;
import ru.praktikum.services.qa.scooter.OrderForm;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class MainFlowTests extends OpeningClosingMainPage {

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

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2} {3} {4} {5} {6} {7} {8}")
    public static Object[][] getDataSetForOrder() {
        return new Object[][]{
                {"Яна", "Павловна", "Казинца 99, Москва", "Сокольники",
                        "+7234234234", "20.04.2026", "сутки", "black", "Комментарий"},
                {"Наталья", "Семченко", "Москва", "Бульвар Рокоссовского",
                        "00000000000", "01.01.2000", "семеро суток", "grey", ""}
        };
    }

    @Test
    public void orderWithTopButtonTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.topOrderButtonClick();

        OrderForm orderForm = new OrderForm(driver);

        orderForm.fillingOutOrderForm(name, lastName, address, metro,
                phone, date, rentPeriod, color, comment);

        assertTrue("Сообщение об успешном заказе не появилось",
                orderForm.isSuccessfulOrder());

    }


    @Test
    public void orderWithBottomButtonTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.bottomOrderButtonClick();

        OrderForm orderForm = new OrderForm(driver);

        orderForm.fillingOutOrderForm(name, lastName, address, metro,
                phone, date, rentPeriod, color, comment);

        assertTrue("Сообщение об успешном заказе не появилось",
                orderForm.isSuccessfulOrder());

    }

}
