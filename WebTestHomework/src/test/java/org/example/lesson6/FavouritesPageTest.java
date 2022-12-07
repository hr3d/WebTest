package org.example.lesson6;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FavouritesPageTest extends ProductCardAbstractTest {

    @Test
    @DisplayName("Страница 'Отложенные товары'")
    @Description("Добавление и удаление товара из 'Отложенные товары'")
    @Tag("positiveTest")
    @Severity(SeverityLevel.NORMAL)
    void test () throws IOException {

        new ProductCardPage(getDriver()).addInFavourites();

        new MainPage(getDriver()).goToFavourites();

        FavouritesPage favouritesPage = new FavouritesPage(getDriver());

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("favorites"), "Переход на страницу отложенных товаров не осуществлен");

        try {
            Assertions.assertDoesNotThrow(() -> favouritesPage.getTitleOneFavouriteProduct(),"Выбранный товар отсутствует в корзине");
        } catch (NoSuchElementException e){
            File file = MyUtils.makeScreenshot(getDriver(),"failure- org.example.favouritePageTest.testFalse" + System.currentTimeMillis() + ".png");
            saveScreenshot(Files.readAllBytes(file.toPath()));
        }

        favouritesPage.deleteOneProductFromFavourites();

        try {
            Assertions.assertThrows(NoSuchElementException.class,() -> getDriver().findElement(By.cssSelector(".goods__title")));
        } catch (NoSuchElementException e){
            File file = MyUtils.makeScreenshot(getDriver(),"failure- org.example.favouritePageTest.testFalse" + System.currentTimeMillis() + ".png");
            saveScreenshot(Files.readAllBytes(file.toPath()));
        }

    }

    @Step("Проверка нахождения товара в 'Отложенные товары'")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }



}
