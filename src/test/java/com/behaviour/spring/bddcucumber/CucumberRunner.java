package com.behaviour.spring.bddcucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        strict = true,
        features = "classpath:features",
        glue = "com.behaviour.spring.bddcucumber.bdd",
        tags = { "@Renewal" },
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber.html",
                "junit:target/cucumber-reports/Cucumber.xml",
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
