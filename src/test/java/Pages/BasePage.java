package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class BasePage {
    private static Logger log = LoggerFactory.getLogger("BasePage.class");
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
      static String datePattern = "MM/dd/yyyy";
    static SimpleDateFormat format = new SimpleDateFormat(datePattern);

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        //actions = new Actions(driver);

    }

    public void waitForElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public void sendKeys(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

}
