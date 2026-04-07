
import org.junit.Test;
import ru.praktikum.services.qa.scooter.MainPage;


public class LogoClickTests extends OpeningClosingMainPage {

    @Test
    public void scooterLogoClickCheck() {
        MainPage mainPage = new MainPage(driver);
        mainPage.topOrderButtonClick();
        mainPage.scooterLogoClick();
        mainPage.isItMainPage();
    }

    @Test
    public void yandexLogoClickCheck() {
        MainPage mainPage = new MainPage(driver);
        mainPage.yandexLogoClick();
        mainPage.switchToSecondTab();
        mainPage.isItPage("https://ya.ru/");

    }

}
