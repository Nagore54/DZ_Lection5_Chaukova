import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Configuration.pageLoadTimeout;


public class DemoqaTest {
    WebDriver driver;

    @BeforeEach
    public void lunchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void registrationForm() {
        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Username");
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Lastname");
        driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("username@gmail.com");
        driver.findElement(By.xpath("//*[@id='genterWrapper']/div[2]/div[2]/label")).click();
        driver.findElement(By.xpath("//*[@id='userNumber']")).sendKeys("1234567895");

        driver.findElement(By.xpath("//*[@id='dateOfBirthInput']")).click();
        Select month = new Select(driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']")));
        month.selectByVisibleText("April");
        month.selectByIndex(3);

        Select year = new Select(driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']")));
        year.selectByVisibleText("1990");
        year.selectByValue("1990");

        driver.findElement(By.xpath("//*[@class='react-datepicker__month']/div[2]/div[3]")).click();

        driver.findElement(By.xpath("//*[@id='subjectsWrapper']/div[2]")).click();
        driver.findElement(By.xpath("//*[@id='subjectsInput']")).sendKeys("e");
        WebDriverWait waitSubjects = new WebDriverWait(driver, 3, 500);
        driver.findElement(By.xpath("//*[@id='react-select-2-option-1']")).click();

        driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[3]/label")).click();
        driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys("Current Address");


        driver.findElement(By.xpath("//*[@id='stateCity-wrapper']/div[2]/div")).click();
        WebDriverWait waitState = new WebDriverWait(driver, 3, 500);
        driver.findElement(By.xpath("//*[@id='react-select-3-option-1']")).click();

        driver.findElement(By.xpath("//*[@id='stateCity-wrapper']/div[3]/div")).click();
        WebDriverWait waitCity = new WebDriverWait(driver, 3, 500);
        driver.findElement(By.xpath("//*[@id='react-select-4-option-1']")).click();

        driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys(Keys.RETURN);

        WebDriverWait waitForm = new WebDriverWait(driver, 5, 500);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr/td[2]")).getText().contains("Username Lastname"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[2]/td[2]")).getText().contains("username@gmail.com"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[3]/td[2]")).getText().contains("Female"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[4]/td[2]")).getText().contains("1234567895"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[5]/td[2]")).getText().contains("10 April,1990"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[6]/td[2]")).getText().contains("Chemistry"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[7]/td[2]")).getText().contains("Sports, Music"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[9]/td[2]")).getText().contains("Current Address"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[10]/td[2]")).getText().contains("Uttar Pradesh Lucknow"));


    }
}
