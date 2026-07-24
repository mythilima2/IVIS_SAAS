package basefile.URL.launching;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeTest;

import java.nio.file.Paths;

public class Dev1v2_URLlaunching {
    public Playwright playwright;
    public BrowserType firefox;
    public Browser browser;
    public Page page ;

    @BeforeTest


    public void setUp() {
        playwright = Playwright.create();
        firefox= playwright.firefox();
        browser = firefox.launch(new BrowserType.LaunchOptions().setHeadless(false));
        page=browser.newPage();
        BrowserContext context=browser.newContext();
        context.tracing().start(
                new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true)
        );
        page.navigate("https://uat1.iviscloud.net/");
        page.setViewportSize(1920, 1080);
        context.tracing().stop(
                new Tracing.StopOptions()
                        .setPath(Paths.get("saas.zip")));
        page.waitForTimeout(1000);


    }
}
