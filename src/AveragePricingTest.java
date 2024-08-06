import org.junit.jupiter.api.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AveragePricingTest {
    private WebDriver driver;
    private ChromeOptions options;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private static ArrayList<Integer> homePagePrice;
    private static ArrayList<Integer> itemPagePrice;
    private static ArrayList<String> pages;

    @BeforeAll
    public static void staticSetup() {
        homePagePrice = new ArrayList<>();
        itemPagePrice = new ArrayList<>();
        pages = new ArrayList<>();
    }







    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @DisplayName("Get Homepage Prices and Links")
    @Test
    @Order(1)
    public void getHomePagePrices() throws InterruptedException {
        options = new ChromeOptions().addArguments("--incognito");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("https://www.airbnb.com/?tab_id=home_tab&refinement_paths%5B%5D=%2Fhomes&search_mode=flex_destinations_search&flexible_trip_lengths%5B%5D=one_week&location_search=MIN_MAP_BOUNDS&monthly_start_date=2024-06-01&monthly_length=3&monthly_end_date=2024-09-01&price_filter_input_type=0&channel=EXPLORE&category_tag=Tag%3A8148&search_type=category_change");
        driver.manage().window().setSize(new Dimension(803, 816));
        Thread.sleep(5000);
        String price = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[3]/main/div[2]/div/div/div/div/div[1]/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[4]/div[2]/div/div/span/div/span[1]")).getText();
        String href = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[3]/main/div[2]/div[1]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div/div/a")).getAttribute("href");
        pages.add(href);
        homePagePrice.add(Integer.parseInt(price.split(" ")[0].replaceAll(",", "")));

        price = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[3]/main/div[2]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[4]/div[2]/div/div/span/div/span[1]")).getText();
        href = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[3]/main/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div[2]/div/div/div/div/a")).getAttribute("href");
        pages.add(href);
        homePagePrice.add(Integer.parseInt(price.split(" ")[0].replaceAll(",", "")));

        price = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[3]/main/div[2]/div/div/div/div/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[2]/div[4]/div[2]/div/div/span/div/span[1]")).getText();
        href = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[3]/main/div[2]/div[1]/div/div/div/div[1]/div[3]/div/div[2]/div/div/div/div/a")).getAttribute("href");
        pages.add(href);
        homePagePrice.add(Integer.parseInt(price.split(" ")[0].replaceAll(",", "")));

        price = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[3]/main/div[2]/div/div/div/div/div[1]/div[4]/div/div[2]/div/div/div/div/div/div[2]/div[4]/div[2]/div/div/span/div/span[1]")).getText();
        href = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[3]/main/div[2]/div[1]/div/div/div/div[1]/div[4]/div/div[2]/div/div/div/div/a")).getAttribute("href");
        pages.add(href);
        homePagePrice.add(Integer.parseInt(price.split(" ")[0].replaceAll(",", "")));

        System.out.println(homePagePrice);
        System.out.println(pages);
    }

    @DisplayName("Get page Prices")
    @ParameterizedTest
    @Order(2)
    @MethodSource("stringProvider")
    public void getPagePrices(String url) throws InterruptedException {
        options = new ChromeOptions().addArguments("--incognito");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(803, 816));
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String price = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div/div/div/div[1]/main/div/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div/div/span/div/span[1]")).getText();
        String servicefee = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div/div/div/div[1]/main/div/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[3]/div/section/div[1]/div[2]/span[2]")).getText();

        int intPrice = Integer.parseInt(price.split(" ")[0].replaceAll(",", ""));
        int intServicefee = Integer.parseInt(servicefee.split(" ")[0].replaceAll(",", ""));

        int pagePrice = intPrice + (intServicefee / 5);
        int idx = pages.indexOf(url);

        System.out.println("Homepage Average Price: "+ homePagePrice.get(idx) + "\n"+
            "Listing Page Price: " + pagePrice);

        assertEquals(pagePrice,homePagePrice.get(idx));

    }

    public static Stream<String> stringProvider() {
        return pages.stream();
    }






}
