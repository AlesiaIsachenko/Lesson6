package by.Isachenko;

import by.Isachenko.pages.CheckoutPage;
import by.Isachenko.pages.DuckPage;
import by.Isachenko.pages.MainPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeLessThan;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class CartTest extends TestBase{
    @Test
    public void testCart() {
        driver.navigate().to("https://litecart.stqa.ru/en/");
        MainPage mainPage = new MainPage();
        List<WebElement> latestproductsList = mainPage.getLatestProductsList(driver);
        DuckPage duckPage = new DuckPage();
        //добавляю три товара в корзину
        for (int i =0; i<3; i++){
            System.out.println("Info: " + "Сlick on the product.");
            latestproductsList.get(i).click();
            WebElement element = duckPage.getNumCart(driver);
            if (areElementsPresent(driver, By.cssSelector("[name='options[Size]']"))){
                duckPage.setSize(driver, "Small");
            }
            String textContentAttribute = element.getAttribute("textContent");
            duckPage.clickAddToCart(driver);
            //ожидаю обновления счетчика в корзине
            wait.until((WebDriver driver)->{
                String attribute = driver.findElement(By.cssSelector("#cart .quantity")).getAttribute("textContent");
                return textContentAttribute.compareTo(attribute)!=0 ? true:false;
                }
            );
            duckPage.goToMainPage(driver);
            latestproductsList = mainPage.getLatestProductsList(driver);
        }
        //иду в корзину, последовательно удаляю товары
        mainPage.clickCheckout(driver);
        CheckoutPage checkoutPage = new CheckoutPage();
        //проверяю наличие таблицы на странице
        if (areElementsPresent(driver, By.cssSelector("#order_confirmation-wrapper"))){
            //если добавлено несколько товаров, то перед удаление лучше сначала выбрать товар
            // (иначе кнопка Remove может сбежать в неподходящий момент)
            if (areElementsPresent(driver, By.cssSelector(".shortcut a"))){
                List<WebElement> productList = checkoutPage.getProductList(driver);
                int sizeList = productList.size();
                for (int i = 0; i<sizeList-1; i++){
                    productList.get(0).click();
                    List<WebElement> productTableList = checkoutPage.getProductTableList(driver);
                    int size2 = productTableList.size();
                    checkoutPage.clickRemove(driver);
                    //ожидаю обновления таблицы
                    wait.until(numberOfElementsToBeLessThan(By.cssSelector("td.item"), size2));
                    productList = checkoutPage.getProductList(driver);
                    }
            }
            checkoutPage.clickRemove(driver);
            //проверяю наличие текста "There are no items in your cart."
            assertTrue(isElementPresent(driver, By.cssSelector("em")));
            timeSleep(2);
        }
        System.out.println("Test is over.");
    }
}
