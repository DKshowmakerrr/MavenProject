package dat.page;

import dat.base.ValidateHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignInTest {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By loginbtn = By.id("btnLogin");
    @Test
    public void abc() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
        validateHelper.setText(loginbtn,"abc");


        Thread.sleep(2000);
        driver.quit();
    }
}
