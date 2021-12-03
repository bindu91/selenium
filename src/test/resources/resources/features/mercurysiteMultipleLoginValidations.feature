Feature: Validate login module

  @loginvalidationexamples
  Scenario Outline: validating login features
    #	Given enter '<url>'
    Then enter '<username>'
    And enter '<password>'
    And click on signIn

    #Then select '<role>'
    @test1
    Examples: 
      | username | password |
      | bindu    | bindu    |
      | bindu    | bindu    |

    @test2
    Examples:  
    @sources:src/test/resources/data_tables/temp.csv
      | username | password |
      | mahesh   | mahesh   |
