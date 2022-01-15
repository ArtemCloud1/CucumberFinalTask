package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver) {super(driver);}
    @FindBy(xpath = "//article[contains(@id, 'product')]")
    private List<WebElement> searchResultItem;
    @FindBy (xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> saveItemIcon;
    public void selectItem(){searchResultItem.get(0).click();}
   public void chooseSaveItem(){saveItemIcon.get(0).click();}
    public List<WebElement> getSearchResultItem(){return searchResultItem;}

}
