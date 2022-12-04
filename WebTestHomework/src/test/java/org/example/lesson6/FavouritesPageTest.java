package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FavouritesPageTest extends ProductCardAbstractTest {

    @Test
    @Tag("positiveTest")
    void test () {

        new ProductCardPage(getDriver()).addInFavourites();

        new MainPage(getDriver()).goToFavourites();

        FavouritesPage favouritesPage = new FavouritesPage(getDriver());

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("favorites"), "Переход на страницу отложенных товаров не осуществлен");
        Assertions.assertDoesNotThrow(() -> favouritesPage.getTitleOneFavouriteProduct(),"Выбранный товар отсутствует в корзине");

        favouritesPage.deleteOneProductFromFavourites();

        Assertions.assertThrows(NoSuchElementException.class,() -> getDriver().findElement(By.cssSelector(".goods__title")));

    }

}
