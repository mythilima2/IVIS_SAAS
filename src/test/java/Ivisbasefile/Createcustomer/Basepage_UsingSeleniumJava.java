package Ivisbasefile.Createcustomer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Basepage_UsingSeleniumJava {
//        public WebDriver driver;
//
//        @Parameters({"browser"})
//        @BeforeTest
//        public void setUp(@Optional("chrome") String browserName) {
//            // Set up the WebDriver for the specified browser
//            switch (browserName.toLowerCase()) {
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    break;
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    driver = new EdgeDriver();
//                    break;
//                default:
//                    throw new WebDriverException("Unsupported browser: " + browserName);
//            }
//
//            // Maximize the browser window and navigate to the URL
//            driver.manage().window().maximize();
//            driver.get("https://dev1-v2.iviscloud.net");
//        }
//
//        // Add a method to close the driver after the test suite runs
//        @AfterTest
//        public void tearDown() {
//            if (driver != null) {
//                driver.quit();
//            }

            public WebDriver driver;

            @BeforeTest
            public void setUp() {
                // Set up the WebDriver for Chrome
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);

                // Navigate to the URL
                driver.get("https://dev1-v2.iviscloud.net");

                // Add additional configurations if needed
                driver.manage().window().maximize();
                // Additional setup like setting viewport can be skipped as it's not needed for Selenium
            }


}
