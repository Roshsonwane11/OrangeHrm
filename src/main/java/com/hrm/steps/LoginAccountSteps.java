package com.hrm.steps;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.hrm.base.Keyword;
import com.hrm.pages.LoginAccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class LoginAccountSteps {
	@When("User navigates to url the login page should be loaded properly")
	public void navigatesToLoginPage() {
		LoginAccountPage loginAccountPage = new LoginAccountPage();
		loginAccountPage.OpenUrl();
	}

	@When("The user enters Valid username and password then user should be redirected to the dashboard page")
	public void enterValidCredentials() throws InterruptedException {
		LoginAccountPage loginAccountPage = new LoginAccountPage();
		loginAccountPage.enterValidCredentials();
		Assert.assertTrue(Keyword.driver.getCurrentUrl()
				.contains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));

	}

	@When("The user enters InValid {string} and {string} then user should NOT able to login.")
	public void enterInvalidCredentials(String username, String password) {
		LoginAccountPage loginAccountPage = new LoginAccountPage();
		loginAccountPage.enterInvalidCredentials(username, password);

	}
	
	@When("The user enters {} username and {} password then user should NOT able to login.")
	public void enterNULLCredentials(String username, String password) {
		LoginAccountPage loginAccountPage = new LoginAccountPage();
		loginAccountPage.enterNULLCredentials(username, password);
		
	}
	
	@When("The user enters Invalid credentials then user should NOT able to login")
	public void enterInvalidCredentialUsingDatatable(DataTable dataTable) {
		LoginAccountPage loginAccountPage = new LoginAccountPage();

        List<Map<String, String>> credentialsList = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> credentials : credentialsList) {
            String username1 = credentials.get("username");
            String password1 = credentials.get("password");
            loginAccountPage.enterInvalidCredentialsuisngDataTable(username1, password1);
            
        }

	}
	

}
