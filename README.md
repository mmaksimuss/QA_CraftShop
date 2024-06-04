🛍️ Craft Shop

 📄 Project description

Craft Shop is a web application for buying and selling products. The project allows users to register, log in, add items to cart and place orders.

 🚀 Functionality

- ✅ User registration
- ✅ Login
- 🔍 Product search
- 🛒 Adding items to cart
- 📦 Placing orders

 🗂️ Project structure

The project is divided into the following packages:

- `com.craftshop.pages` - Classes for pages (Page Object Model)
- `com.craftshop.testsSE` - Test classes
- `com.craftshop.models` - DTO and data models

 🛠️ Installation

1. Clone the repository:

   git clone https://github.com/mmaksimuss/QA_CraftShop.git

2. Go to the project directory:

   cd craft shop

3. Install Maven dependencies:

   mvn clean install


 🧪Running tests

To run the tests, run the following command:

mvn test


 📋 Description of tests

 📝User registration

- Test: Registration with valid data
    - Steps:
        1. Go to the registration page.
        2. Fill in all required fields (first name, last name, email, password).
        3. Click the "Register" button.
        4. Check that registration is successful and the user is redirected to the home page.

- Test: Registration with an existing email
    - Steps:
        1. Go to the registration page.
        2. Enter an email that is already in use.
        3. Click the "Register" button.
        4. Check that the error message is displayed.

 🔑 User login

- Test: Login with valid data
    - Steps:
        1. Go to the login page.
        2. Enter a valid email and password.
        3. Click the "Login" button.
        4. Check that the login is successful and the user is redirected to the home page.

- Test: Login with incorrect password
    - Steps:
        1. Go to the login page.
        2. Enter a valid email and incorrect password.
        3. Click the "Login" button.
        4. Check that the error message is displayed.

 🛒 Adding a product to cart

- Test: Adding a product to cart
    - Steps:
        1. Go to the product page.
        2. Click the "Add to cart" button.
        3. Check that the item has been added to the cart and the quantity of items in the cart has been updated.

- Test: Removing an item from the cart
    - Steps:
        1. Go to cart.
        2. Remove item from cart.
        3. Check that the product has been deleted and the cart is empty.

 📦 Placing an order

- Test: Placing an order with valid data
    - Steps:
        1. Go to cart.
        2. Click the "Place an order" button.
        3. Fill in all required fields (delivery address, contact information).
        4. Select a payment method.
        5. Click the "Confirm order" button.
        6. Check that the order has been placed successfully and the order confirmation page is displayed.

  🧪 Usability testing

Usability testing helps ensure that the application interface is user-friendly and intuitive for users.

- Test: Checking the availability of basic functions
    - Steps:
        1. Open the main page.
        2. Make sure that the registration and login buttons are visible and accessible.

- Test: Checking site navigation
    - Steps:
        1. Go from the main page to the product category page.
        2. Make sure category navigation is intuitive and easy to use.
        3. Return to the main page and make sure that navigating the site is easy.

- Test: Checking the clarity of error messages
    - Steps:
        1. Try to log in with the wrong password.
        2. Verify that the error message clearly explains the problem and provides the user with clear steps to correct it.



