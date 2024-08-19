package helper;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class Utility {
    static Faker faker = new Faker();
    public static WebDriver driver;






    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    private static final String[] TITLES = {
            "mr", "ms", "mrs", "miss", "dr"
    };

    public static String generateRandomTitle() {
        Random random = new Random();
        int index = random.nextInt(TITLES.length);
        return TITLES[index];
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateGender() {
        String gender = faker.demographic().sex();
        gender = gender.toLowerCase();
        return gender;
    }

    public static String generatePhoneNumber() {
        return faker.number().digits(10);
    }

    public static String generateEmails() {


        String temp = RandomStringUtils.randomAlphanumeric(10);
        return temp + "@test.com";
    }

    public static void startDriver() {

        ChromeOptions options = new ChromeOptions();
        //untuk tidak menampilkan browser
//        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // 10 detik
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void quitDriver() {
        driver.quit();
    }




    public static void explicitWaitClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }




    public static void explicitWaitPresence(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void alertPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }






}
