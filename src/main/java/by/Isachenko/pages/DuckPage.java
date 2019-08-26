package by.Isachenko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DuckPage {
    public void clickAddToCart (WebDriver driver){
        driver.findElement(By.cssSelector("[name=add_cart_product]")).click();
        System.out.println("Info: " + "Click -- add cart product.");
    }

    public WebElement getNumCart(WebDriver driver){
        return driver.findElement(By.cssSelector("#cart .quantity"));
    }

    public void goToMainPage(WebDriver driver){
        driver.findElement(By.cssSelector("#logotype-wrapper a")).click();
        System.out.println("Info: " + "Go to main page.");
    }
    public void setSize(WebDriver driver, String size){
        Select dropdown = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
        dropdown.selectByVisibleText(size);
        System.out.println("Info: " + "Set size -- " + size + ".");
    }

}
