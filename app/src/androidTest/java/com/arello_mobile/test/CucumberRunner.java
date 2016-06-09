package com.arello_mobile.test;
import cucumber.api.CucumberOptions;

@CucumberOptions(features = "features",
		glue = {"com.arello_mobile.test"},
		monochrome = true,
		plugin = {"pretty"} //"html: cucumber-html-reports",
		// "json: cucumber-html-reports/cucumber.json"}
)
public class CucumberRunner
{
}