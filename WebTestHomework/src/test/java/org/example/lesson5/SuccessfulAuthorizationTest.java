package org.example.lesson5;

import org.example.lesson4.MyNotTriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class SuccessfulAuthorizationTest extends AbstractTest {

    @Test
    @Disabled("Тест не входит в итоговый проект")
    @Tag("positiveTest")
    void test (){

        WebElement ButtonForEnter = getDriver().findElement(By.cssSelector(".header-icon:nth-child(4)"));
        ButtonForEnter.click();

        WebElement InputEmail = getDriver().findElement(By.id("login-email"));
        InputEmail.sendKeys("testmailforgb@mail.ru");

        WebElement InputPassword = getDriver().findElement(By.id("login-password"));
        InputPassword.sendKeys("gb654321");

        WebElement ButtonForEnter2 = getDriver().findElement(By.cssSelector(".form-footer:nth-child(4) > .col-sm-6 > .btn"));
        ButtonForEnter2.click();

        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//a[contains(@href, '/users/logout/')]")),"Авторизация не была осуществлена успешно");

    }

}

