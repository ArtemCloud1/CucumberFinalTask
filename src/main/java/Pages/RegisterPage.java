package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    @FindBy(xpath = "//input[@alt='Email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='FirstName']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//span[@id='BirthYear-error']")
    private WebElement errorMessage;
    public void selectEmailField(){emailField.click();}
    public void selectFirstNameField(){firstNameField.click();}
    public void selectLastNameField(){lastNameField.click();}
    public void selectPasswordField(){passwordField.click();}
    public void inputPassword(final String pas){passwordField.sendKeys(pas);}
    public void inputEmail(final String mail){emailField.sendKeys(mail);}
    public void inputFirsName(final String firstName){firstNameField.sendKeys(firstName);}
    public void inputLastName(final String lastName){lastNameField.sendKeys(lastName);}
    public void submit(){submitButton.click();}
    public String getErrorMessage(){return errorMessage.getText();}

    public RegisterPage(WebDriver driver) {super(driver);}
}
