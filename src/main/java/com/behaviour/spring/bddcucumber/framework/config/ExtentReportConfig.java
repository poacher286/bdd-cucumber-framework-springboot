package com.behaviour.spring.bddcucumber.framework.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.behaviour.spring.bddcucumber.framework.annotation.LazyConfiguration;
import com.behaviour.spring.bddcucumber.framework.constants.FrameworkConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.io.File;

@LazyConfiguration
public class ExtentReportConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ExtentReports extentReports(@Value("${report.extent.file}") String extentReportFile) {
        var file = new File(extentReportFile);
        //noinspection ResultOfMethodCallIgnored
        file.getParentFile().mkdirs();

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle(file.getName());
        sparkReporter.config().setEncoding(FrameworkConstants.ENCODING_UTF);
        sparkReporter.config().setReportName(file.getName());

        var extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        return extent;
    }
}
