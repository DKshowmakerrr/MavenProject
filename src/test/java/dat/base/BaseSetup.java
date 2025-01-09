package dat.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseSetup {
    static String driverPath = "resources\\drivers\\";
    private WebDriver driver;
    public WebDriver getDriver() {return driver};

    //hàm này để tùy chọn browser. cho chạy trước khi gọi class này
    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("browser : " + browserType + " is invalid, Launching Chrome as browser of choice..");
                driver = initChromeDriver(appURL);
        }
    }

    //khởi tạo cấu hình của các browser để đưa vào switch case
    private WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
       // System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(appURL);
        return driver;
    }
    private  WebDriver initFirefoxDriver(String appURL){
        System.out.println("Launching Firefox browser..");
       // System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(appURL);
        return driver;
    }
    // chạy hàm initializeTestBaseSetUp truocuoc khi class nay dc goi
    @Parameters({"browserType","appURL"})
    @BeforeClass
    public void initializeTestBaseSetUp(String browserType, String appURL) {
        try {
            setDriver(browserType, appURL);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
