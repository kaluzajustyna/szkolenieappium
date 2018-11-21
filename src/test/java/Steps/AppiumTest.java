package Steps;

import Framework.CapabilitiesDevices;
import Framework.ComplexPerson;
import PageObject.PlayStoreHomePage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {

    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;
    private PlayStoreHomePage playStoreHomePage;

    @BeforeMethod
    public void setUp(ITestContext context) throws MalformedURLException, FileNotFoundException {
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"), getCapabilities());
        wait = new WebDriverWait(driver, 30)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);

        context.setAttribute("driver", this.driver);
        context.setAttribute("wait", this.wait);

        playStoreHomePage = new PlayStoreHomePage(context);
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Procountor"},
                {"test"},
        };
    }

    @Test(dataProvider = "test1",groups = {"regression"})
    public void SearchInstore(String appName) throws MalformedURLException {
        playStoreHomePage.SearchInstore();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'title')][@text='STRONA GŁÓWNA']")));
        driver.findElement(By.xpath("//*[contains(@resource-id,'search_box_idle_text')]")).click();
        driver.findElementByXPath("//*[contains(@resource-id,'search_box_text_input')]").sendKeys("test");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private DesiredCapabilities getCapabilities() throws FileNotFoundException {
        Gson g = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BufferedReader br = new BufferedReader(new FileReader("./src/test/resources/capabilitiesDevices.json"));
        CapabilitiesDevices capabilitiesDevices = g.fromJson(br, CapabilitiesDevices.class);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", capabilitiesDevices.getDeviceName());
        capabilities.setCapability("VERSION", capabilitiesDevices.getVERSION());
        capabilities.setCapability("deviceName", capabilitiesDevices.getDeviceName());
        capabilities.setCapability("udid", capabilitiesDevices.getUdid());
        capabilities.setCapability("platformName", capabilitiesDevices.getPlatformName());
        capabilities.setCapability("appPackage", capabilitiesDevices.getAppPackage());
        capabilities.setCapability("appActivity", capabilitiesDevices.getAppActivity());
        capabilities.setCapability("autoGrantPermissions", capabilitiesDevices.getAutoGrantPermissions());
        capabilities.setCapability("newCommandTimeout", capabilitiesDevices.getNewCommandTimeout());
        capabilities.setCapability("androidInstallTimeout", capabilitiesDevices.getAndroidInstallTimeout());
        return capabilities;
    }
}

