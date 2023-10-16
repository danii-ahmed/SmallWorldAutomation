package stepDefinitions;

import PageObject.HomePage;
import PageObject.LoginPage;
import Utilities.BaseServiceClass;
import Utilities.PropertiesClass;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

public class addToCartStepDef extends BaseServiceClass {

    static Properties envProperties = PropertiesClass.getPropertyValue("environment");
    static Properties testDataProperties = PropertiesClass.getPropertyValue("testData");

    final String removeButtonTextToBeMatched = "Remove";
    LoginPage loginPage;
    HomePage homePage;

    @Given("User logged in Demo website")
    public void userLoggedInDemoWebsite() throws IOException, InterruptedException {

        String url = envProperties.getProperty("baseUrlSauceDemo");
        String browser = envProperties.getProperty("browser");
        loginPage = launchApplication(browser, url);
        loginPage.enterUserName(testDataProperties.getProperty("webUserName"));
        loginPage.enterPassword(testDataProperties.getProperty("webPassword"));
        homePage = loginPage.clickLoginButton();
    }

    @When("User clicks on add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        homePage.clickAddToCart();
    }

    @And("Selected product is added to the cart successfully")
    public void selectedProductIsAddedToTheCartSuccessfully() {
        String removeButtonText = homePage.verifyItemIsAdded();
        Assert.assertEquals(removeButtonText, removeButtonTextToBeMatched);
    }

    @Then("User clicks on Cart")
    public void user_clicks_on_cart() throws InterruptedException {
        homePage.clickCartButton();
    }

    @Then("Added Item should be shown in the cart")
    public void addedItemShouldBeShownInTheCart() {
        Assert.assertTrue(homePage.verifyCartPageItem());
    }

    @After
    public void afterScenario() {
        tearDown();
    }

}
