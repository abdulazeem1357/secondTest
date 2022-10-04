package stepdefs;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class add_items_to_cart_steps {

    WebDriver driver;
    Actions action;

    @Given("User navigates to the shopping page")
    public void userNavigatesToTheShoppingPage() {
        //System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @When("User add items to the cart")
    public void userAddItemsToTheCart() {
        List<WebElement> product_containers = driver.findElements(By.cssSelector("div.product-container"));
        //hover over the product item
        int index = 0;
        for (WebElement product_container : product_containers) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", product_container);
            action.moveToElement(product_container).perform();
            //add item to the cart
            new WebDriverWait(driver, Duration.ofSeconds(20)).
                    until(ExpectedConditions.elementToBeClickable(
                            By.cssSelector(String.format(".ajax_add_to_cart_button[data-id-product=\"%s\"]", index+1)))).click();
            //click on continue shopping
            new WebDriverWait(driver, Duration.ofSeconds(20)).
                    until(ExpectedConditions.elementToBeClickable(
                            By.cssSelector(".continue.btn"))).click();
            index++;
        }
    }

    @Then("Cart should be filled with the added items")
    public void cartShouldBeFilledWithTheAddedItems() {
        //hover the shopping the cart
        WebElement cart = driver.findElement(By.cssSelector(".shopping_cart"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cart);
        action.moveToElement(cart).perform();
        WebElement quantity = driver.findElement(By.cssSelector(".ajax_cart_quantity"));
        assertEquals("7", quantity.getText());
    }

    @And("User quits the browser")
    public void userQuitsTheBrowser() {
        driver.quit();
    }
}