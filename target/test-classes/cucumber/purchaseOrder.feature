
@tag
Feature: Purchase the order from E-commerce
  I want to use this template for my feature file

Background:
Given I landed on e-commerce page

  @tag2
  Scenario Outline: positive test of submitting the order
    Given I logged in with username <name> and password <Password>
    When I add the product <productName> to cart
    And checkout <productName> and submit the order.
    Then confirmation message "THANKYOU FOR THE ORDER." is displayed. 

    Examples: 
      | name                   | Password   |productName     |
      | meghanauday76@gmail.com| Meghana@10 | ADIDAS ORIGINAL |
      
