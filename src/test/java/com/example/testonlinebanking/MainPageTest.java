package com.example.testonlinebanking;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ChequeBookRequestPage chequeBookRequestPage = new ChequeBookRequestPage();

    TransferPage transferPage = new TransferPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1680x1280";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:4200");
    }

    @Order(value = 10)
    @Test
    public void loginWithInvalidUsernameAndPassword() {
        mainPage.showLoginPageButton.click();
        sleep(1000);
        loginPage.inputUsername.sendKeys("Selenium");
        sleep(1000);
        loginPage.inputPassword.sendKeys("Selenium");
        sleep(1000);
        loginPage.loginButton.submit();
        sleep(1000);
        assertEquals("Login Failed Wrong Username or Password", loginPage.loginAlertText.text());
        sleep(1000);
    }
    @Order(2)
    @Test
    public void testMenuBarLinks() {
        mainPage.showLoginPageButton.click();
        sleep(2000);
        loginPage.inputUsername.sendKeys("vivian");
        sleep(1000);
        loginPage.inputPassword.sendKeys("vivian");
        loginPage.loginButton.submit();
        sleep(2000);
        refresh();
        assertEquals("IcinBankPortal", Selenide.title());
        homePage.homePageLink.click();
        sleep(1000);
        homePage.transactionLink.click();
        sleep(3000);
        homePage.transferLink.click();
        sleep(1000);
        homePage.chequeBookRequestLink.click();
        sleep(3000);
        homePage.profileLink.click();
        sleep(1000);
        mainPage.logoutButton.click();
        sleep(1000);
        homePage.logoLink.click();
        sleep(2000);
    }

    @Order(3)
    @Test
    public void requestChequeBook() {
        mainPage.showLoginPageButton.click();
        sleep(1000);
        loginPage.inputUsername.sendKeys("vivian");
        sleep(1000);
        loginPage.inputPassword.sendKeys("vivian");
        sleep(2000);
        loginPage.loginButton.submit();
        sleep(3000);
        refresh();
        sleep(2000);
        homePage.chequeBookRequestLink.click();
        sleep(2000);
        chequeBookRequestPage.requestChequeBookButton.click();
        sleep(2000);
        assertEquals("Check Book Request Sent Successfully",$x("//div[@id='alert']").text());
        sleep(2000);
        mainPage.logoutButton.click();
        sleep(1000);
        homePage.logoLink.click();
        sleep(2000);
    }
    @Order(4)
    @Test
    public void transferFund(){
        mainPage.showLoginPageButton.click();
        sleep(1000);
        loginPage.inputUsername.sendKeys("vivian");
        sleep(1000);
        loginPage.inputPassword.sendKeys("vivian");
        sleep(2000);
        loginPage.loginButton.submit();
        sleep(3000);
        refresh();
        sleep(2000);
        homePage.transferLink.click();
        sleep(1000);
        transferPage.destinationAccountInput.sendKeys("110012555521503353");
        sleep(1500);
        transferPage.amountInput.sendKeys("300000");
        sleep(1500);
        transferPage.descriptionInput.sendKeys("Transafer Amount to the given account");
        sleep(1500);
        transferPage.transferButton.submit();
        sleep(2500);
        transferPage.alertMessage.shouldBe(visible);
        mainPage.logoutButton.click();
        sleep(2000);
    }

}
