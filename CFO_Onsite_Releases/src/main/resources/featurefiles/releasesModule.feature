Feature: To test the Releases module
	
	@checkReleases
	Scenario: Add and check release details
		Given Navigate to project site
		Then Select Releases option
		And Click add Release 
		Then Add Release details
		And Capture Id and navigate back to Releases page
		Then create new release
		And Handle alert for the mandatory fields