
import org.junit.Test;
import ru.praktikum.services.qa.scooter.OrderForm;

import static org.junit.Assert.assertTrue;

public class OrderFormErrorsTests extends OpeningClosingOrderPage {

    @Test
    public void nameErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        assertTrue("Сообщение об ошибке не появилось",
                orderForm.isNameErrorVisible());
    }

    @Test
    public void lastNameErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        assertTrue("Сообщение об ошибке не появилось",
                orderForm.isLastNameErrorVisible());
    }

    @Test
    public void addressErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        assertTrue("Сообщение об ошибке не появилось",
                orderForm.isAddressErrorVisible());
    }

    @Test
    public void metroErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        assertTrue("Сообщение об ошибке не появилось",
                orderForm.isMetroErrorVisible());
    }

    @Test
    public void phoneErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        assertTrue("Сообщение об ошибке не появилось",
                orderForm.isPhoneErrorVisible());
    }


    @Test
    public void dateErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);

        orderForm.setName("Полина");
        orderForm.setLastName("Сергеевна");
        orderForm.setAddress("Москва");
        orderForm.setMetro("Сокольники");
        orderForm.setPhone("+7234234234");
        orderForm.nextButtonClick();

        orderForm.orderButtonEndClick();
        assertTrue("Сообщение об ошибке не появилось",
                orderForm.isDateErrorVisible());
    }


    @Test
    public void rentPeriodErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);

        orderForm.setName("Полина");
        orderForm.setLastName("Сергеевна");
        orderForm.setAddress("Москва");
        orderForm.setMetro("Сокольники");
        orderForm.setPhone("+7234234234");
        orderForm.nextButtonClick();

        orderForm.orderButtonEndClick();
        assertTrue("Сообщение об ошибке не появилось",
                orderForm.isRentPeriodErrorVisible());
    }

    @Test
    public void colorChooseErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);

        orderForm.setName("Полина");
        orderForm.setLastName("Сергеевна");
        orderForm.setAddress("Москва");
        orderForm.setMetro("Сокольники");
        orderForm.setPhone("+7234234234");
        orderForm.nextButtonClick();

        orderForm.orderButtonEndClick();
        assertTrue("Сообщение об ошибке не появилось",
                orderForm.isColorChooseErrorVisible());
    }


    @Test
    public void commentFieldErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);

        orderForm.setName("Полина");
        orderForm.setLastName("Сергеевна");
        orderForm.setAddress("Москва");
        orderForm.setMetro("Сокольники");
        orderForm.setPhone("+7234234234");
        orderForm.nextButtonClick();

        orderForm.orderButtonEndClick();
        assertTrue("Сообщение об ошибке не появилось",
                orderForm.isCommentFieldErrorVisible());
    }

}
