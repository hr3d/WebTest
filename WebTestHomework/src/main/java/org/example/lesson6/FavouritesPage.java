package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FavouritesPage extends AbstractPage{

    @FindBy(css = "#tns1-item0 > .img-fluid")
    private WebElement oneFavouriteProduct;

    @FindBy(css = ".goods__favorites-sm")
    private WebElement chooseFavouriteButton;

    @FindBy(css = ".goods__title")
    private WebElement titleOneFavouriteProduct;

    public FavouritesPage(WebDriver driver) {
        super(driver);
    }

    public void deleteOneProductFromFavourites(){
        Actions deleteOneProductFromFavourites = new Actions(getDriver());
        deleteOneProductFromFavourites.moveToElement(oneFavouriteProduct)
                .click(this.chooseFavouriteButton)
                .pause(200l)
                .build()
                .perform();

    }

    public WebElement getTitleOneFavouriteProduct() {
        return titleOneFavouriteProduct;
    }

}
