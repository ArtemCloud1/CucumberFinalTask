package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ItemPage extends BasePage{
    public ItemPage(WebDriver driver) {super(driver);}
    @FindBy(xpath = "//span[@data-bind='text: buttonText']")
    private WebElement buttonBag;
    @FindBy(xpath = "//select[@id='main-size-select-0']/option")
    private List<WebElement> sizeSelector;

    public void selectSize(){sizeSelector.get(4).click();}
    public void addItemToBeg(){buttonBag.click();}
}
