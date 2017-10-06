package com.prestashop.tests.user_account;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.pages.UserAccountPage;
import com.prestashop.utilities.Driver;

public class SimpleUserAccountTest {
	WebDriver driver;

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

		String expectedName = "Amy Fowler";
		UserAccountPage userAccountPage = new UserAccountPage(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
