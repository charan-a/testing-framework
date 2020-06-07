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
    @Given("User enters {string} with data at {string} {string}")
    public void user_enters_with_data_at(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
    	int i1 = Integer.parseInt(string2);
    	int i2 = Integer.parseInt(string3);
    	List<List<String>> data = dataTable.asLists(String.class);
		String value = data.get(i1).get(i2);
		act.passvalues(value , string);
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
