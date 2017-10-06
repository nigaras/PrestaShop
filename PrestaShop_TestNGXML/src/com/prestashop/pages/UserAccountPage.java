package com.prestashop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage {
	public UserAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".account")
	public WebElement accountHolderName;
}
