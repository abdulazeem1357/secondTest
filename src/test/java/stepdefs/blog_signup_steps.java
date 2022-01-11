package stepdefs;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

public class blog_signup_steps {

    WebDriver driver;

    @Given("I launch the browser")
    public void iLaunchTheBrowser() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("I navigate to blog sign-up page")
    public void iNavigateToBlogSignUpPage() {
        driver.get("https://selenium-blog.herokuapp.com/signup");
    }

    @Then("I verify that title is present")
    public void iVerifyThatTitleIsPresent() {
        WebElement verifyTitle = driver.findElement(By.cssSelector("h1"));
        String titleText = verifyTitle.getText();
        assertEquals("Signup for Alpha Blog", titleText);
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }
}
