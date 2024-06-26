package EgzaminasTesting;

import PageObjeckts.HomePage;
import PageObjeckts.InvalidRegisterPage;
import PageObjeckts.LoginPage;
import PageObjeckts.RegisterPage;
import Utils.RandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class RegisterTest extends BaseTest {
    RegisterPage registerPage;
    LoginPage loginPage;
    HomePage homePage;
    InvalidRegisterPage invalidRegisterPage;
    String username = RandomGenerator.generateRandomUsername();
    public static final String VALID_PASSWORD = "Violeta";

    public static final String INVALID_PASSWORD = "V";


    @BeforeEach
    void setUp() {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        invalidRegisterPage = new InvalidRegisterPage(driver);
        loginPage.clickButtonCreateAccount();
    }

    @Test
    void completeRegistrationValidDetails() {
        registerPage.typeUserName(username);
        registerPage.typePassword(VALID_PASSWORD);
        registerPage.typeConfirmPassword(VALID_PASSWORD);
        registerPage.clickButtonCreate();
        String expectedMessage = "Logout, " + username;
        String actualMessage = homePage.getLogoutUserText();
        Assertions.assertEquals(expectedMessage, actualMessage, "Login dont work");
    }

    @Test
    void completeRegistrationInvalidUsername() {
        registerPage.typeUserName("1");
        registerPage.typePassword(VALID_PASSWORD);
        registerPage.typeConfirmPassword(VALID_PASSWORD);
        registerPage.clickButtonCreate();
        Assertions.assertTrue(registerPage.isErrorMessageDisplayed(), "Error message is not displayed");
        String expectedErrorMessage = "Privaloma įvesti nuo 3 iki 32 simbolių";
        String actualErrorMessage = registerPage.getErrorMessageText();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message text does not match");
    }
}