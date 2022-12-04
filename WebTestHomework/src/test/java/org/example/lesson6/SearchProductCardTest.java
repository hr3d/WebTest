package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchProductCardTest extends AbstractTest{

    @Test
    @Tag("positiveTest")
    void test (){

        MainPage mainPage = new MainPage(getDriver());
            mainPage.searchProduct("254999-41");
            mainPage.goToProductCardAfterSearch();

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("254999-41-membrannaya-obuv"), "Переход на карточку искомого товара не осуществлен");

        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);

        ProductCardPage productCardPage = new ProductCardPage(getDriver());
        productCardPage.chooseDescriptionTab();

        Assertions.assertEquals("true", productCardPage.getDescriptionTab().getAttribute("aria-selected"));

    }

}
