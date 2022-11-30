package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FavouritesPageTest extends ProductCartAbstractTest{

    @Test
    @Tag("positiveTest")
    void test (){

        WebElement Button1 = getDriver().findElement(By.cssSelector(".card__right > .goods__favorites"));
        Button1.click();

        WebElement Link1 = getDriver().findElement(By.cssSelector(".header-icon:nth-child(3)"));
        Link1.click();

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("favorites"), "Переход на страницу отложенных товаров не осуществлен");
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.cssSelector(".goods__title")),"Выбранный товар отсутствует в корзине");

        WebElement Link2 = getDriver().findElement(By.cssSelector("#tns1-item0 > .img-fluid"));
        WebElement Button2 = getDriver().findElement(By.cssSelector(".goods__favorites-sm"));
        Actions clickButton2 = new Actions(getDriver());
        clickButton2.moveToElement(Link2)
                .click(Button2)
                .pause(300l)
                .build()
                .perform();
        //Button2.click();

        Assertions.assertThrows(NoSuchElementException.class,() -> getDriver().findElement(By.cssSelector(".goods__title")));

    }

}
