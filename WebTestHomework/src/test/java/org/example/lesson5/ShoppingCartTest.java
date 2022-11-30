package org.example.lesson5;

import org.example.lesson4.MyNotTriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCartTest extends ProductCartAbstractTest {

    @Test
    @Tag("positiveTest")
    void test (){

        WebElement Button1 = getDriver().findElement(By.cssSelector(".goods__size-item"));
        Button1.click();

        WebElement Button2 = getDriver().findElement(By.cssSelector(".card__right .goods__add-basket-btn"));
        Actions clickButton2 = new Actions(getDriver());
        clickButton2.pause(200l)
                .doubleClick(Button2)
                .pause(300l)
                .build()
                .perform();

        WebElement Link1 = getDriver().findElement(By.cssSelector(".card__right .goods__add-basket-count-block > .goods__add-basket-count-text"));
        Actions clickLink1 = new Actions(getDriver());
        clickLink1.pause(200l)
                .click(Link1)
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("emarket/cart"), "Переход в корзину не осуществлен");
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.cssSelector(".basket__title > a")),"Выбранный товар отсутствует в корзине");

        WebElement Button3 = getDriver().findElement(By.cssSelector(".basket__delite"));
        Actions clickButton3 = new Actions(getDriver());
        clickButton3.click(Button3)
                .pause(500l)
                .build()
                .perform();

        Assertions.assertThrows(NoSuchElementException.class,() -> getDriver().findElement(By.cssSelector(".basket__title > a")));

    }

}
