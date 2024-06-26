package PageObjeckts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage extends BasePage{
    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    @FindBy(id = "sk1")
    private WebElement firstNumberInput;

    @FindBy(id = "sk2")
    private WebElement secondNumberInput;

    @FindBy(name = "zenklas")
    private WebElement operationDropdown;

    @FindBy(css = "input[type='submit']")
    private WebElement calculateButton;


    @FindBy(id = "result")
    private WebElement resultOutput;
    @FindBy(css = "a[href='/skaiciai']")
    private WebElement allResults;
    @FindBy(xpath = "//span[contains(text(),'Validacijos klaida: skaičius negali būti neigiamas')]")
    private WebElement errorMessage;


    public void typeFirstNumber(String number) {
        firstNumberInput.clear();
        firstNumberInput.sendKeys(number);
    }

    public void typeSecondNumber(String number) {
        secondNumberInput.clear();
        secondNumberInput.sendKeys(number);
    }

    public void chooseOperation(String operation) {
        Select operationDropdownElement = new Select(operationDropdown);
        operationDropdownElement.selectByVisibleText(operation);
    }

    public void clickCalculateButton() {
        calculateButton.click();
    }

    public String getResult() {
        return resultOutput.getText();
    }

    public void performCalculation(String firstNumber, String secondNumber, String operation) {
        typeFirstNumber(firstNumber);
        typeSecondNumber(secondNumber);
        chooseOperation(operation);
        clickCalculateButton();
    }
    public void clickAllResults() {
        allResults.click();
    }
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

}