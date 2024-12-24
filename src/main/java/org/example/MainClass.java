package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.junit.Assert;

public class MainClass {

    @Test
    public void FirstTest(){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\anastasia\\IdeaProjects\\Lab9\\drivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.get("https://habr.com/ru/all/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(
                        By.xpath("//*[@class='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search']")).click();


            Assert.assertEquals(driver.findElement(By.xpath("//input[@name='q']")), driver.switchTo().activeElement());
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium WebDriver");
            driver.findElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.linkText("Что такое Selenium WebDriver?")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String actualDate = driver.findElement(By.xpath("//*[@title='2012-10-01, 17:40']")).getText();
            Assert.assertEquals("1 окт 2012 в 17:40", actualDate);

            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            driver.manage().window().setSize(new Dimension(1280, 1025));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath("//a[@href='/ru/articles/' and @class='footer-menu__item-link']")).click();

            //driver.quit();
        }
}
