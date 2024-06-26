package Ivisbasefile.Createcustomer;

import com.microsoft.playwright.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.nio.file.Paths;

public class URLaunching_SeleniumGrid {
        public Playwright playwright;
        public Browser browser;
        public Page page;

        @Parameters({"browser"})
        @BeforeTest
        public void setUp(@Optional("chromium") String browserName) {
            playwright = Playwright.create();

            BrowserType browserType;
            switch (browserName.toLowerCase()) {
                case "firefox":
                    browserType = playwright.firefox();
                    break;
                case "chromium":
                    browserType = playwright.chromium();
                    break;
                case "webkit":
                    browserType = playwright.webkit();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser  : " + browserName);
            }

            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            page = context.newPage();

            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true)
            );
            page.navigate("https://dev2-v2.iviscloud.net");
            page.setViewportSize(1920, 1080);
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("saas.zip"))
            );
            page.waitForTimeout(1000);
        }
    }

