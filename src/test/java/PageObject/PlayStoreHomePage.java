package PageObject;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestContext;


public class PlayStoreHomePage {

    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;

    private final By searchBox = By.id("serach_box_idle_text");
    private final By serachBoxInput = By.id("search_box_text_input");
    private final By icon = By.id("icon");
    private final By procountorApp = By.xpath("//*[contains(@resources-id,'li_title')][@text ='Procountor Key']");

    public PlayStoreHomePage(ITestContext context){
        this.driver = (AndroidDriver<AndroidElement>)context.getAttribute("driver");
        this.wait = (FluentWait<WebDriver>)context.getAttribute("wait");
    }

    public void searchInStore(String apkToFind){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).click();
        driver.findElement(searchBox).sendKeys("Procountor");
    }

    public void SearchInstore() {
    }
}
