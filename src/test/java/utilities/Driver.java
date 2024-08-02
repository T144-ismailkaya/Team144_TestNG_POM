package utilities;

import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver(){

    }

    // TestNG WebDriver objesini bize dondurecek getDriver() ile WebDriver objesi olusturur
    public static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            String secilenBrowser = ConfigReader.getProperty("browser");

            switch (secilenBrowser){
                case "opera" :
                    driver = new FirefoxDriver();
                    break;
                case "edge" :
                    driver = new EdgeDriver();
                    break;
                case "safari" :
                    driver = new SafariDriver();
                    break;
                default:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-search-engine-choice-screen");
                    driver=new ChromeDriver(options);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver=null;
    }
}

