package com.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Sign in")
	public WebElement signInLink;

	// @FindBys
	// @FindAll
	// @CacheLookup

	public WebElement getProduct(String title) {
		String css = "h5>a[title='" + title + "']";
		return driver.findElement(By.cssSelector(css));
	}

}
