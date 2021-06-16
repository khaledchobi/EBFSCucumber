package stepDefinitions;


import com.util.ExcelReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Login_Page_Test_Steps {

    private static WebDriver driver = null;

    @Given("user is on Home page")
    public void user_is_on_home_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/EBFSCucumber/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
    }

    @When("User Navigate to Login Page")
    public void user_navigate_to_login_page() {
        driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']")).click();

    }

    @And("user enters Email {string} and Password {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @When("user enters Credentials to Login")
    public void user_enters_credentials_to_login(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();

        for(int i=0; i<data.size(); i++){
            for(int j=0; j<=i; j++){
                driver.findElement(By.id("email")).sendKeys(data.get(j).get(0));
                driver.findElement(By.id("passwd")).sendKeys(data.get(j).get(1));
                driver.findElement(By.id("SubmitLogin")).click();
            }
        }

    }

    @When("user enters Credentials to Login by List")
    public void user_enters_credentials_to_login_by_list(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        driver.findElement(By.id("email")).sendKeys(data.get(2).get("email"));
        driver.findElement(By.id("passwd")).sendKeys(data.get(2).get("password"));
        driver.findElement(By.id("SubmitLogin")).click();

    }

    @When("user enters Credentials to Login by Map")
    public void user_enters_credentials_to_login_by_map(DataTable dataTable) {

        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        for(int i=0; i<data.size(); i++){
            for(int j=0; j<=i; j++){
                driver.findElement(By.id("email")).sendKeys(data.get(j).get("email"));
                driver.findElement(By.id("passwd")).sendKeys(data.get(j).get("password"));
                driver.findElement(By.id("SubmitLogin")).click();

                driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
                driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).click();
            }

        }
        driver.close();

    }

    @When("user fills the form from given sheetName {string} and rowNumber {int}")
    public void user_fills_the_form_from_given_sheet_name_and_row_number(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {

        //driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("/Users/khaledhasan/Desktop/Java_Github/Frame_Work/EBFSCucumber/src/main/java/com/testdata/automation.xlsx", sheetName);

        int n = 12;


        for(int i=0; i<=n; i++){
            //int i=0; i<=12; i++
            //int i=0; i<=testData.get(n).size(); i++

                String email = testData.get(i).get("email");
                String password = testData.get(i).get("password");

                driver.findElement(By.id("email")).sendKeys(email);
                driver.findElement(By.id("passwd")).sendKeys(password);
                driver.findElement(By.id("SubmitLogin")).click();

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).click();


            }



    }


    @Then("my account page title should be {string}")
    public void my_account_page_title_should_be(String arg1) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(arg1, actualTitle);

        //driver.close();

    }

    @When("User Log out from the application")
    public void user_log_out_from_the_application(){
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).click();

    }

    @Then("User redirect to Home page")
    public void user_redirect_to_home_page() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Login - eBFS - the power of choice";

        Assert.assertEquals(expectedTitle, actualTitle);

        driver.close();

    }





}
