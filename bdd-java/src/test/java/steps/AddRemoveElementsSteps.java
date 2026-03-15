package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AddRemoveElementsPage;
import static org.junit.Assert.assertEquals;

public class AddRemoveElementsSteps {
    private WebDriver driver;
    private AddRemoveElementsPage addRemoveElementsPage;

    @Before("@addremove")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
    }

    @Given("the user is on the add remove elements page")
    public void the_user_is_on_the_add_remove_elements_page() {
        addRemoveElementsPage.open();
    }

    @When("the user adds {int} elements")
    public void the_user_adds_elements(int count) {
        addRemoveElementsPage.addElements(count);
    }

    @When("the user removes {int} element")
    public void the_user_removes_element(int count) {
        addRemoveElementsPage.removeElements(count);
    }

    @Then("the user should see {int} delete buttons")
    public void the_user_should_see_delete_buttons(int expectedCount) {
        assertEquals(expectedCount, addRemoveElementsPage.getDeleteButtonsCount());
    }

    @After("@addremove")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
