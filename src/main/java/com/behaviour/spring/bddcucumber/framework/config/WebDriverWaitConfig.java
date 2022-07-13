package com.behaviour.spring.bddcucumber.framework.config;


import com.behaviour.spring.bddcucumber.framework.annotation.LazyConfiguration;
import com.behaviour.spring.bddcucumber.framework.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@LazyConfiguration
public class WebDriverWaitConfig {

    @Value(FrameworkConstants.DEFAULT_TIMEOUT)
    private int timeout;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriverWait webdriverWait(WebDriver driver){
        return new WebDriverWait(driver, this.timeout);
    }

}
