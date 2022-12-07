package org.example.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BlogNavigationTest extends AbstractTest{

    @Test
    @DisplayName("Навигация по блогу")
    @Description("Навигация по вкладкам и страницам блога, просмотр статьи блога")
    @Tag("positiveTest")
    @Severity(SeverityLevel.MINOR)
    void test (){

        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

        new MainPage(getDriver()).goToBlogPage();

        BlogPage blogPage = new BlogPage(getDriver());
            blogPage.goToSecondBlogPage();

        Assertions.assertEquals("Блог Котофей - страница 2",getDriver().getTitle(),"Переход на вторую страницу блога не осуществлен");

            blogPage.goToUseful();
            blogPage.goToFacts();
            blogPage.goToFirstBlogArticle();

        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.cssSelector(".blog-header")),"Не осуществлен переход на страницу отдельной статьи блога");

    }

}
