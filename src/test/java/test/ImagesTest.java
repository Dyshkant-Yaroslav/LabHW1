package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImagesTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com.ua/?hl=ru");
    }

    @Test
    public void simpleTest() {
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("nature wallpapers", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='hdtb-mitem']//a[contains(text(),'Картинки')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> images = driver.findElements(By.xpath("//div[@id='islrg']//img"));
        for (WebElement img : images) {
            Assert.assertTrue(img.isEnabled());
        }

    }

    @AfterMethod
    public void close() {
        driver.close();
    }

}
