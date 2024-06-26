package PageObjeckts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#username")
    private WebElement inputUsername;
    @FindBy(css = "#password")
    private WebElement inputPassword;
    @FindBy(css = "#passwordConfirm")
    private WebElement inputConfirmPassword;
    @FindBy(css = "button[type=submit]")
    private WebElement buttonCreate;
    @FindBy(xpath = "//span[contains(text(),'Privaloma įvesti nuo 3 iki 32 simbolių')]")
    private WebElement errorMessage;

    public void typeUserName(String username){
        inputUsername.sendKeys(username);
    }
    public void typePassword (String password){
        inputPassword.sendKeys(password);
    }
    public void typeConfirmPassword(String password2){
        inputConfirmPassword.sendKeys(password2);
    }
    public void clickButtonCreate() {buttonCreate.click();}

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
