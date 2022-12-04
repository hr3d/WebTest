package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage{

    @FindBy(css = ".basket__delite")
    private WebElement deleteOneProductButton;

    @FindBy(css = ".basket__title > a")
    private WebElement titleOneProduct;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteOneProduct(){
        Actions deleteOneProduct = new Actions(getDriver());
        deleteOneProduct.click(this.deleteOneProductButton)
                .pause(500l)
                .build()
                .perform();

    }

    public WebElement getTitleOneProduct() {
        return titleOneProduct;
    }

}
