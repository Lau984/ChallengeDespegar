package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import StepDefinitions.Base;

public class ObjectsPage {
	By searchBoxFlights = By.id("searchbox-sbox-box-flights");
	By dropdownLocationLoc = By.id("eva-country");
	By locationColombiaLoc = By.xpath("//option[@value='//www.despegar.com.co/']");
	By oneWayOptionLoc = By.xpath("//input[@value='oneWay']//parent::label//i[@class='radio-circle']");
	By txtBoxOriginLoc = By
			.xpath("//span[contains(text(),'Tramo 1')]//parent::div//input[@placeholder='Ingresa desde dónde viajas']");
	By optionMedellinLoc = By.xpath("//span[contains(text(),'Medellín')]");
	By txtBoxDestinationLoc = By
			.xpath("//span[contains(text(),'Tramo 1')]//parent::div//input[@placeholder='Ingresa hacia dónde viajas']");
	By optionBogotaLoc = By.xpath("//em[contains(text(), 'Bogotá')]//ancestor::li");
	By txtBoxDateLoc = By.xpath(
			"//span[contains(text(),'Tramo 1')]//parent::div//input[@placeholder='Ida']//parent::div//parent::div");
	By tomorrowDateLoc = By.xpath(
			"(//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-datenumber -today']//following-sibling::div)[2]");
	By btnSearchLoc = By.xpath("//em[contains(text(),'Buscar')]//ancestor::button");
	By btnSelectLoc = By.xpath("(//buy-button//a)[1]");
	By btnContinueLoc = By.xpath("//em[contains(text(), 'Continuar')]//ancestor::button");
	By checkOutContentLoc = By.xpath("//form[@id='checkout-content']");
	By payment_component = By.xpath("//payment-component");

	WebDriver driver;

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

	Base base = new Base(chromeDriverConnection());

	public void langAndLocation() {
		base.click(dropdownLocationLoc);
		base.click(locationColombiaLoc);
	}

	public void inicialPageIsDisplayed() {

		base.quit_IsNotDisplayed(searchBoxFlights, "Despegar.com");
		base.confirmLink("despegar.com");
		base.confirmTitleContains("Despegar");
	}

	public void fillInfomation() {

		base.click(oneWayOptionLoc);
		base.click(txtBoxOriginLoc);
		base.SendKeys(txtBoxOriginLoc, " Med");
		base.click(txtBoxOriginLoc);
		base.click(optionMedellinLoc);
		base.click(txtBoxDestinationLoc);
		base.clear(txtBoxOriginLoc);
		base.SendKeys(txtBoxDestinationLoc, " Bog");
		base.click(optionBogotaLoc);
		base.isDisplayed(txtBoxDateLoc, "Textbox for Date");
		base.click(txtBoxDateLoc);
		Thread();
		base.quit_IsNotDisplayed(tomorrowDateLoc, "Calendar");
		base.click(tomorrowDateLoc);

	}

	public void findAndBuyTicket() {

		base.click(btnSearchLoc);
		if (base.isDisplayed(btnContinueLoc, "Modal for add bags")) {
			base.click(btnContinueLoc);
		}
		base.quit_IsNotDisplayed(btnSelectLoc, "Tickets options");
		base.click(btnSelectLoc);

	}

	public void finalValidation() {
		base.quit_IsNotDisplayed(checkOutContentLoc, "Check out content");
	}

	public void Quit() {
		System.out.println("Finished");
		base.Quit();
	}

	public ObjectsPage(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void Thread() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
		}
	}

}
