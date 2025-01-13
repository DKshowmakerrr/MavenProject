package dat.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

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
    public void checkSearchTableByColumn(int column, String value){
        List<WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size();
        for (int i=1;i<=rowTotal;i++){
            WebElement cell = driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td["+column+"]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", cell);
            Assert.assertTrue(cell.getText().toUpperCase().contains(value.toUpperCase()));
            //video 35: 23:09
        }
    }
}
