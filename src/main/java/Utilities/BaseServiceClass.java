package Utilities;

import PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import java.time.Duration;
import java.util.Properties;

public class BaseServiceClass {

    public WebDriver driver;
    public LoginPage loginPage;
    static Properties envProperties = PropertiesClass.getPropertyValue("environment.properties");

    public WebDriver setDriver(String browser)
    {
        switch (browser.toUpperCase())
        {

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions());
                break;

            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions());
                break;

            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(edgeOptions());
                break;

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public LoginPage launchApplication(String browser, String url)
    {
        driver = setDriver(browser);
        loginPage = new LoginPage(driver);
        loginPage.navigateToSauceDemo(url);
        return loginPage;
    }


    private ChromeOptions chromeOptions()
    {
        // Setup Chrome environment:
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        chromeOptions.addArguments("--enable-automation");
        return chromeOptions;
    }

    private FirefoxOptions firefoxOptions()
    {
        // Setup Firefox Environment
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        firefoxOptions.addArguments("--window-size=1536,722");
        firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return firefoxOptions;
    }

    private EdgeOptions edgeOptions()
    {
        // Setup Edge Environment
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return edgeOptions;
    }

    public void tearDown() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
