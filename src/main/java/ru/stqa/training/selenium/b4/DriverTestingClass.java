package ru.stqa.training.selenium.b4;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class DriverTestingClass {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void googlePageTest(){
        driver.get("http://www.google.com/");
        driver.findElement(By.className("xPnqmf")).click();
        driver.findElement(By.id("K32")).click();
        driver.findElement(By.className("xPnqmf")).click();
        driver.findElement(By.id("K32")).click();
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
