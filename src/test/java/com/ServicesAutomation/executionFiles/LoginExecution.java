package com.ServicesAutomation.executionFiles;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "classpath:com/ServicesAutomation/features/TestLogin.feature", glue = "classpath:com.ServicesAutomation.StepDefination")

public class LoginExecution extends AbstractTestNGCucumberTests{

}