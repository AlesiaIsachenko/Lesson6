package by.Isachenko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
    public void setFirstName(WebDriver driver, String firstName){
        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys(firstName);
        System.out.println("Info: " + "Set first name -- " + firstName + ".");
    }

    public void setLastName(WebDriver driver, String lastName){
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys(lastName);
        System.out.println("Info: " + "Set last name -- " + lastName + ".");
    }

    public void setAddress1(WebDriver driver, String address){
        driver.findElement(By.cssSelector("[name=address1]")).sendKeys(address);
        System.out.println("Info: " + "Set address1 -- " + address + ".");
    }

    public void setPostcode(WebDriver driver, String postcode){
        driver.findElement(By.cssSelector("[name=postcode]")).sendKeys(postcode);
        System.out.println("Info: " + "Set postcode -- " + postcode + ".");
    }

    public void setCity(WebDriver driver, String city){
        driver.findElement(By.cssSelector("[name=city]")).sendKeys(city);
        System.out.println("Info: " + "Set city -- " + city + ".");
    }
    public void setCountry(WebDriver driver, String name){
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        //для Edge не сработал основной сценарий, поэтому написала реализацию в двух вариантах
        if (browserName.equals("internet explorer")||browserName.equals("microsoftedge")){
            driver.findElement(By.cssSelector(".select2-selection.select2-selection--single")).click();
            driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(name, Keys.ENTER);
        }else{
            driver.findElement(By.cssSelector(".select2-selection__arrow")).click();
            Select dropdown = new Select(driver.findElement(By.cssSelector("[name=country_code]")));
            dropdown.selectByVisibleText(name);
            driver.findElement(By.cssSelector(".select2-selection__arrow")).click();
        }
        System.out.println("Info: " + "Set country -- " + name + ".");
    }

    public void setZone(WebDriver driver, String name){
        Select dropdown = new Select(driver.findElement(By.cssSelector("[name=zone_code][data-size]")));
        dropdown.selectByVisibleText(name);
        System.out.println("Info: " + "Set zone -- " + name + ".");
    }

    public void setEmail(WebDriver driver, String email){
        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
        System.out.println("Info: " + "Set email -- " + email + ".");
    }

    public void setPhone(WebDriver driver, String phone){
        driver.findElement(By.cssSelector("[name=phone]")).sendKeys(phone);
        System.out.println("Info: " + "Set phone -- " + phone + ".");
    }

    public void setDesiredPassword(WebDriver driver, String password){
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        System.out.println("Info: " + "Set password -- " + password + ".");
    }

    public void setConfirmPassword(WebDriver driver, String password){
        driver.findElement(By.cssSelector("[name='confirmed_password']")).sendKeys(password);
        System.out.println("Info: " + "Set confirmed password -- " + password + ".");
    }

    public void clickCreateAccount(WebDriver driver){
        driver.findElement(By.cssSelector("[name='create_account']")).click();
        System.out.println("Info: " + "Click create_account.");
    }
}
