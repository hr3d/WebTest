package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ProductCartAbstractTest {

    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://kotofey.ru/market/soputstvuyuwie-tovary/ryukzaki-i-sumki/ryukzaki-detskie/02711202-00-ryukzak-detskij-zebra"),"Страница не доступна");
    }

    @AfterAll
    static void close(){
        //driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
