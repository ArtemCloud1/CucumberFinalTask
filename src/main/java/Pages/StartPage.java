package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.getKeyFromUnicode;

public class StartPage extends BasePage {
    @FindBy (xpath = "//a[@id='women-floor']")
    private WebElement selectGenderButton;
    @FindBy(xpath = "//input[@type='search']")
    private  WebElement searchField;
    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement accountIcon;
    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInLink;
    @FindBy (xpath = "//span[@type='heartUnfilled']")
    private WebElement savedItemsButton;

    public void clickSavadItemButton(){savedItemsButton.click();}
    public void clickselectGenderButton (){selectGenderButton.click();}
    public void openStartPage(String url){driver.get(url);}
    public void chooseSearchField(){searchField.click();}
    public void enterSearchQuery(){searchField.sendKeys(Keys.ENTER);}
    public void enterTextToSearch(final String keyword){searchField.sendKeys(keyword);}
    public void clickInMyAccount(){accountIcon.click();}
    public void clickInSignInLink(){signInLink.click();}

    public StartPage(WebDriver driver) {
        super(driver);
    }

}
