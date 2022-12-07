package org.example.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SuccessfulAuthorizationTest extends AbstractTest {

    @Test
    @DisplayName("Успешная авторизация на сайте")
    @Description("Успешная авторизация на сайте с использованием корректных исходных данных почты и пароля")
    @Tag("positiveTest")
    @Severity(SeverityLevel.MINOR)
    void test () {

        new MainPage(getDriver()).goToLoginPage();

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.loginIn("testmailforgb@mail.ru", "gb654321");

        Assertions.assertDoesNotThrow(() -> loginPage.getLogOut(),"Авторизация не была осуществлена успешно");

    }

}

