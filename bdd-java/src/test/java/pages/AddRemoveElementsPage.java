package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementsPage {
    private final WebDriver driver;

    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addElementButton;

    @FindBy(css = "#elements button")
    private List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void addElements(int count) {
        for (int i = 0; i < count; i++) {
            addElementButton.click();
        }
    }

    public void removeElements(int count) {
        for (int i = 0; i < count && !deleteButtons.isEmpty(); i++) {
            deleteButtons.get(0).click();
        }
    }

    public int getDeleteButtonsCount() {
        return deleteButtons.size();
    }
}
