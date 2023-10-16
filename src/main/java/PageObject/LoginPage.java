package PageObject;

import Utilities.BaseServiceClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BaseServiceClass {

    By userNameTextBox = By.id("user-name");
    By passwordTextBox = By.id("password");
    By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSauceDemo(String url) {
        driver.get(url);
    }

    public void verifyUserIsOnLoginPage(String url) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url);
    }

    public void enterUserName(String username) {
        driver.findElement(userNameTextBox).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public HomePage clickLoginButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return new HomePage(driver);

    }

    public void verifyUserIsOnHomePage(String url) {
        String homePageSwagLabs = driver.getCurrentUrl();
        Assert.assertEquals(homePageSwagLabs, url);
    }

}
