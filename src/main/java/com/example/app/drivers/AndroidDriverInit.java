package com.example.app.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class AndroidDriverInit {

    public static AndroidDriver<AndroidElement> driver;
   

    public static void initialize(){
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        String username = environmentVariables.getProperty("lt.user");
        String accesskey = environmentVariables.getProperty("lt.accessKey");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", environmentVariables.getProperty("platformName"));
        caps.setCapability("platformVersion", environmentVariables.getProperty("platformVersion"));
        caps.setCapability("deviceName", environmentVariables.getProperty("deviceName"));
        caps.setCapability("isRealMobile", environmentVariables.getProperty("isRealMobile"));
        caps.setCapability("app", environmentVariables.getProperty("app"));


        try {
            driver = new AndroidDriver<AndroidElement>(new URL("https://"+username+ ":"+accesskey+"@mobile-hub.lambdatest.com/wd/hub"), caps);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    public static void quit(){
        driver.quit();
    }

}
