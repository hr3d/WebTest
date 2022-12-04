package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCartTest extends ProductCardAbstractTest {

    @Test
    @Tag("positiveTest")
    void test (){

        ProductCardPage productCardPage = new ProductCardPage(getDriver());
            productCardPage.clickChooseOneSize();
            productCardPage.addInShoppingCart();
            productCardPage.goToShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("emarket/cart"), "Переход в корзину не осуществлен");
        Assertions.assertDoesNotThrow(() -> shoppingCartPage.getTitleOneProduct(),"Выбранный товар отсутствует в корзине");

        shoppingCartPage.deleteOneProduct();

        Assertions.assertThrows(NoSuchElementException.class,() -> getDriver().findElement(By.cssSelector(".basket__total-btn")));

    }

}