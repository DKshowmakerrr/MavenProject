package dat.testcase;

import dat.base.Validate;
import dat.base.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private Validate validate;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        validate = new Validate(this.driver);
    }
    private By emailInput = By.xpath("//input[@placeholder='email']");
    private By passwordInput = By.xpath("//input[@placeholder='password']");
    private By loginBtn = By.xpath("//input[@placeholder='login']");
    public void signIn(){
        validateHelper.setText(emailInput, "your_email");
        validateHelper.setText(passwordInput, "your_password");
        validateHelper.click(loginBtn);
        validate.click(loginBtn);
        validate.setText(emailInput, "your_email");
    }
}
