package EgzaminasTesting;

import PageObjeckts.HomePage;
import PageObjeckts.LoginPage;
import PageObjeckts.RegisterPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    public static final String VALID_USERNAME = "Violeta";
    public static final String VALID_PASSWORD = "Violeta";

    @BeforeEach
    void setUp() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @Test
    void successfullyLogin() {
        loginPage.typeUsernameLogin(VALID_USERNAME);
        loginPage.typePasswordLogin(VALID_PASSWORD);
        loginPage.clickButtonLogin();
        String expectedMessage = "Logout, " + VALID_USERNAME;
        String actualMessage = homePage.getLogoutUserText();
        Assertions.assertEquals(expectedMessage, actualMessage, "Login dont work");

    }
    @Test
    void LoginWithInvalidUsername() {
        loginPage.typeUsernameLogin("Vio");
        loginPage.typePasswordLogin("Violeta");
        loginPage.clickButtonLogin();
        Assertions.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed");
        String expectedErrorMessage = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String actualErrorMessage = loginPage.getErrorMessageText();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message text does not match");
    }

    }



