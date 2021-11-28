Feature: Blog Signup
  Anyone can signup on the page,
  except the ones who have already signed-up.

  Scenario: Confirm the title of the Sign-up page
    Given I launch the browser
    When I navigate to blog sign-up page
    Then I verify that title is present
    And I close the browser