package EgzaminasTesting;

import PageObjeckts.CalculatorPage;
import PageObjeckts.HomePage;
import PageObjeckts.LoginPage;
import PageObjeckts.OperationResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultTest extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    CalculatorPage calculatorPage;
    OperationResultPage operationResultPage;
    public static final String VALID_USERNAME = "Violeta";
    public static final String VALID_PASSWORD = "Violeta";
    @BeforeEach
    void setUp() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        calculatorPage = new CalculatorPage(driver);
        operationResultPage = new OperationResultPage(driver);
        loginPage.typeUsernameLogin(VALID_USERNAME);
        loginPage.typePasswordLogin(VALID_PASSWORD);
        loginPage.clickButtonLogin();
    }
    @Test
      void successfullySearchResults(){
        calculatorPage.clickAllResults();
        //Assertion Search
        List<WebElement> elements = driver.findElements(By.cssSelector("body.container *"));

        boolean found = false;
        // Iterate through each element and check if it contains the text "14 "
        for (WebElement element : elements) {
            if (element.getText().contains("14 ")) {
                found = true;
                break;
            }
        }
        assert(found) : "Text '14 ' not found in any element within body.container";

    }
    @Test
    void InvalidSearchResults(){
        List<WebElement> elements = driver.findElements(By.cssSelector("body.container *"));

        boolean found = false;
        // Iterate through each element and check if it contains the text "14 "
        for (WebElement element : elements) {
            if (element.getText().contains("14 ")) {
                found = true;
                break;
            }
        }

        // Assert that the text "14 " is not found in any element
        assert(!found) : "Text '14 ' was found in an element within body.container";

        // Close the WebDriver instance
        driver.quit();
    }
}








