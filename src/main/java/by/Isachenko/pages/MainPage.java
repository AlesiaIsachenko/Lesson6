package by.Isachenko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    public void clickNewCustomers(WebDriver driver){
        driver.findElement(By.cssSelector("[name] [href*=create_account]")).click();
        System.out.println("Info: "+ "Click create new account.");
    }

    public void setEmail(WebDriver driver, String email){
        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
        System.out.println("Info: " + "Set email -- " + email + ".");
    }

    public void setPassword(WebDriver driver, String password){
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        System.out.println("Info: " + "Set password -- " + password + ".");
    }
    public void clicklogin(WebDriver driver) {
        driver.findElement(By.cssSelector("[name=login]")).click();
        System.out.println("Info: " + "Click login.");
    }

    public void clickLogOut(WebDriver driver){
        driver.findElement(By.cssSelector(".content [href*=logout]")).click();
        System.out.println("Info: " + "Click Logout.");
    }

    public List<WebElement> getLatestProductsList(WebDriver driver){
        return driver.findElements(By.cssSelector("#box-latest-products .product"));
    }

    public void clickCheckout(WebDriver driver){
        driver.findElement(By.cssSelector("#cart .link")).click();
        System.out.println("Info: " + "Click Checkout.");
    }
}
