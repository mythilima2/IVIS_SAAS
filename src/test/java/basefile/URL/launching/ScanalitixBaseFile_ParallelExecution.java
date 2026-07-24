package basefile.URL.launching;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

import java.nio.file.Paths;

public class ScanalitixBaseFile_ParallelExecution {

        //====================================================
        // Thread Safe Objects
        //====================================================

        private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
        private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
        private static final ThreadLocal<BrowserContext> context = new ThreadLocal<>();
        private static final ThreadLocal<Page> page = new ThreadLocal<>();
        private static final ThreadLocal<APIRequestContext> requestContext = new ThreadLocal<>();

        // Current Environment
        private static final ThreadLocal<String> currentEnvironment = new ThreadLocal<>();



        //====================================================
        // Setup
        //====================================================

        @Parameters({"browser","environment"})
        @BeforeClass(alwaysRun = true)
        public void setUp(
                @Optional("chromium") String browserName,
                @Optional("uat") String environment) {

            ConfigReader.loadProperties();

            currentEnvironment.set(environment.toLowerCase());

            //----------------------------------------------------
            // Playwright
            //----------------------------------------------------

            playwright.set(Playwright.create());

            //----------------------------------------------------
            // Launch Options
            //----------------------------------------------------

            BrowserType.LaunchOptions launchOptions =
                    new BrowserType.LaunchOptions()
                            .setHeadless(Boolean.parseBoolean(ConfigReader.get("headless")))
                            .setSlowMo(Integer.parseInt(ConfigReader.get("slowmo")));

            String channel = ConfigReader.get("channel");

            if(channel != null && !channel.isBlank()){
                launchOptions.setChannel(channel);
            }

            //----------------------------------------------------
            // Browser Launch
            //----------------------------------------------------

            switch(browserName.toLowerCase()){

                case "chromium":
                    browser.set(playwright.get().chromium().launch(launchOptions));
                    break;

                case "firefox":
                    browser.set(playwright.get().firefox().launch(launchOptions));
                    break;

                case "webkit":
                    browser.set(playwright.get().webkit().launch(launchOptions));
                    break;

                default:
                    throw new RuntimeException("Unsupported Browser : " + browserName);

            }

            //----------------------------------------------------
            // Browser Context
            //----------------------------------------------------

            Browser.NewContextOptions options =
                    new Browser.NewContextOptions()
                            .setIgnoreHTTPSErrors(true)
                            .setViewportSize(
                                    Integer.parseInt(ConfigReader.get("width")),
                                    Integer.parseInt(ConfigReader.get("height"))
                            );

            if(Boolean.parseBoolean(ConfigReader.get("video"))){

                options.setRecordVideoDir(
                        Paths.get("test-results/videos"));

            }

            context.set(browser.get().newContext(options));

            context.get().setDefaultTimeout(
                    Long.parseLong(ConfigReader.get("timeout")));

            //----------------------------------------------------
            // Trace
            //----------------------------------------------------

            if(Boolean.parseBoolean(ConfigReader.get("trace"))){

                context.get().tracing().start(

                        new Tracing.StartOptions()

                                .setScreenshots(true)
                                .setSnapshots(true)
                                .setSources(true)

                );

            }

            //----------------------------------------------------
            // Page
            //----------------------------------------------------

            page.set(context.get().newPage());

            page.get().navigate(getApplicationUrl());

            //----------------------------------------------------
            // API Context
            //----------------------------------------------------

            requestContext.set(

                    playwright.get().request().newContext(

                            new APIRequest.NewContextOptions()

                                    .setBaseURL(getApiUrl())

                    )

            );

        }

        //====================================================
        // Environment URLs
        //====================================================

        private String getApplicationUrl(){

            switch(currentEnvironment.get()){

                case "dev2":
                    return ConfigReader.get("dev2Url");

                case "uat":
                    return ConfigReader.get("uatUrl");

                case "poc":
                    return ConfigReader.get("pocUrl");

                default:
                    throw new RuntimeException("Invalid Environment");

            }

        }

        private String getApiUrl(){

            switch(currentEnvironment.get()){

                case "dev2":
                    return ConfigReader.get("dev2Api");

                case "uat":
                    return ConfigReader.get("uatApi");

                case "poc":
                    return ConfigReader.get("pocApi");

                default:
                    throw new RuntimeException("Invalid Environment");

            }

        }

        //====================================================
        // Environment Credentials
        //====================================================

    //====================================================
// Environment Credentials
//====================================================

    public String getUsername() {
        return ConfigReader.get(currentEnvironment.get() + "Username");
    }

    public String getPassword() {
        return ConfigReader.get(currentEnvironment.get() + "Password");
    }
        //====================================================
        // Getters
        //====================================================

    public Playwright getPlaywright() {
        return playwright.get();
    }

    public Browser getBrowser() {
        return browser.get();
    }

    public BrowserContext getContext() {
        return context.get();
    }

    public Page getPage() {
        return page.get();
    }

    public APIRequestContext getRequestContext() {
        return requestContext.get();
    }

    public String getEnvironment() {
        return currentEnvironment.get();
    }


        //====================================================
        // Tear Down
        //====================================================

        @AfterClass(alwaysRun = true)
        public void tearDown(){

            try{

                if(context.get()!=null &&
                        Boolean.parseBoolean(ConfigReader.get("trace"))){

                    context.get().tracing().stop(

                            new Tracing.StopOptions()

                                    .setPath(

                                            Paths.get(
                                                    "test-results/traces/trace-"
                                                            + Thread.currentThread().getId()
                                                            + ".zip")

                                    )

                    );

                }

            }catch(Exception ignored){}

            if(requestContext.get()!=null){

                requestContext.get().dispose();
                requestContext.remove();

            }

            if(page.get()!=null){

                page.get().close();
                page.remove();

            }

            if(context.get()!=null){

                context.get().close();
                context.remove();

            }

            if(browser.get()!=null){

                browser.get().close();
                browser.remove();

            }

            if(playwright.get()!=null){

                playwright.get().close();
                playwright.remove();

            }

            currentEnvironment.remove();

        }

}
