package com.example.testonlinebanking;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TransferPage {
    public SelenideElement destinationAccountInput = $("#destinationAccount");

    public SelenideElement amountInput = $("#amount");

    public SelenideElement descriptionInput = $("#description");

    public SelenideElement transferButton = $x("//button[text()='Transfer']");

    public SelenideElement alertMessage = $x("//div[@id='alert']");
}
