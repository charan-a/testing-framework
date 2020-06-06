package pages;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import util.Gestures;

public class products_page {
	private Gestures act;
    public products_page(Gestures act) {
        this.act = act;
    }
    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String string) {
        act.isdisplayped(string);
    }
    //
    @And("{string} items {string}")
    public void items(String string, String string2) throws IOException {
    	act.additems(string, string2);
    }

	
}
