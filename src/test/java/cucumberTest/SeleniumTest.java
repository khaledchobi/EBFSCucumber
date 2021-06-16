package cucumberTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private static WebDriver driver = null;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/EBFSCucumber/src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();

        driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");

        String actualTitle = driver.getTitle();

        System.out.println(actualTitle);

        driver.close();

    }
}
