package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchProductCardTest extends AbstractTest{

    @Test
    @Disabled("Тест не входит в итоговый проект")
    @Tag("positiveTest")
    void test (){

        WebElement ButtonToSearch = getDriver().findElement(By.cssSelector(".header-search:nth-child(8)"));
        ButtonToSearch.click();

        WebElement InputSearch = getDriver().findElement(By.cssSelector(".navbar-search:nth-child(9) > .search-query"));
        InputSearch.sendKeys("254999-41");

        WebElement Link1 = getDriver().findElement(By.cssSelector(".autocomplete-suggestion-content > a"));
        Link1.click();

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("254999-41-membrannaya-obuv"), "Переход на карточку искомого товара не осуществлен");

        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);

        WebElement Button1 = getDriver().findElement(By.id("description-tab"));
        Actions clickButton1 = new Actions(getDriver());
        clickButton1.pause(200l)
                .click(Button1)
                .pause(200l)
                .build()
                .perform();

        Assertions.assertEquals("true", Button1.getAttribute("aria-selected"));

    }

}
