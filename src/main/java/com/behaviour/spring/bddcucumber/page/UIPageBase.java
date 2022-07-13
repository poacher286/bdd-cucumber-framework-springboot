package com.behaviour.spring.bddcucumber.page;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class UIPageBase {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @Autowired
    protected ExtentReports extentReports;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    public void goTo(String url) {
        this.driver.get(url);
        extentReports.createTest("Test spring boot");
    }

    public abstract boolean isAt();
}
