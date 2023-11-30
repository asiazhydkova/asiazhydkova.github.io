package org.example;

import org.example.pages.HomePage;
import org.example.pages.ToolBarPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest{
    private WebDriver driver;
    private HomePage homePage;

    /*@BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://bookcart.azurewebsites.net/");
    }*/

    @Test
    public void testSelectFirstTheme() {

        homePage.clickThemeButton();

        homePage.chooseDropDownMenuThemeButton(1);
        homePage.waitElement(1000,homePage.getWebElementPriceFilterWrapper());

        String actual = homePage.getColorElement(homePage.getWebElementPriceFilterWrapper());
        homePage.waitElement(1000,homePage.getWebElementPriceFilterWrapper());
        String expected = "rgba(255, 215, 64, 1)";
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {45})
    public void viewItemsHomePage(int expected){
        assertEquals(expected, getHomePage().getListItems().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,5})
    public void addToCart(int numBooks) throws InterruptedException {
        getHomePage().addToCartInOrder(numBooks);
                //.waitElement(2000, getHomePage().getItemAddMessage());
        Thread.sleep(1000);
        assertEquals(numBooks, getToolBarPage().getNumLogoShopButton());
    }

    @Test
    public void redirectToCart(){
        getToolBarPage().clickShopButton();

        assertTrue(getDriver().getCurrentUrl().contains("shopping-cart"));
    }


   /* @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
