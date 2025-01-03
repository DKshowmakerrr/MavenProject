package dat.testcase;

import dat.base.Validate;
import dat.base.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboardpage {
    private WebDriver driver;
    private Validate validate;
    public Dashboardpage(WebDriver driver) {
        this.driver = driver;
        this.validate = new Validate(this.driver);
    }

}
