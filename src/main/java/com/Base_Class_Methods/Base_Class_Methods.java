package com.Base_Class_Methods;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class_Methods {

	public static WebDriver driver;

	public static WebDriver browserLaunch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");

			driver = new FirefoxDriver();
		} else {
			System.out.println("Trying to Launch Invalid Browser");
		}
		return driver;
	}

	public static void geturl(String url) {
		driver.get(url);
	}

	public static void gettitle() {
		driver.getTitle();
	}

	public static void currenturl() {
		driver.getCurrentUrl();
	}

	public static void gettext(WebElement value) {
		value.getText();
	}

	public static void imwait(int iw) {
		driver.manage().timeouts().implicitlyWait(iw, TimeUnit.SECONDS);
	}

	public static void maxwindow() {
		driver.manage().window().maximize();
	}

	public static void thesleep(int t) throws InterruptedException {
		Thread.sleep(t);
	}

	public static void passinput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void navigate(String url) {
		driver.navigate().to(url);
	}

	public static void back() {
		driver.navigate().back();
	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void isenabled(WebElement ie) {
		boolean enabled = ie.isEnabled();
		System.out.println(enabled);
	}

	public static void isselect(WebElement is) {
		boolean selected = is.isSelected();
		System.out.println(selected);
	}

	public static void isdisplay(WebElement id) {
		boolean displayed = id.isDisplayed();
		System.out.println(displayed);
	}

	public static void getattribute(WebElement atr, String value) {
		atr.getAttribute(value);
	}

	public static void scannermethod() {
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the Input");
		String value = S.next();
		System.out.println(value);
	}

	public static void screenshot(String imagename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File(
				"C:\\Users\\Athiruban\\eclipse-workspace\\Maven_Project\\Screenshots\\" + imagename + ".png");
		FileUtils.copyFile(src, Dest);
	}

	public static void radio(WebElement r) {
		r.click();
	}

	public static void checkbox(WebElement refname) {
		refname.click();
	}

	public static void dropdown(WebElement ref, String type, String value) {
		Select s = new Select(ref);

		if (type.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
		} else if (type.equalsIgnoreCase("values")) {
			s.selectByValue(value);
		} else if (type.equalsIgnoreCase("vtext")) {
			s.selectByVisibleText(value);
		} else {
			System.out.println("Invalid selection of dropdown");
		}
	}

	public static void multidropdown(WebElement ref, String type, String value) {
		Select s = new Select(ref);

		if (s.isMultiple() == true) {
			if (type.equalsIgnoreCase("index")) {
				int parseInt = Integer.parseInt(value);
				s.selectByIndex(parseInt);
			} else if (type.equalsIgnoreCase("values")) {
				s.selectByValue(value);
			} else if (type.equalsIgnoreCase("vtext")) {
				s.selectByVisibleText(value);
			}
		} else {
			System.out.println("This is not multiple dropdown");
		}
	}

	public static void multidroptions(WebElement ref, String options) {
		Select s = new Select(ref);

		if (options.equalsIgnoreCase("getoptions")) {
			List<WebElement> getopt = s.getOptions();
			for (WebElement opttext : getopt) {
				System.out.println(opttext.getText());
			}
		} else if (options.equalsIgnoreCase("allselectedoptions")) {
			List<WebElement> alloptions = s.getAllSelectedOptions();
			for (WebElement alltext : alloptions) {
				System.out.println(alltext.getText());
			}
		} else if (options.equalsIgnoreCase("firstselectedoption")) {
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
		}
	}

	public static void alert(String value) {
		if (value.equals("Ok")) {
			driver.switchTo().alert().accept();
		} else if (value.equalsIgnoreCase("Cancel")) {
			driver.switchTo().alert().dismiss();
		} else {
			System.out.println("No Alert Present");
		}
	}

	public static void proalert(String input, String value) {
		driver.switchTo().alert().sendKeys(input);
		if (value.equals("Ok")) {
			driver.switchTo().alert().accept();
		} else if (value.equalsIgnoreCase("Cancel")) {
			driver.switchTo().alert().dismiss();
		} else {
			System.out.println("No Alert Present");
		}
	}

	public static void actions(String type, WebElement refname) {
		Actions act = new Actions(driver);

		if (type.equalsIgnoreCase("click")) {
			act.click(refname).build().perform();
		} else if (type.equalsIgnoreCase("move")) {
			act.moveToElement(refname).build().perform();
		} else if (type.equalsIgnoreCase("hold")) {
			act.clickAndHold().build().perform();
		} else if (type.equalsIgnoreCase("release")) {
			act.release(refname).build().perform();
		} else if (type.equalsIgnoreCase("rightclick")) {
			act.contextClick(refname).build().perform();
		} else if (type.equalsIgnoreCase("doubleclick")) {
			act.contextClick(refname).build().perform();
		}
	}

	public static void dragdrop(WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest);
	}

	public static void scrollupdown(String type, WebElement refname) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (type.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollBy(0,4500);");
		} else if (type.equalsIgnoreCase("up")) {
			js.executeScript("window.scrollBy(0,-4500);");
		} else if (type.equalsIgnoreCase("intoview")) {
			js.executeScript("arguments[0].scrollIntoView();", refname);

		}
	}

	public static void frames(String type, String value, WebElement refname) {
		if (type.equalsIgnoreCase("index")) {
			driver.switchTo().frame(value);
		} else if (type.equalsIgnoreCase("id")) {
			driver.switchTo().frame(value);
		} else if (type.equalsIgnoreCase("Webrefname")) {
			driver.switchTo().frame(refname);
		} else {
			driver.switchTo().defaultContent();
		}
	}

	public static void robot(String keytype, int keycode) throws AWTException {
		Robot r = new Robot();

		if (keytype.equalsIgnoreCase("press")) {
			r.keyPress(keycode);
		} else if (keytype.equalsIgnoreCase("release")) {
			r.keyRelease(keycode);
		}
	}

	public static void windowhandle(String type) {
		if (type.equalsIgnoreCase("single")) {
			String wh = driver.getWindowHandle();
			String title = driver.switchTo().window(wh).getTitle();
			System.out.println("Currently in a window " + title);
		} else if (type.equalsIgnoreCase("multiple")) {
			Set<String> whs = driver.getWindowHandles();
			for (String windows : whs) {
				String title1 = driver.switchTo().window(windows).getTitle();
				System.out.println("Title of the Window " + title1);
			}
		}
	}

}
