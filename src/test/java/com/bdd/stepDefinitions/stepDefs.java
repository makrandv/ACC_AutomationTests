package com.bdd.stepDefinitions;

import helperFunctions.webDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static helperFunctions.webDriverUtils.webDriver;

public class stepDefs {

    List<WebElement> optionList;
    WebDriverWait wait;

    //ToDo remove hardcoding of URL
    String launchURL = "https://www.trademe.co.nz/a/motors";

    @Given("^User visits TradeMe Motors Search webpage for \"(.*)\"$")
    public void user_visits_trade_me_motors_search_webpage(String motorType) throws InterruptedException {
        webDriverUtils.setupDriver();
        webDriver.get(launchURL);
        WebElement vehicleTab = webDriver.findElement(By.cssSelector("tg-icon[name='vehicle-"+motorType+"']"));
        vehicleTab.click();
    }

    @When("^User clicks on \"(.*)\" dropdown$")
    public void user_clicks_on_filter_dropdown_for_cars_tabs(String selectionCriteria) {

        WebElement makeDropDown = webDriver.findElement(By.cssSelector("tg-select-container[label='" + selectionCriteria + "']> :nth-child(2) select"));
        makeDropDown.click();
        optionList = makeDropDown.findElements(By.cssSelector("option"));

    }

    @Then("^User is able to get \"(.*)\" of options in the \"(.*)\" dropdown$")
    public void user_is_able_to_get_of_items_in_the_dropdown(String expectedCount,String filter) {
        Assert.assertEquals(optionList.size(), Integer.valueOf(expectedCount));
    }

    @When("^User searches \"(.*)\" with \"(.*)\" as \"(.*)\"$")
    public void searches_cars_using_specific_brand(String vehicleType,String filter,String filterOption) {

        Select filterDropDown = new Select(webDriver.findElement(By.cssSelector("tg-select-container[label='"+filter+"']> :nth-child(2) select")));
        filterDropDown.selectByVisibleText(filterOption);
        WebElement searchButton = webDriver.findElement(By.cssSelector("button[type='submit']"));
        searchButton.click();
    }

    @Then("^User is shown the \"(.*)\" \"(.*)\" with \"(.*)\" as \"(.*)\"$")
    public void user_is_able_to_get_of_cars_shown_on_page(String count,String vehicleType,String filter,String filterOption) {

        wait=new WebDriverWait(webDriver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.p-h2")));
        WebElement displayedCount = webDriver.findElement(By.cssSelector("h3.tm-search-header-result-count__heading"));
        Assert.assertTrue(displayedCount.getText().replace(",","").contains("Showing "+ count +" results"));
        webDriver.close();
    }

    @Given("^User access the \"(.*)\" search page$")
    public void user_access_motorType_search_page(String vehicleType) throws InterruptedException {
        webDriverUtils.setupDriver();
        webDriver.get(launchURL+"/"+vehicleType);
    }

    @When("^User clicks on \"(.*)\" from available filters$")
    public void user_clicks_on_avaliable_filter(String filterName)
    {
        wait=new WebDriverWait(webDriver, Duration.ofSeconds(100));
        String filterButton = "//button[contains(text(),'"+filterName+"')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterButton)));
        WebElement filter= webDriver.findElement(By.xpath(filterButton));
        filter.click();
    }

    @And("^selects \"(.*)\" from available list$")
    public void selects_filterOption_from_avaliable_list(String filterOptions)
    {
        WebElement searchText = webDriver.findElement(By.cssSelector("input[name='filter']"));
        searchText.sendKeys(filterOptions);
        WebElement enteredFilterOption = webDriver.findElement(By.xpath(".//span[contains(text(),'"+filterOptions+"')]"));
        enteredFilterOption.click();
    }

    @Then("^Count shown in dropdown pane is same as count shown in page header$")
    public void compare_count_shown_dropdowm_pane_with_page_count()
    {
        wait=new WebDriverWait(webDriver, Duration.ofSeconds(100));

        WebElement dropDownPaneText = webDriver.findElement(By.cssSelector("div.tm-drop-down-tag__dropdown-footer button[type*='button']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
        WebElement headerResultCount = webDriver.findElement(By.cssSelector("h3.tm-search-header-result-count__heading"));
        Assert.assertEquals(dropDownPaneText.getText(),headerResultCount.getText().replace("Showing","View"));
        webDriver.close();
    }
    @After
    public void afterScenario() {
        if(webDriver!=null){
            webDriver.quit();
        }
    }
}

