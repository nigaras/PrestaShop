package com.prestashop.tests.login;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.Driver;

public class PositiveSignInTests {
	WebDriver driver;

	@BeforeClass
	public void createUser() {
		// some code to creat users
	}

	@BeforeMethod
	@Parameters("browser")
	public void setUpTests(String browser) {
		driver = Driver.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void rightCredentialsTest() {

		HomePage homePage = new HomePage(driver);
		SignInPage signInPage = new SignInPage(driver);

		homePage.signInLink.click();
		signInPage.emailSignIn.sendKeys("testusertwo@ipdeer.com");
		signInPage.password.sendKeys("password");
		signInPage.signinButton.click();

		assertTrue(driver.findElement(By.xpath("//h1[.='My account']")).isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
