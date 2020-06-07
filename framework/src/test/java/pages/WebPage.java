package pages;

import io.cucumber.java.en.Then;
import util.Gestures;

public class WebPage {
	private Gestures act;
    public WebPage(Gestures act) {
        this.act = act;
    }
	
	@Then("check whether are we in webview")
	public void check_whether_are_we_in_webview() {
		act.getWebContext();
	}
}
