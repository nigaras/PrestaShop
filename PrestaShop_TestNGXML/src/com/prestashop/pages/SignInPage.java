package com.prestashop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	private WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	public WebElement emailSignIn;

	@FindBy(id = "passwd")
	public WebElement password;

	@FindBy(id = "SubmitLogin")
	public WebElement signinButton;

}
