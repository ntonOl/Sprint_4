
import org.junit.Test;
import ru.praktikum.services.qa.scooter.OrderForm;

public class OrderFormErrorsTests extends OpeningClosingOrderPage {

    @Test
    public void nameErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        orderForm.isNameErrorVisible();
    }

    @Test
    public void lastNameErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        orderForm.isLastNameErrorVisible();
    }

    @Test
    public void addressErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        orderForm.isAddressErrorVisible();
    }

    @Test
    public void metroErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        orderForm.isMetroErrorVisible();
    }

    @Test
    public void phoneErrorCheck() {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.nextButtonClick();
        orderForm.isPhoneErrorVisible();
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
        orderForm.isDateErrorVisible();
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
        orderForm.isRentPeriodErrorVisible();
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
        orderForm.isColorChooseErrorVisible();
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
        orderForm.isCommentFieldErrorVisible();
    }

}
