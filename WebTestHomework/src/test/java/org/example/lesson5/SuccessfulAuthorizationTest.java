package org.example.lesson5;

import org.example.lesson4.MyNotTriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class SuccessfulAuthorizationTest extends AbstractTest {

    @Test
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

//    @Test
//    @Disabled
//    void voidTest(){
//        WebElement voidElement = getDriver().findElement(By.cssSelector(".sb-icon-search"));
//        Actions actionProviderContext = new Actions(getDriver());
//        // Perform context-click action on the element
//        actionProviderContext.contextClick(voidElement).build().perform();
//
//        Actions actionProviderDouble = new Actions(getDriver());
//        // Perform double-click action on the element
//        actionProviderDouble.doubleClick(voidElement).build().perform();
//
//        Actions actionProviderMove = new Actions(getDriver());
//        // Performs mouse move action onto the element
//        actionProviderMove.moveToElement(voidElement).build().perform();
//
//        Actions actionProviderOffset = new Actions(getDriver());
//        // Performs mouse move action onto the offset position
//        actionProviderOffset.moveByOffset(1, 1).build().perform();
//
//        Actions actionProvider = new Actions(getDriver());
//        // Performs drag and drop action of sourceEle onto the targetEle
//        actionProvider.dragAndDrop(voidElement, voidElement).build().perform();
//
//        Actions actionProviderHold = new Actions(getDriver());
//        actionProviderHold.clickAndHold(voidElement).moveToElement(voidElement).build().perform();
//        // Performs release event
//        actionProviderHold.release().build().perform();
//
//    }
//
//    @Test
//    @Disabled
//    void voidKeyTest(){
//        Actions actionProvider = new Actions(getDriver());
//        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
//
//        keydown.perform();
//
//        actionProvider.sendKeys(Keys.ENTER).perform();
//    }
//
//    @Test
//    @Disabled
//    void voidBrowserTest(){
//        System.out.println(getDriver().getTitle());
//        System.out.println(getDriver().getCurrentUrl());
//        getDriver().navigate().to("https://selenium.dev");
//        getDriver().navigate().back();
//        getDriver().navigate().forward();
//        getDriver().navigate().refresh();
//    }
//
//    @Test
//    @Disabled
//    void voidElements(){
//        WebElement selectElement = getDriver().findElement(By.id("selectElementID"));
//        Select selectObject = new Select(selectElement);
//        selectObject.selectByIndex(1);
//        selectObject.selectByValue("value1");
//        selectObject.selectByVisibleText("Bread");
//        selectObject.deselectAll();
//    }


//    void test() throws InterruptedException {
//
//        WebElement webElement = driver.findElement(By.cssSelector(".sb-icon-search"));
//        webElement.click();
//        Thread.sleep(1000);
//        WebElement webElement2 = driver.findElement(By.cssSelector(".sb-search-input"));
//        webElement2.click();
//        webElement2.sendKeys("кравец");
//        webElement2.submit();
//        Assertions.assertEquals("Поиск",driver.getTitle(),"Не та страница");
//    }

}

