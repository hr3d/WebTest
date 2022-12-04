package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductCardPage extends AbstractPage{

    @FindBy(id = "description-tab")
    private WebElement descriptionTab;

    @FindBy(css = ".goods__size-item")
    private WebElement chooseOneSize;

    @FindBy(css = ".card__right .goods__add-basket-btn")
    private WebElement inShoppingCart;

    @FindBy(css = ".card__right .goods__add-basket-count-block > .goods__add-basket-count-text")
    private WebElement shoppingCart;

    @FindBy(css = ".card__right > .goods__favorites")
    private WebElement favourites;

    public ProductCardPage(WebDriver driver) {
        super(driver);
    }

    public void chooseDescriptionTab(){

        Actions chooseDescriptionTab = new Actions(getDriver());
        chooseDescriptionTab.pause(200l)
                .click(this.descriptionTab)
                .pause(500l)
                .build()
                .perform();

    }

    public void clickChooseOneSize(){
        chooseOneSize.click();
    }

    public void addInShoppingCart(){
        Actions addInShoppingCart = new Actions(getDriver());
        addInShoppingCart.pause(200l)
                .doubleClick(this.inShoppingCart)
                .pause(300l)
                .build()
                .perform();
    }

    public void goToShoppingCart(){
        Actions goToShoppingCart = new Actions(getDriver());
        goToShoppingCart.pause(500l)
                .click(this.shoppingCart)
                .pause(200l)
                .build()
                .perform();
    }

    public void addInFavourites(){
        favourites.click();
    }

    public WebElement getDescriptionTab() {
        return descriptionTab;
    }

}
