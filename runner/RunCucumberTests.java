package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefs.SalesforceSpecificMethods;

@CucumberOptions(features="src/test/java/feature/CreateNewDashboard.feature",
				glue={"stepDefs",/*"hooks"*/},
				//tags="@smoke",
				monochrome=true,
				publish=true)

public class RunCucumberTests extends SalesforceSpecificMethods {

}
