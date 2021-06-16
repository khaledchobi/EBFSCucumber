package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home_Page_Test_Steps {

    private static WebDriver driver = null;

    @Given("User is opened the browser")
    public void user_is_opened_the_browser() {
        System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/EBFSCucumber/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @When("User is on the Home page")
    public void user_is_on_the_home_page() {
        driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
    }

    @Then("User should be able to view the EBFS Home page Title")
    public void user_should_be_able_to_view_the_ebfs_home_page_title() {

        String expectedTitle = "eBFS - the power of choice";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Then("User should be able to view the EBFS Logo")
    public void user_should_be_able_to_view_the_ebfs_logo() {
        WebElement logo = driver.findElement(By.xpath("//div[@id='header_logo']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Then("User should be able to view the EBFS Title")
    public void user_should_be_able_to_view_the_ebfs_title() {
        String expectedTitle = "eBFS - the power of choice";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);
    }

}
