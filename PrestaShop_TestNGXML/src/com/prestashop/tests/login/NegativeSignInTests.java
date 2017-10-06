package com.prestashop.tests.login;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.Driver;

public class NegativeSignInTests {
	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setUpTests(String browser) {
		driver = Driver.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		HomePage homePage = new HomePage(driver);
		homePage.signInLink.click();

	}

	@Test
	public void wrongCredentialsTest() {

		SignInPage signinPage = new SignInPage(driver);
		signinPage.emailSignIn.sendKeys("alkjfskg@gmail.com");
		signinPage.password.sendKeys("wrongpassword");
		signinPage.signinButton.click();

		assertTrue(driver.findElement(By.xpath("//li[.=\"Authentication failed.\"]")).isDisplayed());
		// li[.='Authentication failed.'] --> any li tag that has the exact text
		// "Athentication failed."

	}

	@AfterMethod
	public void closeTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void invalidPassword() {
		// verify using valid email and invalid password
		SignInPage signInPage = new SignInPage(driver);
		signInPage.emailSignIn.sendKeys("testuserone@ipdeer.com");
		signInPage.password.sendKeys("different password");
		signInPage.signinButton.click();

		assertTrue(driver.findElement(By.xpath("//li[.=\"Authentication failed.\"]")).isDisplayed());

	}

	@Test
	public void invalidEmail() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.emailSignIn.sendKeys("invalidemail@mail.com");
		signInPage.password.sendKeys("password");
		signInPage.signinButton.click();

		assertTrue(driver.findElement(By.xpath("//li[.=\"Authentication failed.\"]")).isDisplayed());

	}

	@Test
	public void noEmailTest() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.password.sendKeys("password");
		signInPage.signinButton.click();
		assertTrue(driver.findElement(By.xpath("//li[.=\"An email address required.\"]")).isDisplayed());
	}

	@Test
	public void noPasswordTest() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.emailSignIn.sendKeys("testuserone@ipdeer.com");
		signInPage.signinButton.click();
		assertTrue(driver.findElement(By.xpath("//li[.=\"Password is required.\"]")).isDisplayed());
	}

}
