import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class UsingBeforeAfterTest {
    WebDriver driver;

    @Test
    public void openBrowsers() {
        String browser = System.getProperty("browser");
        if (browser.equals("chrome")) {
            System.getProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application");
            driver = new ChromeDriver();
            driver.quit();
        } else if (browser.equals("edge")) {
            System.getProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.getProperty("webdriver.firefox.driver", "C:\\Program Files\\Mozilla Firefox");
            driver = new ChromeDriver();
        }
        driver.get("https://academ-it-school.ru/");
        driver.manage().window().maximize();
    }

}
