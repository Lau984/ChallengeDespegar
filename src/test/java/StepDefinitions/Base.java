package StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public WebDriver driver;

	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.despegar.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void SendKeys(By locator, String txt) {
		driver.findElement(locator).sendKeys(txt);
	}

	public boolean isDisplayed(By locator, String element) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(element + " is not displayed");
			return false;
		}

	}

	public void quit_IsNotDisplayed(By locator, String element) {
		try {
			driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(element + " is not displayed");
			driver.quit();
		}

	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void clear(By locator) {
		driver.findElement(locator).clear();
	}

	public void confirmTitle(String expected) {
		assertEquals(expected, driver.getTitle());
	}

	public void confirmTitleContains(String expected) {
		assertThat(driver.getTitle(), containsString(expected));
	}

	public void confirmLink(String expected) {
		assertThat(driver.getCurrentUrl(), containsString(expected));
	}

	public void Quit() {
		driver.quit();
	}

}
