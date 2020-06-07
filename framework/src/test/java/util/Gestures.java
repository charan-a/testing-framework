package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static java.time.Duration.ofSeconds;
import static java.time.Duration.ofMillis;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

		
public class Gestures {
	protected static AndroidDriver<AndroidElement> androidDriver;
    //public Read_Yml reader = new Read_Yml();
	public Reader reader = new Reader();
    private Gestures act;
    
    
    public void getWebContext() {
	    ArrayList<String> contexts = new ArrayList(androidDriver.getContextHandles());
	    for (String context : contexts) {
	    	System.out.println("context is " + context);
	        if (!context.equals("NATIVE_APP")) {
	            androidDriver.context(context);
	            break;
	        }
	    }
	}
    
	public void tapByElement(String obj) throws Exception {
        try {
        	AndroidElement androidElement = androidDriver.findElement(By.xpath(reader.getXpath(obj)));
        	new TouchAction(this.androidDriver)
            .tap(tapOptions().withElement(element(androidElement)))
            .waitAction(waitOptions(Duration.ofMillis(650))).perform();
        	act.androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(obj);
            System.out.println(e);
        }
        
    }  
	
	
	public void passvalues(String value ,String path) {
		try {
			AndroidElement androidElement = androidDriver.findElement(By.xpath(reader.getXpath(path)));
			androidElement.sendKeys(value);
			act.androidDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		}catch(Exception e) {
			System.out.println(path);
            System.out.println(e);
		}
	}
	
	
	public void scrollto(String path) throws Exception {
		boolean flag = true;
		while(flag) {
		try {
			act.androidDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			androidDriver.findElement(By.xpath(reader.getXpath(path))).isDisplayed();
			flag = false;
			break;
		}catch (Exception e){
			act.swipeVertical( 0.8, 0.2, 0.5, 2000);
			}
	    }
	}
	
	
	public static void swipeVertical( double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
        Dimension size = androidDriver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * finalPercentage);
        new TouchAction(androidDriver).press(PointOption.point(anchor, startPoint) ).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)) ).moveTo(PointOption.point(anchor, endPoint)).release().perform();
    }
	
	
	public void swipefromto(String from,String to) {
		try {
		TouchAction action=new TouchAction(androidDriver);
		AndroidElement first = androidDriver.findElement(By.xpath(reader.getXpath(from)));
		AndroidElement second = androidDriver.findElement(By.xpath(reader.getXpath(to)));
		action.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
	}catch(Exception e) {
		System.out.println(from + to);
        System.out.println(e);
	}
	}
	
	public void draganddrop(String from,String to) {
		try {
		TouchAction action=new TouchAction(androidDriver);
		AndroidElement first = androidDriver.findElement(By.xpath(reader.getXpath(from)));
		AndroidElement second = androidDriver.findElement(By.xpath(reader.getXpath(to)));
		action.longPress(element(first)).moveTo(element(second)).release().perform();
	}catch(Exception e) {
		System.out.println(from + to);
        System.out.println(e);
		}
	}
	
	public void longPress(String path) {
		try {
		TouchAction action=new TouchAction(androidDriver);
		AndroidElement obj = androidDriver.findElement(By.xpath(reader.getXpath(path)));
		action.longPress(longPressOptions().withElement(element(obj)).withDuration(ofSeconds(2))).release().perform();
		}catch(Exception e) {
			System.out.println(path);
	        System.out.println(e);
		}
	}
		
	
	public void scrollandclick(String text) {
		try {
			AndroidElement androidElement = androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
			androidElement.click();
		}catch(Exception e) {
			System.out.println(text);
	        System.out.println(e);
			}
		}
	public void homeback() {
		try {
			//((AndroidDriver) androidDriver).pressKeyCode(AndroidKeyCode.BACK);
			androidDriver.navigate().back();
			
		}catch(Exception e) {
	        System.out.println(e);
			}
		}
	public void additems(String string, String string2) throws IOException {
		int i=Integer.parseInt(string2);
		AndroidElement first = androidDriver.findElements(By.xpath(reader.getXpath(string))).get(i);
		first.click();
		
	}
	public void isdisplayped(String path) {
		try {
			androidDriver.findElement(By.xpath(reader.getXpath(path))).isDisplayed();
		}catch(Exception e) {
			System.out.println(path);
			System.out.println(e);
		}
	}
}
	
   
	
	
	
	

