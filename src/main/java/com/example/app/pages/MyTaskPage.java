package com.example.app.pages;

import com.example.app.base.BasePageObject;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;

public class MyTaskPage extends BasePageObject {

    By textResult(float number){
        return By.xpath("......" + number +"");
    }

    //nyari suatu locator kita pakai xpath yang butuh parameter number / expected result
    //assertion/verify equal -> getText element = number == number

    public void verifyDisplayed(float number){
        Assertions.assertTrue(isDisplayed(textResult(number)));
    }

    By buttonAdd(){
        return By.id("fabMain");
    }
    
    By errorMessage(){
        return By.id("textinput_error");
    }

    By fieldTaskTitle(){
        return By.id("editTextTaskTitle");
    }

    By fieldTaskContent(){
        return By.id("editTextTaskContent");
    }

    By buttonSave(){
        return By.id("buttonApply");
    }

    By taskTitle(){
        return By.id("textViewTaskTitle");
    }

    public void clickButtonAdd(){
        click(buttonAdd());
    }

    public void inputTaskTitle(String input){
        sendKeys(fieldTaskTitle(), input);
    }

    public void inputTaskContent(String input){
        sendKeys(fieldTaskContent(), input);
    }

    public void clickButtonSave(){
        click(buttonSave());
    }

    public void verifyTaskTitleDisplayed(){
        Assertions.assertTrue(find(taskTitle()).isDisplayed());
    }

    public void verifyTaskTitleEqual(){
        Assertions.assertEquals("belajar", getText(taskTitle()));
    }

    public void verifyErorrMessageDisplayed() {
        Assertions.assertTrue(isDisplayed(errorMessage()));
    }
}
