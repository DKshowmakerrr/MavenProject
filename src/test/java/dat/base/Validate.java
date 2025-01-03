package dat.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Validate {
    private WebDriver driver;
    private WebDriverWait wait;
    public Validate(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void setText(By element, String value){
        driver.findElement(element).sendKeys(value);
    }
    public void click(By element){
        driver.findElement(element).click();
    }
    public boolean verifyUrl(String url){
        return driver.getCurrentUrl().contains(url);
    }
    public boolean verifyElementText(By element, String text){
        return driver.findElement(element).getText().contains(text);
    }
}
