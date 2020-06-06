package steps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.Before;
import util.Gestures;


public class Hooks extends Gestures {

	private Gestures act;
    public Hooks(Gestures act) {
        this.act = act;
    }
	
    @Before
    public void start() throws MalformedURLException, InterruptedException {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("deviceName", "Android Device");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        act.androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    System.out.println("App Opened");
	    act.androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //Thread.sleep(10000);
	    
    }
    
   // @After
    public void end() {
    	act.androidDriver.quit();
    }
    
}
