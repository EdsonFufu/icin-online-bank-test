package com.example.testonlinebanking;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://localhost:4200/check-book-request/
public class ChequeBookRequestPage {
    public SelenideElement requestChequeBookButton = $x("//a[text()='Click Here To Request Check Book']");
}
