Feature: Switching  to windows and closing

@reg1
Scenario: Switching  to windows and closing
Given url is loaded  print the url
Then verify the title of main window
And  find the number of windows  available with main window
Then print the title of each window  and  close the child windows  
Then switch to parent window
