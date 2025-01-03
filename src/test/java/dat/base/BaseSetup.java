package dat.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.initChromeDriver(appURL);
    }

    //khởi tạo cấu hình của các browser để đưa vào switch case
    private WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
       // System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(appURL);
        return driver;
    }
    //25phut18s video32
}
