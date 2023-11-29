# **Project Name:** Selenium scripts for Automation of https://AutomationExercise.com test cases.

## **Website under test:** https://AutomationExercise.com <br>
![chrome_ycJFb7h5d4](https://github.com/itsamul/Selenium-Scripts-for-test-case-for-http-automationexercise.com/assets/85364800/d0a25781-aad3-4eaf-b4a4-f5a7d0ded5ac)

# **Project Description:**
This project contains script to automate test cases for the automationexcercise.com website using selenium webdriver 4.x, java and Testng. 

# **Tech and Tools:**

| #   | NAME | Version |
|-----|----- |---------|
|1. | Selenium webdriver| 4.14.1 |
|2. | Java | 17.0.8 |
|3. | TestNg | 7.8.0 |

# **Test Cases covered:**
Following are the list of test cases automated:
<details><summary>Test Case 1: Register User</summary>
1. Launch browser <br>
2. Navigate to url 'http://automationexercise.com' <br>
3. Verify that home page is visible successfully <br>
4. Click on 'Signup / Login' button <br>
5. Verify 'New User Signup!' is visible <br>
6. Enter name and email address <br>
7. Click 'Signup' button <br>
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible <br> 
9. Fill details: Title, Name, Email, Password, Date of birth <br>
10. Select checkbox 'Sign up for our newsletter!' <br>
11. Select checkbox 'Receive special offers from our partners!' <br>
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number <br>
13. Click 'Create Account button' <br>
14. Verify that 'ACCOUNT CREATED!' is visible <br>
15. Click 'Continue' button <br>
16. Verify that 'Logged in as username' is visible <br>
17. Click 'Delete Account' button <br>
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button  <br>
</details>
<details><summary>Test Case 2: Login User with correct email and password</summary>
1. Launch browser <br>
2. Navigate to url 'http://automationexercise.com' <br>
3. Verify that home page is visible successfully <br>
4. Click on 'Signup / Login' button <br>
5. Verify 'Login to your account' is visible <br>
6. Enter correct email address and password <br>
7. Click 'login' button <br>
8. Verify that 'Logged in as username' is visible <br>
9. Click 'Delete Account' button <br>
10. Verify that 'ACCOUNT DELETED!' is visible <br>
</details>
<details><summary>Test Case 3: Login User with incorrect email and password</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
</details>
<details><summary>Test Case 4: Logout User</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
</details>
<details><summary>Test Case 5: Register User with existing email</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
</details>
<details><summary>Test Case 6: Contact Us Form</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
</details>
<details><summary>Test Case 7: Verify Test Cases Page</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
</details>
<details><summary>Test Case 8: Verify All Products and product detail page</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
</details>
<details><summary>Test Case 9: Search Product</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
</details>
<details><summary>Test Case 10: Verify Subscription in home page</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down to footer
5. Verify text 'SUBSCRIPTION'
6. Enter email address in input and click arrow button
7. Verify success message 'You have been successfully subscribed!' is visible
</details>
<details><summary>Test Case 11: Verify Subscription in Cart page</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Cart' button
5. Scroll down to footer
6. Verify text 'SUBSCRIPTION'
7. Enter email address in input and click arrow button
8. Verify success message 'You have been successfully subscribed!' is visible
</details>
<details><summary>Test Case 12: Add Products in Cart</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
</details>
<details><summary>Test Case 13: Verify Product quantity in Cart</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
</details>
<details><summary>Test Case 14: Place Order: Register while Checkout</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
</details>
<details><summary>Test Case 15: Place Order: Register before Checkout</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify Address Details and Review Your Order
13. Enter description in comment text area and click 'Place Order'
14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
15. Click 'Pay and Confirm Order' button
16. Verify success message 'Your order has been placed successfully!'
17. Click 'Delete Account' button
18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
</details>
<details><summary>Test Case 16: Place Order: Login before Checkout</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill email, password and click 'Login' button
6. Verify 'Logged in as username' at top
7. Add products to cart
8. Click 'Cart' button
9. Verify that cart page is displayed
10. Click Proceed To Checkout
11. Verify Address Details and Review Your Order
12. Enter description in comment text area and click 'Place Order'
13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
14. Click 'Pay and Confirm Order' button
15. Verify success message 'Your order has been placed successfully!'
16. Click 'Delete Account' button
17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
</details>
<details><summary>Test Case 17: Remove Products From Cart</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart
</details>
<details><summary>Test Case 18: View Category Products</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that categories are visible on left side bar
4. Click on 'Women' category
5. Click on any category link under 'Women' category, for example: Dress
6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
7. On left side bar, click on any sub-category link of 'Men' category
8. Verify that user is navigated to that category page
</details>
<details><summary>Test Case 20: Search Products and Verify Cart After Login</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Enter product name in search input and click search button
6. Verify 'SEARCHED PRODUCTS' is visible
7. Verify all the products related to search are visible
8. Add those products to cart
9. Click 'Cart' button and verify that products are visible in cart
10. Click 'Signup / Login' button and submit login details
11. Again, go to Cart page
12. Verify that those products are visible in cart after login as well
</details>
<details><summary>Test Case 21: Add review on product</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Click on 'View Product' button
6. Verify 'Write Your Review' is visible
7. Enter name, email and review
8. Click 'Submit' button
9. Verify success message 'Thank you for your review.'
</details>
<details><summary>Test Case 22: Add to cart from Recommended items</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Scroll to bottom of page
4. Verify 'RECOMMENDED ITEMS' are visible
5. Click on 'Add To Cart' on Recommended product
6. Click on 'View Cart' button
7. Verify that product is displayed in cart page
</details>
<details><summary>Test Case 23: Verify address details in checkout page</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify that the delivery address is same address filled at the time registration of account
13. Verify that the billing address is same address filled at the time registration of account
14. Click 'Delete Account' button
15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
</details>
<details><summary>Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Click on arrow at bottom right side to move upward
7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
</details>
<details><summary>Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality</summary>
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Scroll up page to top
7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
</details>

# **Screenshots:**
Few screenshot of the scripts:<br>
<br>
Screenshot of "Test Case 2: Login User with correct email and password"
![image](https://github.com/itsamul/Selenium-Scripts-for-test-case-for-http-automationexercise.com/assets/85364800/777e2340-3a3f-44c0-8a2d-5c630d50865a)

Screenshot of "Test Case 3: Login User with incorrect email and password"
![image](https://github.com/itsamul/Selenium-Scripts-for-test-case-for-http-automationexercise.com/assets/85364800/fb0fc5dd-7b58-4b3f-aa7d-b28309a12629)

Screenshot of "Test Case 20: Search Products and Verify Cart After Login"
<img width="1960" alt="chrome_vHhCPlyGBo" src="https://github.com/itsamul/Selenium-Scripts-for-test-case-for-http-automationexercise.com/assets/85364800/b3036f63-f697-450e-bf42-aec1eb32cc70">
