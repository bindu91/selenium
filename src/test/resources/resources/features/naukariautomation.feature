Feature:  Multiselect input to text box
@register
Scenario: Multiselect input to text box
Given url is loaded  print the url
Then verify the title of main window
And mousehover on jobs
And click on Advancedsearch jobs 
Then switch to Advancedsearchwindow
And click on keyskills  and select as 'Test Engineer' and 'Testing'
Then type location as 'Chennai'
And  select industry as  'IT-Hardware and Networking' and 'IT-software services' 	 
And  select Job cateogry as 'IT software-All Jobs'
And Click on search job
