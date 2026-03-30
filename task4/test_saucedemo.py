from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import pytest

def test_saucedemo_user_journey():
    # Initialize Chrome browser
    driver = webdriver.Chrome()
    driver.maximize_window()
    
    # Set up an explicit wait of 10 seconds
    wait = WebDriverWait(driver, 10)

    try:
        # --- Step 1: Login ---
        driver.get("https://www.saucedemo.com/")
        driver.find_element(By.ID, "user-name").send_keys("standard_user")
        driver.find_element(By.ID, "password").send_keys("secret_sauce")
        driver.find_element(By.ID, "login-button").click()

        # --- Step 2: Add to Cart ---
        # Wait for the specific add-to-cart button to be visible, then click it
        add_to_cart_btn = wait.until(EC.visibility_of_element_located((By.ID, "add-to-cart-sauce-labs-backpack")))
        add_to_cart_btn.click()

        # --- Step 3: Verify Cart ---
        # Click the cart icon
        driver.find_element(By.CLASS_NAME, "shopping_cart_link").click()
        # Verify the item name is in the cart
        cart_item = wait.until(EC.visibility_of_element_located((By.CLASS_NAME, "inventory_item_name")))
        assert cart_item.text == "Sauce Labs Backpack"

        # --- Step 4: Checkout Information ---
        driver.find_element(By.ID, "checkout").click()
        # Wait for the first name field, then fill out the form
        wait.until(EC.visibility_of_element_located((By.ID, "first-name"))).send_keys("Guanyu")
        driver.find_element(By.ID, "last-name").send_keys("Yao")
        driver.find_element(By.ID, "postal-code").send_keys("M5G 2C9")
        driver.find_element(By.ID, "continue").click()

        # --- Step 5: Complete Order ---
        # Click finish on the overview page
        driver.find_element(By.ID, "finish").click()
        # Verify the final success message
        success_message = wait.until(EC.visibility_of_element_located((By.CLASS_NAME, "complete-header")))
        assert success_message.text == "Thank you for your order!"

    finally:
        # Teardown: Ensure the browser closes even if an assertion fails
        driver.quit()