package PageObjeckts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@href='/registruoti']")
    private WebElement buttonCreateAccount;
    @FindBy(css = "input[name='username']")
    private WebElement inputLoginUsername;
    @FindBy(css = "input[name='password']")
    private WebElement inputLoginPassword;
    @FindBy(css = "button[type='submit']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//span[contains(text(),'Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi')]")
    private WebElement errorMessage;
    public void clickButtonCreateAccount(){buttonCreateAccount.click();}
    public void typeUsernameLogin (String username){inputLoginUsername.sendKeys(username);}
    public void typePasswordLogin (String password){inputLoginPassword.sendKeys(password);}
    public void clickButtonLogin() {buttonLogin.click();}
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }


}
