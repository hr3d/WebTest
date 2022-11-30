package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BlogNavigationTest extends AbstractTest{

    @Test
    @Tag("positiveTest")
    void test (){

        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

        WebElement LinkToBlog = getDriver().findElement(By.cssSelector(".footer-col:nth-child(2) li:nth-child(2) > a"));
        LinkToBlog.click();

        WebElement LinkToBlogSecondPage = getDriver().findElement(By.linkText("2"));
        LinkToBlogSecondPage.click();

        Assertions.assertEquals("Блог Котофей - страница 2",getDriver().getTitle(),"Переход на вторую страницу блога не осуществлен");

        WebElement BlogLink1 = getDriver().findElement(By.cssSelector(".page-menu > li:nth-child(2) > a"));
        BlogLink1.click();

        WebElement BlogLink2 = getDriver().findElement(By.cssSelector(".page-menu > li:nth-child(3) > a"));
        BlogLink2.click();

        WebElement BlogLink3 = getDriver().findElement(By.cssSelector(".blog__item:nth-child(1) > .blog__img"));
        BlogLink3.click();

        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.cssSelector(".blog-header")),"Не осуществлен переход на страницу отдельной статьи блога");

    }

}
