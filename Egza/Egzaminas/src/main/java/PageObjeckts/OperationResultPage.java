package PageObjeckts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperationResultPage extends BasePage {


    @FindBy(css = "nav + h4")
    private WebElement resultElement;
    @FindBy(xpath = "//a[normalize-space()='Atliktos operacijos']")
    private WebElement clickToSearchField;
    @FindBy(xpath = "//tbody/tr[2]/td[5]/a[3]")
    private WebElement inputToShow;
    @FindBy(xpath = "//td[normalize-space()='1']")
    private WebElement CheckID;
    public OperationResultPage(WebDriver driver) {
        super(driver);
    }


    public String getResultText() {
        return resultElement.getText().trim();
    }
    // Method to check if specific text is present in a container
    public boolean isSpecificTrElementPresent() {
        String searchCalculation = "<tr>\n" +
                "    <td>5</td>\n" +
                "    <td>+</td>\n" +
                "    <td>9</td>\n" +
                "    <td>14</td>\n";

        String trXpath = "//tr[contains(., \"" + searchCalculation + "\")]";
        return !driver.findElements(By.xpath(trXpath)).isEmpty();
    }
    public boolean isSearchResultsPageDisplayed() {
        return driver.findElement(By.xpath("//h1[contains(text(), 'Search Results')][last()]")).isDisplayed();

    }
    @FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[td='14']")
    private WebElement resultNumber;
    public void setSearchField(){
        clickToSearchField.click();
    }
    public String getFinalResultText() {
        return resultNumber.getText();
    }



    }





