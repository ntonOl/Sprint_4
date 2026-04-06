package pageObject;

import org.openqa.selenium.By;

public class CookieConsent {
    //Кнопка "принять куки"
    private static By CookieButton = By.className("App_CookieButton__3cvqF");

    public static By getCookieButton() {
        return CookieButton;
    }
}
