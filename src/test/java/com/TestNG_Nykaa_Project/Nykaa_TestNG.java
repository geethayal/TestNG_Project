package com.TestNG_Nykaa_Project;

import java.io.IOException;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.Base_Class_Methods.Base_Class_Methods;

public class Nykaa_TestNG extends Base_Class_Methods {

	@Test(priority = 0)

	public void browserlaunch() {
		browserLaunch("chrome");
	}

	@Test(priority = 1)
	public void urllaunch() {
		geturl("https://www.nykaa.com/");
		maxwindow();
		imwait(30);
	}

//==================================1. Login Page=================================

	@Test(priority = 2)
	public void signIn() throws InterruptedException {

		WebElement SignIn = driver.findElement(By.xpath("//button[@aria-label='Kebab menu']"));
		actions("move", SignIn);
		click(SignIn);
	}

	@Test(priority = 3)
	public void verify_Login() throws InterruptedException {

		WebElement SignWith = driver.findElement(By.xpath("(//button[@kind='secondary'])[1]"));
		actions("move", SignWith);
		click(SignWith);

		WebElement MobileNo = driver.findElement(By.xpath("//input[@name='emailMobile']"));
		passinput(MobileNo, "9787349755");

		WebElement Proceed = driver.findElement(By.id("submitVerification"));
		click(Proceed);

		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the Input");
		String otp = S.next();

		thesleep(2000);
		WebElement otp1 = driver.findElement(By.xpath("//input[@type='number']"));
		passinput(otp1, otp);

		WebElement Verify = driver.findElement(By.xpath("//button[@type='submit']"));
		click(Verify);
	}

//=================================2. Select the Product============================
	@Test(priority = 4)

	public void select_Product() {

		WebElement MakeUp = driver.findElement(By.xpath("(//a[text()='makeup'])[2]"));
		actions("move", MakeUp);

		WebElement LipLiner = driver.findElement(By.xpath("//a[text()='Lip Liner']"));
		actions("move", LipLiner);
		click(LipLiner);

		windowhandle("multiple");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

		WebElement TilburyLip = driver.findElement(By.xpath("//div[text()='Charlotte Tilbury Lip Cheat']"));
		actions("move", TilburyLip);
		click(TilburyLip);

		windowhandle("multiple");

		WebElement LipShades = driver.findElement(By.xpath("//img[contains(@alt,'Crazy In Love-shade')]"));
		actions("move", LipShades);
		click(LipShades);

		js.executeScript("window.scrollBy(0,250)");

		WebElement Add2Bag = driver.findElement(By.xpath("(//button[@class=' css-1qvy369'])[1]"));
		click(Add2Bag);
	}

//	===========================3. Add to Cart==========================
	@Test(dependsOnMethods = "select_Product")

	public void add_To_Cart() throws InterruptedException {

		WebElement Cart = driver.findElement(By.xpath("//span[@class='cart-count']"));
		actions("move", Cart);
		click(Cart);

		WebElement Frame1 = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		frames("webrefname", null, Frame1);

		thesleep(500);
		WebElement Proceed1 = driver.findElement(By.xpath("(//button[@class='css-1j2bj5f e8tshxd0'])[2]"));
		click(Proceed1);
	}

	// ============================4. Add Address==========================
	@Test(dependsOnMethods = "add_To_Cart")

	public void add_Address() throws InterruptedException {

		WebElement addadress = driver.findElement(By.xpath("//div[@class='css-1pan5g8 e1gecm6x0']"));
		actions("move", addadress);
		click(addadress);

		thesleep(1000);

		WebElement FlatNo = driver.findElement(By.xpath("//input[@placeholder='House/ Flat/ Office No.']"));
		actions("move", FlatNo);
		click(FlatNo);
		passinput(FlatNo, "5/92");

		thesleep(500);

		WebElement RoadName = driver.findElement(By.xpath("//textarea[@placeholder='Road Name/ Area /Colony']"));
		actions("move", RoadName);
		click(RoadName);
		passinput(RoadName, "Mettu Street");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 9000)");

		thesleep(500);

		WebElement Name1 = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		actions("move", Name1);
		click(Name1);
		passinput(Name1, "Sangeetha");

		thesleep(500);
		WebElement PhoneNo = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
		actions("move", PhoneNo);
		click(PhoneNo);
		passinput(PhoneNo, "9787349755");

		thesleep(500);
		WebElement EmailId = driver.findElement(By.xpath("//input[@placeholder='Email ID (Optional)']"));
		actions("move", EmailId);
		click(EmailId);
		passinput(EmailId, "geethayal@gmail.com");

		js.executeScript("window.scrollBy(0, -9000)");

		thesleep(500);
		WebElement Pincode1 = driver.findElement(By.xpath("//input[@placeholder='Pincode']"));
		actions("move", Pincode1);
		click(Pincode1);
		passinput(Pincode1, "600023");

		WebElement Ship2Address = driver.findElement(By.xpath("//button[text()='Ship to this address']"));
		click(Ship2Address);

	}

	// ==================================5. Place the
	// Order================================

	@Test(enabled = false)

	public void place_Order() throws IOException {

		WebElement COD = driver.findElement(By.xpath("//p[text()='Cash on delivery']"));
		actions("move", COD);
		click(COD);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-9000)");

		WebElement PlaceOrder = driver.findElement(By.xpath("//button[text()='Place order']"));
		click(PlaceOrder);

		screenshot("OrderPlaced");
	}

//		==================================6.Logout=================================
	@Test(enabled = false)
	public void signOut() {

		WebElement Nykaa = driver.findElement(By.xpath("//span[@class='css-17ukzrr euw1lbv4']"));
		actions("move", Nykaa);

		WebElement Logout = driver.findElement(By.xpath("//button[@class='link css-5wdy92 e4p5vsu0']"));
		actions("move", Logout);
		click(Logout);

		WebElement logout1 = driver.findElement(By.xpath("//span[text()='Logout']"));
		actions("move", logout1);
		click(logout1);
	}

	@Test(priority = 8)
	public void close_Window() {
		close();
	}

	@Test(priority = 9)
	public void quit_Browser() throws InterruptedException {
		quit();
	}

}
