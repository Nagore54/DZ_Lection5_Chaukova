
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowsers {

    @Test
    public void openCromeTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://academ-it-school.ru/");

        driver.quit();
    }

    @Test
    public void penEdgeTest() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://academ-it-school.ru/");

        driver.quit();
    }

    @Test
    public void openFirefoxTest() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://academ-it-school.ru/");

        driver.quit();
    }
}
