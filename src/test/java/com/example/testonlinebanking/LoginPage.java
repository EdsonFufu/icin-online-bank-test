package com.example.testonlinebanking;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

//  page_url = https://localhost:4200/login/
public class LoginPage {
    public SelenideElement inputUsername = $("#exampleInputEmail1");
    public SelenideElement inputPassword = $("#exampleInputPassword1");
    public SelenideElement loginButton = $("#exampleInputButton1");

    public SelenideElement loginAlertText = $("#error");
}
