package EgzaminasTesting;

import PageObjeckts.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends BaseTest {
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
    void validOperation() {
        calculatorPage.performCalculation("5", "9", "Sudėtis");
        String expectedMessage = "5 + 9 = 14";
        String actualMessage = operationResultPage.getResultText();
        Assertions.assertEquals(expectedMessage, actualMessage, "Calculator Dont work ");
    }

    @Test
    void invalidOperationWithNegative() {
        calculatorPage.performCalculation("-5", "5", "Sudėtis");
        Assertions.assertTrue(calculatorPage.isErrorMessageDisplayed(), "Error message is not displayed");
        String expectedErrorMessage = "Validacijos klaida: skaičius negali būti neigiamas";
        String actualErrorMessage = calculatorPage.getErrorMessageText();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message text does not match");

    }
}
