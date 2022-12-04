package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SuccessfulAuthorizationTest extends AbstractTest {

    @Test
    @Tag("positiveTest")
    void test () {

        new MainPage(getDriver()).goToLoginPage();

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.loginIn("testmailforgb@mail.ru", "gb654321");

        Assertions.assertDoesNotThrow(() -> loginPage.getLogOut(),"Авторизация не была осуществлена успешно");

    }

}

