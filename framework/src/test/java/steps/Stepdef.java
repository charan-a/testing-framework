package steps;


import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Gestures;


public class Stepdef extends Gestures{
	
	private Gestures act;
    public Stepdef(Gestures act) {
        this.act = act;
    }
	
	@When("User clicks on {string}")
	public void user_clicks_on(String string) throws Exception {
		act.tapByElement(string);
	}
	@And("User enters {string} as {string}")
	public void user_enters_as(String name, String path) throws Exception {
		act.passvalues(name, path);
	}

	@And("User enters {string}")
	public void user_enters(String string, io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		String s = data.get(1).get(1);
		act.passvalues(s , string);
	}


	@Then("User is Navigated to home page")
	public void user_is_Navigated_to_home_page() {
	    System.out.println("User is Navigated to home page");
	}
	
	@When("User scroll by {string}")
	public void user_scroll_by(String path) throws Exception {
		act.scrolltotext(path);
	}
	
	@And("User scroll from {string} to {string}")
	public void user_scroll_from_to(String string, String string2) throws Exception {
		//act.scrollfromto(string,string2);
		
	}
	@And("User swipes from {string} to {string}")
	public void user_swipes_from_to(String from, String to) {
	   act.swipefromto(from, to);
	}
	@And("user drag from {string} to {string}")
	public void user_drag_from_to(String from, String to) {
	    act.draganddrop(from, to);
	}
}
