
import org.junit.Test;
import ru.praktikum.services.qa.scooter.MainPage;

import static org.junit.Assert.assertTrue;


public class LogoClickTests extends OpeningClosingMainPage {

    @Test
    public void scooterLogoClickCheck() {
        MainPage mainPage = new MainPage(driver);
        mainPage.topOrderButtonClick();
        mainPage.scooterLogoClick();
        assertTrue("Главная страница не открылась", mainPage.isItMainPage());
    }

    @Test
    public void yandexLogoClickCheck() {
        MainPage mainPage = new MainPage(driver);
        mainPage.yandexLogoClick();
        mainPage.switchToSecondTab();
        assertTrue("Главная страница Яндекса не открылась",
                mainPage.isItPage("https://ya.ru/"));

    }

}
