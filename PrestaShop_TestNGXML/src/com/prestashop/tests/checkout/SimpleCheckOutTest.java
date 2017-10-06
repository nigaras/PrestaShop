package com.prestashop.tests.checkout;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ProductInformationPage;
import com.prestashop.utilities.Driver;

public class SimpleCheckOutTest {
	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setUpTests(String browser) {
		driver = Driver.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void simpleCheckOutTest() {
		String product = "Faded Short Sleeve T-shirts";
		HomePage homePage = new HomePage(driver);
		homePage.getProduct(product).click();

		ProductInformationPage productInformationPage = new ProductInformationPage(driver);
		assertEquals(productInformationPage.productName.getText(), product);
		assertEquals(productInformationPage.quantity.getAttribute("value"), "1");
		assertEquals(productInformationPage.selectedSize.getText(), "S");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
