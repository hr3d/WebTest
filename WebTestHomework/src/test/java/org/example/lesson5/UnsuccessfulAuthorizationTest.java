package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UnsuccessfulAuthorizationTest extends AbstractTest {

    @Test
    @Tag("negativeTest")
    void test (){

        WebElement ButtonForEnter = getDriver().findElement(By.cssSelector(".header-icon:nth-child(4)"));
        ButtonForEnter.click();

        WebElement InputEmail = getDriver().findElement(By.id("login-email"));
        InputEmail.sendKeys("testmailforgb@mail.ru");

        WebElement InputPassword = getDriver().findElement(By.id("login-password"));
        InputPassword.sendKeys("gbgb1234");

        WebElement ButtonForEnter2 = getDriver().findElement(By.cssSelector(".form-footer:nth-child(4) > .col-sm-6 > .btn"));
        ButtonForEnter2.click();

        WebElement AuthWindow = getDriver().findElement(By.id("modal-enter"));
        Assertions.assertEquals("display: inline-block;", AuthWindow.getAttribute("style"));

    }

}
