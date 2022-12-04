package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage extends AbstractPage{

    @FindBy(linkText = "2")
    private WebElement secondBlogPage;

    @FindBy(css = ".page-menu > li:nth-child(2) > a")
    private WebElement useful;

    @FindBy(css = ".page-menu > li:nth-child(3) > a")
    private WebElement facts;

    @FindBy(css = ".blog__item:nth-child(1) > .blog__img")
    private WebElement firstBlogArticle;

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public void goToSecondBlogPage(){
        secondBlogPage.click();
    }

    public void goToUseful(){
        useful.click();
    }

    public void goToFacts(){
        facts.click();
    }

    public void goToFirstBlogArticle(){
        firstBlogArticle.click();
    }

}
