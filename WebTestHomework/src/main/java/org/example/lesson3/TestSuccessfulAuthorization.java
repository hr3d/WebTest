package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestSuccessfulAuthorization {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://kotofey.ru");

        WebElement ButtonForEnter = driver.findElement(By.cssSelector(".header-icon:nth-child(4)"));
        ButtonForEnter.click();

        WebElement InputEmail = driver.findElement(By.id("login-email"));
        InputEmail.sendKeys("testmailforgb@mail.ru");

        WebElement InputPassword = driver.findElement(By.id("login-password"));
        InputPassword.sendKeys("gb654321");

        WebElement ButtonForEnter2 = driver.findElement(By.cssSelector(".form-footer:nth-child(4) > .col-sm-6 > .btn"));
        ButtonForEnter2.click();

        //driver.quit();
    }
}