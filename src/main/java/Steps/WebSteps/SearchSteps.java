package Steps.WebSteps;

import Pages.SonyDemo.SonyHomePage;
import io.cucumber.java.en.When;

public class SearchSteps {
    @When("sony - searching {string}")
    public void searching(String condition) {
        SonyHomePage sonyHomePage = new SonyHomePage();
        sonyHomePage.globalSearching(condition);
    }
}
