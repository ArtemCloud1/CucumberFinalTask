package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy (xpath = "//input[@class='qa-email-textbox']")
    private WebElement emailInputField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement logInButton;
    @FindBy(xpath = "//a[@class='qa-join-asos']")
    private WebElement joinInbotton;
    @FindBy (xpath = "//span[@id='Password-error']")
    private WebElement errorPassword;
    public String getError(){return errorPassword.getText();}
    public void clickJoinIn(){joinInbotton.click();}
    public void chooseEmailField(){emailInputField.click();}
    public void enterEmail(final String mail){emailInputField.sendKeys(mail);}
    public void clickLogInButton(){logInButton.click();}
    public LoginPage(WebDriver driver) {super(driver);}
}
