package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestShoppingCart {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://kotofey.ru/market/soputstvuyuwie-tovary/ryukzaki-i-sumki/ryukzaki-detskie/02711202-00-ryukzak-detskij-zebra");

        WebElement Button1 = driver.findElement(By.cssSelector(".goods__size-item"));
        Button1.click();

        WebElement Button2 = driver.findElement(By.cssSelector(".card__right > #item-add-to-cart .goods__add-basket-text"));
        Button2.click();

        WebElement Link1 = driver.findElement(By.cssSelector(".card__right .goods__add-basket-count-block > .goods__add-basket-count-text"));
        Link1.click();

        WebElement Button3 = driver.findElement(By.cssSelector(".basket__delite"));
        Button3.click();

        //driver.quit();
    }
}
