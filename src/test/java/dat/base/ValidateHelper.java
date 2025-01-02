package dat.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ValidateHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor js;
    public ValidateHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    public void setText(By element, String value){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }
    public void click(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
    public void selectOptionByText(By element, String text){
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }

}
