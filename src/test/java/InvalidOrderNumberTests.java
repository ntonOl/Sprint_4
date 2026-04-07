import org.hamcrest.MatcherAssert;
import org.junit.Test;
import ru.praktikum.services.qa.scooter.MainPage;
import ru.praktikum.services.qa.scooter.OrderStatusPage;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class InvalidOrderNumberTests extends OpeningClosingMainPage {

    @Test
    public void checkTransitionToStatusPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.orderStatusCheck("-1");
        mainPage.isItPage("https://qa-scooter.praktikum-services.ru/track");
    }

    @Test
    public void notFoundStatusTextCheck() {
        MainPage mainPage = new MainPage(driver);
        mainPage.orderStatusCheck("-1");

        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
        MatcherAssert.assertThat(orderStatusPage.notFoundStatusTextGet(),
                anyOf(equalToIgnoringCase("Not found"),
                        equalToIgnoringCase("Такого заказа нет")));
    }

}
