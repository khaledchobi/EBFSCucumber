package cucumberTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"Features/EBFS_Login.feature"},
        glue = {"stepDefinitions"}


)
public class LoginPageTestRunner {
}
