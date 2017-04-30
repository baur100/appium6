package org.megaprint;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.security.krb5.internal.crypto.Des;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Baurz on 4/20/2017.
 */
public class MusicAppTest {

    AndroidDriver<AndroidElement> driver;
    @BeforeMethod
    public void init() throws MalformedURLException {
        File path=new File("data");
        File file=new File(path,"Raaga.apk");
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Demo");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        cap.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        driver=new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),cap);
    }
    @Test
    public void test1(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.raaga.android:id/skip_text").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.raaga.android:id/landing_skip_to_raaga").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.raaga.android:id/music_home_raaga_live\"));").click();
        driver.findElementById("com.raaga.android:id/toolbar_logo").click();
        driver.findElementById("com.raaga.android:id/menu_settings_btn").click();
        driver.findElementById("com.raaga.android:id/app_push").click();
        TouchAction t=new TouchAction(driver);
        Point point=driver.findElementById("com.raaga.android:id/toggle_notifyrecommend").getLocation();
//        t.press(point.x+20,point.y+20).moveTo(point.x+30,point.y+20).release().perform();
        t.tap(point.x+20,point.y+30).perform();

    }



}
