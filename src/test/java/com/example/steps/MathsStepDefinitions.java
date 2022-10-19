package com.example.steps;

import com.example.app.pages.MyTaskPage;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.app.Calculator;

public class MathsStepDefinitions {

    int a = 0;
    int b = 0;
    int total = 0;

    MyTaskPage myTaskPage = new MyTaskPage();
    Calculator calculator = new Calculator();

    @Given("a is {int}")
    public void givenAIs(int value) {
        a = value;
    }

    @Given("b is {int}")
    public void givenBIs(int value) {
        b = value;
    }

    @When("I add a and b")
    public void iAddAAndB() {
        total = calculator.add(a,b);
    }

    @Then("the total should be {int}")
    public void theTotalShouldBe(int expectedTotal) {
        assertThat(total).isEqualTo(expectedTotal);
    }

    @Given("I click add button")
    public void iClickAddButton() {
        myTaskPage.clickButtonAdd();
    }

    @When("I input task title and task content")
    public void iInputTaskTitleAndTaskContent() {
        myTaskPage.inputTaskTitle("belajar");
        myTaskPage.inputTaskContent("belajar yok");
    }

    @And("I click save button")
    public void iClickSaveButton() {
        myTaskPage.clickButtonSave();
    }

    @Then("my task added successfully")
    public void myTaskAddedSuccessfully() {
        myTaskPage.verifyTaskTitleDisplayed();
        myTaskPage.verifyTaskTitleEqual();
    }

    @When("I input null title and null content")
    public void iInputNullTitleAndNullContent() {
        myTaskPage.inputTaskTitle("");
        myTaskPage.inputTaskContent("");
    }

    @Then("I verify the error message")
    public void iVerifyTheErrorMessage() {
        myTaskPage.verifyErorrMessageDisplayed();
    }

    @When("I input task {string} and task {string}")
    public void iInputTaskAndTask(String title, String content) {
        myTaskPage.inputTaskTitle(title);
        myTaskPage.inputTaskContent(content);
    }

    @Then("my task added {string}")
    public void myTaskAdded(String result) {
        if (result.equals("success")){
            myTaskPage.verifyTaskTitleDisplayed();
            myTaskPage.verifyTaskTitleEqual();
        } else {
            myTaskPage.verifyErorrMessageDisplayed();
        }
    }
}
