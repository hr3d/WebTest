package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "login-email")
    private WebElement email;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(css = ".form-footer:nth-child(4) > .col-sm-6 > .btn")
    private WebElement submit;

    @FindBy(id = "modal-enter")
    private WebElement loginPopup;

    @FindBy(xpath = "//a[contains(@href, '/users/logout/')]")
    private WebElement logOut;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void loginIn(String email, String password){

        Actions loginIn = new Actions(getDriver());
        loginIn.sendKeys(this.email,email)
               .sendKeys(this.password,password)
               .click(this.submit)
               .build()
               .perform();
    }

    public WebElement getLoginPopup() {
        return loginPopup;
    }

    public WebElement getLogOut() {
        return logOut;
    }

}