package stepDefinitions;

import com.util.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Registration_Page_Test_Steps {

    private static WebDriver driver = null;

    @Given("User is on the Login Page")
    public void user_is_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/EBFSCucumber/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
        driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']")).click();
    }

    @When("User enters email address for Registration")
    public void user_enters_email_address_for_registration() {
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("khaledCompilia012@gmail.com");
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
    }

    @When("User is on Registration Page")
    public void user_is_on_registration_page() {

    }

    @When("user fills the registration form from given sheetName {string} and rowNumber {int}")
    public void user_fills_the_registration_form_from_given_sheet_name_and_row_number(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {

        //driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("/Users/khaledhasan/Desktop/Java_Github/Frame_Work/EBFSCucumber/src/main/java/com/testdata/automation.xlsx", sheetName);

        int n = 12;


        for(int i=0; i<1; i++){
            //int i=0; i<=12; i++
            //int i=0; i<=testData.get(n).size(); i++

            String firstName = testData.get(i).get("firstName");
            String lastName = testData.get(i).get("lastName");
            String password = testData.get(i).get("password");

            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
            driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(firstName);
            driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(lastName);
            driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);


            Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
            days.selectByIndex(16);
            Select months = new Select(driver.findElement(By.xpath("//select[@id='months']")));
            months.selectByValue("3");
            Select years = new Select(driver.findElement(By.xpath("//select[@id='years']")));
            years.selectByValue("1981");

            driver.findElement(By.xpath("//input[@id='newsletter']")).click();



            driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).click();


        }
    }

    @When("User enters email and fills the registration form from given sheetName {string} and rowNumber {int}")
    public void user_enters_email_and_fills_the_registration_form_from_given_sheet_name_and_row_number(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {

        //driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("/Users/khaledhasan/Desktop/Java_Github/Frame_Work/EBFSCucumber/src/main/java/com/testdata/automation.xlsx", sheetName);

        int n = 3;


        for(int i=0; i<n; i++){
            //int i=0; i<=12; i++
            //int i=0; i<=testData.get(n).size(); i++

            String emailAddress = testData.get(i).get("email");
            String fName = testData.get(i).get("firstName");
            String lName = testData.get(i).get("lastName");
            String pass = testData.get(i).get("password");

            String bDays = testData.get(i).get("birthDays");
            String bMonth = testData.get(i).get("birthMonth");
            String bYear = testData.get(i).get("birthYear");


            driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(emailAddress);
            driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

            driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
            driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(fName);
            driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(lName);
            driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(pass);


            Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
            days.selectByValue(bDays);
            Select months = new Select(driver.findElement(By.xpath("//select[@id='months']")));
            months.selectByValue(bMonth);
            Select years = new Select(driver.findElement(By.xpath("//select[@id='years']")));
            years.selectByValue(bYear);

            driver.findElement(By.xpath("//input[@id='newsletter']")).click();


            driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).click();



        }


        driver.close();



    }

    @Then("Successful registration page title should be {string}")
    public void successful_registration_page_title_should_be(String arg1) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(arg1, actualTitle);

        driver.close();

    }

}
