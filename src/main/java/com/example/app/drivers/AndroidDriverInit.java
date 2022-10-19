package com.example.app.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverInit {

    public static AndroidDriver<AndroidElement> driver;

    public static void initialize(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("deviceName", "Galaxy S10");
        caps.setCapability("isRealMobile", true);
        caps.setCapability("app", "lt://");

        try {
            driver = new AndroidDriver<AndroidElement>(new URL("https://username:AccessKey@mobile-hub.lambdatest.com/wd/hub"), caps);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    public static void quit(){
        driver.quit();
    }

}
