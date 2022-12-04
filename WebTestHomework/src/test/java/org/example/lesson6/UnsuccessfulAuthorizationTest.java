package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UnsuccessfulAuthorizationTest extends AbstractTest {

    @Test
    @Tag("negativeTest")
    void test (){

        new MainPage(getDriver()).goToLoginPage();

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.loginIn("testmailforgb@mail.ru", "gbgb1234");

        Assertions.assertEquals("display: inline-block;", loginPage.getLoginPopup().getAttribute("style"));

    }

}
