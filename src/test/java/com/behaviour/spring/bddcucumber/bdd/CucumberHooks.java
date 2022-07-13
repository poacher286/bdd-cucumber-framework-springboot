package com.behaviour.spring.bddcucumber.bdd;

import com.aventstack.extentreports.ExtentReports;
import com.behaviour.spring.bddcucumber.framework.annotation.LazyAutowired;
import com.behaviour.spring.bddcucumber.framework.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()){
            scenario.embed(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario(){
        this.applicationContext.getBean(WebDriver.class).quit();
        this.applicationContext.getBean(ExtentReports.class).flush();
    }

}
