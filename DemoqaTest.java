import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class DemoqaTest {
    WebDriver driver;

    @BeforeEach
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement selectAll = driver.findElement(By.xpath("//*[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectAll);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void registrationForm() {
        String name1 = "Username";
        String name2 = "Lastname";
        String name = "Username Lastname";
        String email = "username@gmail.com";
        String number = "1234567895";
        String address = "Current Address";

        String gender = "Female";
        String DateofBirth = "10 April,1990";
        String subjects = "Chemistry";
        String hobbies = "Sports, Music";
        String StateandCity = "Uttar Pradesh Lucknow";
        String file = "C:\\Users\\olgac\\Pictures\\sdcard\\BadCom.jpg";
        String picture = "BadCom.jpg";


        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(name1);
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(name2);
        driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='genterWrapper']/div[2]/div[2]/label")).click();
        driver.findElement(By.xpath("//*[@id='userNumber']")).sendKeys(number);
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
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(file);
        driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys(address);

        driver.findElement(By.xpath("//*[@id='stateCity-wrapper']/div[2]/div")).click();
        WebDriverWait waitState = new WebDriverWait(driver, 3, 500);

        driver.findElement(By.xpath("//*[@id='react-select-3-option-1']")).click();

        driver.findElement(By.xpath("//*[@id='stateCity-wrapper']/div[3]/div")).click();
        WebDriverWait waitCity = new WebDriverWait(driver, 3, 500);

        driver.findElement(By.xpath("//*[@id='react-select-4-option-1']")).click();
        driver.findElement(By.xpath("//*[@id='submit']")).click();

        WebDriverWait waitForm = new WebDriverWait(driver, 5, 500);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr/td[2]")).getText().contains(name));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[2]/td[2]")).getText().contains(email));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[3]/td[2]")).getText().contains(gender));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[4]/td[2]")).getText().contains(number));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[5]/td[2]")).getText().contains(DateofBirth));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[6]/td[2]")).getText().contains(subjects));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[7]/td[2]")).getText().contains(hobbies));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[8]/td[2]")).getText().contains(picture));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[9]/td[2]")).getText().contains(address));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='modal-body']/div/table/tbody/tr[10]/td[2]")).getText().contains(StateandCity));
    }
}
