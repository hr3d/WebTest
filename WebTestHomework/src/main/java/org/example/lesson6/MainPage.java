package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(css = ".header-icon:nth-child(4)")
    private WebElement login;

    @FindBy(css = ".header-search:nth-child(8)")
    private WebElement goToSearch;

    @FindBy(css = ".navbar-search:nth-child(9) > .search-query")
    private WebElement inputSearch;

    @FindBy(css = ".autocomplete-suggestion-content > a")
    private WebElement chooseSearch;

    @FindBy(css = ".footer-col:nth-child(2) li:nth-child(2) > a")
    private WebElement goToBlog;

    @FindBy(css = ".header-icon:nth-child(3)")
    private WebElement favourites;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        login.click();
    }

    public void goToBlogPage() {
        goToBlog.click();
    }

    public void searchProduct(String searchQuery){

        Actions searchProduct = new Actions(getDriver());
        searchProduct.click(this.goToSearch)
                .sendKeys(this.inputSearch,searchQuery)
                .build()
                .perform();

    }

    public void goToProductCardAfterSearch(){
        chooseSearch.click();
    }

    public void goToFavourites() {
        favourites.click();
    }

}