package Steps;

import Framework.CapabilitiesDevices;
import Framework.ComplexPerson;
import Framework.TestHooks;
import PageObject.PlayStoreHomePage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
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

public class AppiumTest extends TestHooks {

    private PlayStoreHomePage playStoreHomePage;

    @Epic("Basic google store test")
    public class PlayStorePage extends TestHooks {

        private PlayStorePage playStorePage;

        @BeforeMethod(groups = {"regression"})
        public void SetUp(ITestContext context) throws MalformedURLException, FileNotFoundException {
            playStoreHomePage = new PlayStoreHomePage(context);
        }

        @DataProvider(name = "appName")
        public Object[][] createAppNameData() {
            return new Object[][]{
                    {"Messenger"},
                    {"Linkedin"},
            };
        }

        @Test(groups = {"regression", "Appium"}, dataProvider = "appName")
        @Story("Search application in the store")
        public void SearchInstore(String appName) {
            playStoreHomePage.SearchInstore();


        }
    }
}
