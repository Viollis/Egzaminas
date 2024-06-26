package EgzaminasTesting;

import PageObjeckts.CalculatorPage;
import PageObjeckts.HomePage;
import PageObjeckts.LoginPage;
import PageObjeckts.OperationResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        operationResultPage.getResultText();
        //Assertion Search
        String expectedErrorMessage = "14";
        String actualErrorMessage = operationResultPage.getFinalResultText();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message text does not match");
    }
    }





