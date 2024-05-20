// Generated by Selenium IDE
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PasswordTest {
    private WebDriver driver;
    private ChromeOptions options;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @AfterEach
    public void delay(){
        driver.quit();
    }

    @BeforeEach
    public void setUp() {
        options = new ChromeOptions().addArguments("--incognito");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @DisplayName("Expectated")
    @Test
    public void expected() {
        driver.get("https://www.airbnb.com/");
        driver.manage().window().setSize(new Dimension(800, 816));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.findElement(By.className(".i3tjjh1")).click();


        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".fs7xov7")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".fs7xov7"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".lgh3vnd")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".\\_jwti9r > .l1ovpqvx .\\_bc4egv")).click();


        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //driver.findElement(By.cssSelector(".\\_1gy58h7")).click();

        //Choose email login
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("email-login-email")).click();

        //Enter Email
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("email-login-email")).sendKeys("se2226testmail+test1@gmail.com");

        //Wait for page to load
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".t1dqvypu")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".t1dqvypu"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }


        //Enter Username
        driver.findElement(By.id("email-signup-user[first_name]")).click();
        driver.findElement(By.id("email-signup-user[first_name]")).sendKeys("Yasar");

        //Enter Last name
        driver.findElement(By.cssSelector(".r1el1iwj:nth-child(2) .ihbwjpb")).click();
        driver.findElement(By.id("email-signup-user[last_name]")).sendKeys("Uni");

        //Enter Birtday
        driver.findElement(By.cssSelector(".ie56xu4 > .atm_k4_idpfg4")).click();
        driver.findElement(By.id("email-signup-date")).sendKeys("1992-12-07");

        //Enter password
        driver.findElement(By.id("email-signup-password")).click();
        driver.findElement(By.id("email-signup-password")).sendKeys("acceptthispassword!");

        //Check if the invalid warning is displayed
        driver.findElement(By.xpath("/html/body/div[10]/div/section/div/div/div[2]/div/div[2]/div/section/div/form/div[7]/button")).click();
        assertTrue(isElementPresent(driver,By.xpath("/html/body/div[10]/div/section/div/div/div[2]/div/div[2]/div/section/div/form/div[4]/fieldset/div[1]/div[2]/div/div")));
    }



    @DisplayName("Unexpectated")
    @Test
    public void unexpected() {
        driver.get("https://www.airbnb.com/");
        driver.manage().window().setSize(new Dimension(800, 816));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.findElement(By.className(".i3tjjh1")).click();


        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".fs7xov7")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".fs7xov7"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".lgh3vnd")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".\\_jwti9r > .l1ovpqvx .\\_bc4egv")).click();


        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //driver.findElement(By.cssSelector(".\\_1gy58h7")).click();

        //Choose email login
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("email-login-email")).click();

        //Enter Email
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("email-login-email")).sendKeys("se2226testmail+test1@gmail.com");

        //Wait for page to load
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".t1dqvypu")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".t1dqvypu"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }


        //Enter Username
        driver.findElement(By.id("email-signup-user[first_name]")).click();
        driver.findElement(By.id("email-signup-user[first_name]")).sendKeys("Yasar");

        //Enter Last name
        driver.findElement(By.cssSelector(".r1el1iwj:nth-child(2) .ihbwjpb")).click();
        driver.findElement(By.id("email-signup-user[last_name]")).sendKeys("Uni");

        //Enter Birtday
        driver.findElement(By.cssSelector(".ie56xu4 > .atm_k4_idpfg4")).click();
        driver.findElement(By.id("email-signup-date")).sendKeys("1992-12-07");

        //Enter password
        driver.findElement(By.id("email-signup-password")).click();
        driver.findElement(By.id("email-signup-password")).sendKeys("acceptthispassword!");

        //Check if the invalid warning is displayed
        driver.findElement(By.xpath("/html/body/div[10]/div/section/div/div/div[2]/div/div[2]/div/section/div/form/div[7]/button")).click();
        assertFalse(isElementPresent(driver,By.xpath("/html/body/div[10]/div/section/div/div/div[2]/div/div[2]/div/section/div/form/div[4]/fieldset/div[1]/div[2]/div/div")));
    }

    public static boolean isElementPresent(WebDriver driver, By by) {
        try {
            WebElement element = driver.findElement(by);
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
