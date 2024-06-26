package PageObjeckts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[onclick=\"document.forms['logoutForm'].submit()\"]")
    private WebElement successfullyLogin;
    public String getLogoutUserText() {
        return successfullyLogin.getText();}

}
