package stepDefinitions;

import PageObject.LoginPage;
import Utilities.BaseServiceClass;
import Utilities.PropertiesClass;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Properties;

public class loginStepDef extends BaseServiceClass{

    LoginPage loginPage;
    static Properties envProperties = PropertiesClass.getPropertyValue("environment");
    static Properties testDataProperties = PropertiesClass.getPropertyValue("testData");

    @When("User Navigates to Demo Website URL")
    public void userNavigatesToDemoWebsiteURL() throws IOException {

        String url = envProperties.getProperty("baseUrlSauceDemo");
        String browser = envProperties.getProperty("browser");
        loginPage = launchApplication(browser, url);
    }

    @And("User Validates Demo Website Title")
    public void userValidatesDemoWebsiteTitle() {
        loginPage.verifyUserIsOnLoginPage(envProperties.getProperty("baseUrlSauceDemo"));
    }

    @And("User enters the username")
    public void userEntersTheUsername() {
        loginPage.enterUserName(testDataProperties.getProperty("webUserName"));
    }

    @And("User enters the password")
    public void userEntersThePassword() {
        loginPage.enterPassword(testDataProperties.getProperty("webPassword"));
    }

    @Then("User clicks on the login button")
    public void userClicksOnTheLoginButton() throws InterruptedException {
        loginPage.clickLoginButton();

    }

    @And("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {

        loginPage.verifyUserIsOnHomePage(envProperties.getProperty("homePageUrlSauceDemo"));
    }

    @After
    public void afterScenario() {
        tearDown();
    }

}
