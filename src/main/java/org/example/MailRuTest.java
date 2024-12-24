package org.example;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailRuTest {
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\anastasia\\IdeaProjects\\Lab9\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://mail.rambler.ru/");
        driver.manage().window().setSize(new Dimension(1920, 1080));;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@inputclassname='-metrika-nokeys']")).sendKeys("silivonchik@ro.ru");
        driver.findElement(By.xpath("//input[@type='password']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("toptester123A");

        driver.findElement(By.xpath("//button[@data-cerber-id='login_form::main::login_button']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//div[@class='rc__xgBcB']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='rc__l-p9h']")));

        String actualName = driver.findElement(By.xpath("//span[@class='rc__l-p9h']")).getText();
        Assert.assertEquals("Анастасия Силивончик", actualName);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//button[@data-cerber='topline_mail::user_profile::logout']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        if (
                !driver.findElement(
                        By.xpath(
                                "//span[@class='rc__5dmhhz']")
                ).isDisplayed()
        ) { throw new AssertionError("Элемент не найден."); }

       //driver.quit();
    }
}