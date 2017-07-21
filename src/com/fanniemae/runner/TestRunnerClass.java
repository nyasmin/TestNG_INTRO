package com.fanniemae.runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/com/fanniemae/features"},
		glue ={ "com/fanniemae/stepdefination/"},
		plugin = { 
					"pretty",
					"html:target/cucumber-reports",
					"json:target_json/Cucumber.json",
	    	         "junit:target_junit/Cucumber_junit.xml"
				} 
		
		)
public class TestRunnerClass {

}