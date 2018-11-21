package Steps;

import Framework.TestHooks;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

@Feature("szkolenie Appium")
public class FakeTests extends TestHooks {
    @Test(groups = {"smoke", "regression"})
    @Story("this is fake test")
    @Description("this test will never fail")
    public void fakeSmokeTest() {

    }

    @Test(groups = {"regression"})
    public void fakeRegressionTest() {

    }
}
