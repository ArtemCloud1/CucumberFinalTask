package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaveItemPage extends BasePage {
    @FindBy (xpath = "//div[@class='itemCount_3vWat']")
    private WebElement countItemSaved;
    public SaveItemPage(WebDriver driver) {super(driver);}
    public String getCountItemSaved(){return countItemSaved.getText();}




}
