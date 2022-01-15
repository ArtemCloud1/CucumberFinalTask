package Manager;

import Pages.*;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    public  SearchResultPage getSearchResultPage(){
        return new SearchResultPage(driver);
    }
    WebDriver driver;
public PageFactoryManager (WebDriver driver){this.driver= driver;}
    public StartPage getStartPage() {return new StartPage(driver);}
    public LoginPage getLoginPage(){return new LoginPage(driver);}
    public SaveItemPage getSaveItemPage(){return new SaveItemPage(driver);}
    public RegisterPage getRegisterPage(){return new RegisterPage(driver);}
    public ItemPage getItemPage(){return new ItemPage(driver);}
    public CartPage getCartPage(){return new CartPage(driver);}
   
    }

