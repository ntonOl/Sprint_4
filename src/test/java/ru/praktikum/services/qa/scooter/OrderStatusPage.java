package ru.praktikum.services.qa.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPage {

    private WebDriver driver;

    private By orderStatus = By.xpath(".//div[@class='Track_Content__St6Kn']//img");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public String notFoundStatusTextGet() {
        String altText = driver.findElement(orderStatus).getAttribute("alt");
        return altText;
    }
}
