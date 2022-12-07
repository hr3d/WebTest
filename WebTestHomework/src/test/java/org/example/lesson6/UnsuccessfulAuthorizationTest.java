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

public class UnsuccessfulAuthorizationTest extends AbstractTest {

    @Test
    @DisplayName("Неуспешная авторизация на сайте")
    @Description("Неуспешная авторизация на сайте с использованием неккорректных исходных данных почты и пароля")
    @Tag("negativeTest")
    @Severity(SeverityLevel.MINOR)
    void test (){

        new MainPage(getDriver()).goToLoginPage();

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.loginIn("testmailforgb@mail.ru", "gbgb1234");

        Assertions.assertEquals("display: inline-block;", loginPage.getLoginPopup().getAttribute("style"));

    }

}
