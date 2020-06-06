package pages;

import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Gestures;

public class login_page {
	private Gestures act;
    public login_page(Gestures act) {
        this.act = act;
    }
    
    @Given("User in login page")
    public void user_in_login_page() {
        System.out.println("user entered in login page");
    }
    
    @When("User clicks on {string}")
	public void user_clicks_on(String string) throws Exception {
		act.tapByElement(string);
	}
    @And("User scroll to {string} and clicks it")
    public void user_scroll_to_and_clicks_it(String string) {
    	act.scrollandclick(string);
    }
    @And("User enters {string}")
	public void user_enters(String string, io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		String s = data.get(0).get(1);
		act.passvalues(s , string);
	}
    @And("User clicks home back button")
    public void user_clicks_home_back_button() {
    	act.homeback();
    }
    
    @And("User selects the gender")
    public void user_selects_the_gender(io.cucumber.datatable.DataTable dataTable) throws Exception {
    	List<List<String>> data = dataTable.asLists(String.class);
    	String s = data.get(0).get(0);
    	act.tapByElement(s);
    }
    

}
