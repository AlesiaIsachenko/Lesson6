package by.Isachenko;

import by.Isachenko.pages.CreateAccountPage;
import by.Isachenko.pages.MainPage;
import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

public class NewUserRegistrationTest extends TestBase{
    @Test
    public void testNewUserRegistration() {
        driver.navigate().to("https://litecart.stqa.ru/en/");
        MainPage mainPage = new MainPage();
        mainPage.clickNewCustomers(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage();
        createAccountPage.setFirstName(driver, "Ivan");
        createAccountPage.setLastName(driver, "Sidorov");
        createAccountPage.setAddress1(driver, "Tara");
        createAccountPage.setPostcode(driver, "30060");
        createAccountPage.setCity(driver, "Atlanta");
        createAccountPage.setCountry(driver, "United States");
        createAccountPage.setZone(driver, "Georgia");
        Long time = System.currentTimeMillis();
        String email = Long.toString(time);
        email = "Hello" + email + "@yandex.ru";
        createAccountPage.setEmail(driver, email);
        createAccountPage.setPhone(driver, "+7111111111111");
        createAccountPage.setDesiredPassword(driver, "147852369!Q");
        createAccountPage.setConfirmPassword(driver, "147852369!Q");
        createAccountPage.clickCreateAccount(driver);
        assertTrue(isElementPresent(driver, By.cssSelector(".content [href*=order_history]")));
        mainPage.clickLogOut(driver);
        assertTrue(isElementPresent(driver, By.cssSelector("[name] [href*=create_account]")));
        mainPage.setEmail(driver, email);
        mainPage.setPassword(driver, "147852369!Q");
        mainPage.clicklogin(driver);
        assertTrue(isElementPresent(driver, By.cssSelector(".content [href*=order_history]")));
        mainPage.clickLogOut(driver);
        assertTrue(isElementPresent(driver, By.cssSelector("[name] [href*=create_account]")));
        System.out.println("Test is over.");
    }

    @Test
    //тест на локальном сайте, логика работы страниц отличается (при выборе USA не становится сразу доступно по Zone)
    public void testLocalNewUserRegistration() {
        driver.navigate().to("http://localhost/litecart/en/");
        MainPage mainPage = new MainPage();
        mainPage.clickNewCustomers(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage();
        createAccountPage.setFirstName(driver, "Ivan");
        createAccountPage.setLastName(driver, "Sidorov");
        createAccountPage.setAddress1(driver, "Tara");
        createAccountPage.setPostcode(driver, "30060");
        createAccountPage.setCity(driver, "Atlanta");
        createAccountPage.setCountry(driver, "United States");
        //поле не стало активно
        //createAccountPage.setZone(driver, "Georgia");
        Long time = System.currentTimeMillis();
        String email = Long.toString(time);
        email = "Hello" + email + "@yandex.ru";
        createAccountPage.setEmail(driver, email);
        createAccountPage.setPhone(driver, "+7111111111111");
        createAccountPage.setDesiredPassword(driver, "147852369!Q");
        createAccountPage.setConfirmPassword(driver, "147852369!Q");
        createAccountPage.clickCreateAccount(driver);
        createAccountPage.setZone(driver, "Georgia");
        createAccountPage.clickCreateAccount(driver);
        createAccountPage.setDesiredPassword(driver, "147852369!Q");
        createAccountPage.setConfirmPassword(driver, "147852369!Q");
        createAccountPage.clickCreateAccount(driver);
        assertTrue(isElementPresent(driver, By.cssSelector(".content [href*=order_history]")));
        mainPage.clickLogOut(driver);
        assertTrue(isElementPresent(driver, By.cssSelector("[name] [href*=create_account]")));
        mainPage.setEmail(driver, email);
        mainPage.setPassword(driver, "147852369!Q");
        mainPage.clicklogin(driver);
        assertTrue(isElementPresent(driver, By.cssSelector(".content [href*=order_history]")));
        mainPage.clickLogOut(driver);
        assertTrue(isElementPresent(driver, By.cssSelector("[name] [href*=create_account]")));
        System.out.println("Test is over.");
    }
}
