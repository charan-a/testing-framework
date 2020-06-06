package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions (
		features = {"src/test/java/featurefiles/"},
		glue = {"pages"},
		strict = true,
		monochrome = true
		//tags = {}
		//plugin = {"pretty", "html:target/cucumber","json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
		) 

public class Mainrunner {

}
