package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageobjects.FlightStatusPage;

import java.text.SimpleDateFormat;
import java.util.Date;

import static helpers.TestBase.driver;


public class StepDefinitions {

    private final FlightStatusPage fsp = PageFactory.initElements(driver, FlightStatusPage.class);
    private final String todayDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    private final String todayDateCalendarValue = new SimpleDateFormat("yyyy-MM-dd").format(new Date());


    @Given("I'm on the flight website search page")
    public void i_m_on_the_flight_website_search_page() {
        driver.get("https://www.eurowings.com/en/information/at-the-airport/flight-status.html");
        fsp.closeConsentIfDisplayed();
    }


    @When("I select valid {string} departure airport")
    public void i_select_valid_departure_airport(String departure) {
        fsp.selectDeparture(departure);
    }

    @When("I select valid {string} destination airport")
    public void i_select_valid_destination_airport(String destination) {
        fsp.selectDestination(destination);
    }

    @When("I select valid travel date")
    public void i_select_valid_travel_date() {
        fsp.selectDate(todayDateCalendarValue);
    }

    @When("I click Show flight status button")
    public void i_click_show_flight_status_button() {
        fsp.clickSubmit();
    }

    @Then("A table with flight status should be displayed")
    public void a_table_with_flight_status_should_be_displayed() {
        String berlinAirport = "BER";
        String cologneBonAirpoty = "CGN";
        fsp.verifyFlightRoutesStatuses(cologneBonAirpoty, berlinAirport, todayDate.substring(0, todayDate.length() - 5));
    }

    @Then("Search button is not available")
    public void search_button_is_not_available() {
        fsp.verifySubmitButtonEnabled(false);
    }

    @Then("A table with no result should be displayed and equals to {string}")
    public void aTableWithNoResultShouldBeDisplayedAndEqualsTo(String error) {
        fsp.verifyNoResultFoundText(error);
    }
}