package Stepdifinitions;

import Manager.PageFactoryManager;
import Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class StepsDefinition {
    WebDriver driver;
    BasePage basePage;
    StartPage startPage;
    LoginPage loginPage;
    SearchResultPage searchResultPage;
    SaveItemPage saveItemPage;
    RegisterPage registerPage;
    ItemPage itemPage;
    PageFactoryManager pageFactoryManager;

    private static final long DEFAULT_TIMEOUT = 60;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User open {string} page")
    public void userOpenStartPagePage(final String url) {
        startPage = pageFactoryManager.getStartPage();
        startPage.openStartPage(url);
    }
    @And("User chooses gender")
    public void userChoosesGender() {startPage.clickselectGenderButton();}

    @Then("the user got a page with the selected gender")
    public void checkCurrentUrl( ) {
        assertTrue(driver.getCurrentUrl().contains("women"));
    }




    @And("User click to search field")
    public void userClickToSearchField() {startPage.chooseSearchField();

    }

    @And("User input search {string}")
    public void userInputSearchKeyword(final String keyword) {startPage.enterTextToSearch(keyword);}
    @And("User click search button")
    public void userClickSearchButton() {startPage.enterSearchQuery();}
    @Then("User checks contains url search {string}")
    public void userChecksContainsUrlSearchWord(final String keyword)
    {assertTrue(driver.getCurrentUrl().contains(keyword));}



    @Then("User check search result item contains {string}")

    public void chekSearchresult(final String keyword) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        for (WebElement webElement : searchResultPage.getSearchResultItem()) {
        assertTrue(webElement.getText().contains(keyword));}
    }
    @And("User click my account button")
    public void ClickMyAccountButton() {startPage.clickInMyAccount();}

    @And("User click sign in link")
    public void SignInLink() {startPage.clickInSignInLink();}

    @And("User enters {string}")
    public void entersEmail(final String email) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.chooseEmailField();
        loginPage.enterEmail(email);
    }



    @When("User click login button")
    public void userClickLoginButton() {
        loginPage.clickLogInButton();
    }
    @After
    public void tearDown() {
        driver.close();
    }

    @And("User click to 'Heart' icon")
    public void clickToHeartIcon() {startPage.clickSavadItemButton();}

    @And("User add item in 'saved item'")
    public void AddItem() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.chooseSaveItem();}

    @Then("User check saved {string}")
    public void userCheckSavedExpectedCountItem(final String expectedCount) {
        saveItemPage = pageFactoryManager.getSaveItemPage();

        assertEquals(saveItemPage.getCountItemSaved(), expectedCount);
    }

    @And("User click 'sign up' link")
    public void ClickSignUpLink() {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.clickJoinIn();}

    @And("User enter {string}")
    public void EnterName(final String name) {
        registerPage = pageFactoryManager.getRegisterPage();
       registerPage.selectFirstNameField();
       registerPage.inputFirsName(name);
    }

    @And("User {string} enter in field")
    public void LastNameEnter(final String lastName) {
        registerPage.selectLastNameField();
        registerPage.inputLastName(lastName);
    }

    @And("User enter {string} in field")
    public void EnterEmail(final String email) {
        registerPage.selectEmailField();
        registerPage.inputEmail(email);
    }

    @When("enter {string}")
    public void enterPassword(final String password) {
        registerPage.selectPasswordField();
        registerPage.inputPassword(password);
    }

    @And("click 'sign up' button")
    public void clickSignUpButton() {
        registerPage.submit();
    }

    @Then("check date of birth eeror {string}")
    public void checkDateOfBirthEerorMessage(final String message) {
       assertEquals( registerPage.getErrorMessage(), message);
    }

    @Then("User check {string}")
    public void userCheckErrorMessage(final String errorMessage) {
        assertEquals(loginPage.getError(), errorMessage);
    }

    @And("Open first item")
    public void openFirstItem() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.selectItem();
    }

    @And("User click 'add to beg'")
    public void ClickAddToBeg() {
        itemPage = pageFactoryManager.getItemPage();
        itemPage.addItemToBeg();
    }

    @And("User select size")
    public void userSelectSize() {
        itemPage = pageFactoryManager.getItemPage();
        itemPage.selectSize();

    }

}


