package by.Isachenko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {
    public List<WebElement> getProductList (WebDriver driver){
        return driver.findElements(By.cssSelector(".shortcut a"));
    }

    public void clickRemove(WebDriver driver){
        driver.findElement(By.cssSelector("[name=remove_cart_item]")).click();
        System.out.println("Info: " + "Click Remove.");
    }

    public List<WebElement> getProductTableList (WebDriver driver){
        return driver.findElements(By.cssSelector("td.item"));
    }
}
