package org.example.lesson6;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SearchProductCardTest extends AbstractTest{

    @Test
    @DisplayName("Поиск товара")
    @Description("Поиск товара по исходным данным, переход на карточку найденного товара")
    @Tag("positiveTest")
    @Severity(SeverityLevel.NORMAL)
    void test () throws IOException {

        MainPage mainPage = new MainPage(getDriver());
            mainPage.searchProduct("254999-41");
            mainPage.goToProductCardAfterSearch();

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("254999-41-membrannaya-obuv"), "Переход на карточку искомого товара не осуществлен");

        File file = MyUtils.makeScreenshot(getDriver(),"failure- org.example.shoppingCartTest.testFalse" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));

        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);

        ProductCardPage productCardPage = new ProductCardPage(getDriver());
        productCardPage.chooseDescriptionTab();

        Assertions.assertEquals("true", productCardPage.getDescriptionTab().getAttribute("aria-selected"));

    }

    @Step("Проверка перехода на карточку найденного товара")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
