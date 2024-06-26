package PageObjeckts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvalidRegisterPage extends BasePage {
    public InvalidRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span#username.errors")
    private WebElement invalidUsername;

    @FindBy(css = "span#password.errors")
    private WebElement invalidPassword;

    public String getInvalidUsernameMessage() {
        return invalidUsername.getText();
    }
    public String getAlreadyExistMessage() {
        return invalidUsername.getText();
    }
    public String getInvalidPasswordMessage() {
        return invalidPassword.getText();
    }
    public String getIPasswordMismatchedMessage() {
        return invalidPassword.getText();
    }



}
