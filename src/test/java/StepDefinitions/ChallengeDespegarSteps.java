package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Pages.ObjectsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChallengeDespegarSteps {

	WebDriver driver;
	ObjectsPage objectsPage = new ObjectsPage(driver);

	@Given("Despegar.com is displayed")
	public void despegar_com_is_displayed() {
		objectsPage.inicialPageIsDisplayed();
	}

	@When("Configure the page")
	public void configure_the_page() {

		objectsPage.langAndLocation();
	}

	@When("Fill fields about destination and date")
	public void fill_fields_about_destination_and_date() {

		objectsPage.fillInfomation();

	}

	@When("Search and select a ticket")
	public void search_and_select_a_ticket() {
		objectsPage.findAndBuyTicket();

	}

	@Then("Check out page is displayed")
	public void check_out_page_is_displayed() {
		objectsPage.finalValidation();
		objectsPage.Quit();

	}

}
