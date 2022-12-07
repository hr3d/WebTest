package org.example.lesson6;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ShoppingCartTest extends ProductCardAbstractTest {

    @Test
    @DisplayName("Страница 'Корзина'")
    @Description("Добавление и удаление товара из 'Корзины'")
    @Tag("positiveTest")
    @Severity(SeverityLevel.CRITICAL)
    void test () throws IOException {

        ProductCardPage productCardPage = new ProductCardPage(getDriver());
            productCardPage.clickChooseOneSize();
            productCardPage.addInShoppingCart();
            productCardPage.goToShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("emarket/cart"), "Переход в корзину не осуществлен");

        try {
            Assertions.assertDoesNotThrow(() -> shoppingCartPage.getTitleOneProduct(),"Выбранный товар отсутствует в корзине");
        } catch (NoSuchElementException e){
            File file = MyUtils.makeScreenshot(getDriver(),"failure- org.example.shoppingCartTest.testFalse" + System.currentTimeMillis() + ".png");
            saveScreenshot(Files.readAllBytes(file.toPath()));
        }

        shoppingCartPage.deleteOneProduct();

        try {
            Assertions.assertThrows(NoSuchElementException.class,() -> getDriver().findElement(By.cssSelector(".basket__total-btn")));
        } catch (NoSuchElementException e){
            File file = MyUtils.makeScreenshot(getDriver(),"failure- org.example.shoppingCartTest.testFalse" + System.currentTimeMillis() + ".png");
            saveScreenshot(Files.readAllBytes(file.toPath()));
        }

    }

    @Step("Проверка нахождения товара в 'Корзине'")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}