package com.example.testonlinebanking;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    HomePage homePage = new HomePage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x1280";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:4200");
    }

    @Order(1)
    @Test
    public void loginWithInvalidUsernameAndPassword() throws InterruptedException {
        mainPage.showLoginPageButton.click();
        Thread.sleep(5000);
        loginPage.inputUsername.sendKeys("Selenium");
        Thread.sleep(5000);
        loginPage.inputPassword.sendKeys("Selenium");
        Thread.sleep(5000);
        loginPage.loginButton.submit();
        Thread.sleep(5000);
        assertEquals("Login Failed Wrong Username or Password", loginPage.loginAlertText.text());
    }
    @Order(2)
    @Test
    public void testMenuBarLinks() throws InterruptedException {
        mainPage.showLoginPageButton.click();
        Thread.sleep(5000);
        loginPage.inputUsername.sendKeys("vivian");
        Thread.sleep(5000);
        loginPage.inputPassword.sendKeys("vivian");
        loginPage.loginButton.submit();
        Thread.sleep(5000);
        Selenide.refresh();
        assertEquals("IcinBankPortal", Selenide.title());
        homePage.homePageLink.click();
        Thread.sleep(5000);
        homePage.transactionLink.click();
        Thread.sleep(5000);
        homePage.transferLink.click();
        Thread.sleep(5000);
        homePage.chequeBookRequestLink.click();
        Thread.sleep(5000);
        homePage.profileLink.click();
        mainPage.logoutButton.click();
    }

    @Order(3)
    @Test
    public void requestChequeBook() throws InterruptedException {
        mainPage.showLoginPageButton.click();
        Thread.sleep(5000);
        loginPage.inputUsername.sendKeys("vivian");
        Thread.sleep(5000);
        loginPage.inputPassword.sendKeys("vivian");
        loginPage.loginButton.submit();
        Thread.sleep(5000);
        Selenide.refresh();
        homePage.chequeBookRequestLink.click();
        Thread.sleep(5000);
        mainPage.logoutButton.click();
    }
    @Order(4)
    @Test
    public void transferFund(){

    }

//    @Test
//    public void search() {
//        mainPage.searchButton.click();
//
//        $("[data-test='search-input']").sendKeys("Selenium");
//        $("button[data-test='full-search-button']").click();
//
//        $("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"));
//    }
//
//    @Test
//    public void toolsMenu() {
//        mainPage.toolsMenu.click();
//
//        $("div[data-test='main-submenu']").shouldBe(visible);
//    }
//
//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeAllToolsButton.click();
//
//        $("#products-page").shouldBe(visible);
//
//        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
//    }

}
