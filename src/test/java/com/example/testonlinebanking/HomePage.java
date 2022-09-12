package com.example.testonlinebanking;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

//page_url = https://localhost:4200
public class HomePage {

    public SelenideElement logoLink = $x("//a[@class='navbar-brand']");

    public SelenideElement homePageLink = $x("//a[text()='Dashboard']");

    public SelenideElement profileLink = $(By.linkText("Profile"));

    public SelenideElement transferLink = $(By.linkText("Transfer"));

    public SelenideElement transactionLink = $(By.linkText("Transactions"));

    public SelenideElement chequeBookRequestLink = $(By.linkText("Cheque Book Requests"));
}
