package testpackage;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdrive.chrome.driver","E://chromedriver/chromedriver/chromedriver.exe");

        driver = new ChromeDriver();
        baseUrl = "https://ok.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @org.junit.Test
    public void testUntitledTestCase() throws Exception {
//        driver.get("https://vk.com/im?peers=631778455_334905867_c173_c213_60778768&sel=c169");
//        driver.findElement(By.xpath("//li[@id='l_msg']/a/span")).click();
//        driver.findElement(By.xpath("//li[@id='l_nwsf']/a/span")).click();
//        driver.findElement(By.xpath("//li[@id='l_gr']/a/span")).click();
//        driver.findElement(By.xpath("(//a[contains(text(),'СИО: Студенческое Инженерное Общество BEST')])[7]")).click();
//        driver.findElement(By.xpath("//div[@id='post-3558335_4308']/div/div[2]/div/div[2]/div/div/a/div")).click();
        driver.get("https://ok.ru/");
        driver.findElement(By.id("field_email")).clear();
        driver.findElement(By.id("field_email")).sendKeys("sdfsfsdf");
        driver.findElement(By.id("field_password")).click();
        driver.findElement(By.id("field_password")).clear();
        driver.findElement(By.id("field_password")).sendKeys("sfsfsdfs");
        driver.findElement(By.xpath("//input[@value='Войти в Одноклассники']")).click();
        Assert.assertTrue("Все еще лох",driver.getCurrentUrl().contains("https://ok.ru/"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}