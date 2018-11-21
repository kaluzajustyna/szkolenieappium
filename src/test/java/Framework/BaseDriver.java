package Framework;

import com.google.gson.Gson;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseDriver {
    private final String hubUrl = "http://127.0.0.1:4729/wd/hub";

    public void setDriverContex(ITestContext context) throws MalformedURLException, FileNotFoundException {
        context.setAttribute("driver", initialiseDriver());
        context.setAttribute("wait", initialiseWait((AndroidDriver<AndroidElement>) context.getAttribute("driver")));
    }

    private AndroidDriver<AndroidElement> initialiseDriver() throws MalformedURLException, FileNotFoundException {
        return new AndroidDriver<AndroidElement>(new URL(hubUrl), getCapabilities());
    }

    private FluentWait<WebDriver> initialiseWait(AndroidDriver<AndroidElement> driver) {
        return new WebDriverWait(driver, 30)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);
    }

    private DesiredCapabilities getCapabilities() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("./src/test/resources/capabilitiesDevices.json"));
        Gson g = new Gson();
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
