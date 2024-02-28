@regression
Feature: Demo Login

  @demo-login-microsoft @smoke @selenium @skip
  Scenario: Verify that user login successfully with valid data
    Given microsoft - user login with valid data
    Then microsoft - verify that user login successfully and user information display correctly

  @demo-login-sony @smoke @selenium
  Scenario Outline: demo login, search product and add product to cart
    # verify that login success fully
    Given sony - user login with valid data
    Then sony - verify that user login successfully and user information display correctly

    When sony - searching "<product_1>"
    And sony - adding "<product_1>" into cart
    And sony - select continue shopping
    And sony - searching "<product_2>"
    And sony - adding "<product_2>" into cart
    And sony - select proceed with payment
    Then sony - verify that products below display into cart
      | <product_1> |
      | <product_2> |

    Examples:
      | product_1                                           | product_2                                           |
      | Tai nghe không dây có công nghệ chống ồn WH-1000XM5 | Ốp lưng phong cách kèm đế chống dành cho Xperia 5 V |