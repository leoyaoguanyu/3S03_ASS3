from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import pytest

# Case 1: Test Form Authentication
def test_form_authentication():
    # Initialize Chrome browser (Selenium 4 automatically handles driver setup)
    driver = webdriver.Chrome() 
    driver.get("https://the-internet.herokuapp.com/login")

    # Locate the input fields and enter the valid username and password
    driver.find_element(By.ID, "username").send_keys("tomsmith")
    driver.find_element(By.ID, "password").send_keys("SuperSecretPassword!")

    # Click the login button
    driver.find_element(By.CSS_SELECTOR, "button[type='submit']").click()

    # Explicit Wait: Wait up to 10 seconds for the success flash message to appear
    flash_message = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "flash"))
    )
    
    # Assertion: Verify that the success message is displayed
    assert "You logged into a secure area!" in flash_message.text
    
    # Teardown: Close the browser
    driver.quit()

# Case 2: Test Checkboxes
def test_checkboxes():
    # Initialize Chrome browser
    driver = webdriver.Chrome()
    driver.get("https://the-internet.herokuapp.com/checkboxes")

    # Locate the two checkboxes on the page
    checkboxes = driver.find_elements(By.CSS_SELECTOR, "input[type='checkbox']")
    checkbox1 = checkboxes[0]
    checkbox2 = checkboxes[1]

    # The default state is: checkbox 1 is unchecked, checkbox 2 is checked. 
    # We will reverse this state.
    
    if not checkbox1.is_selected():
        checkbox1.click() # Check the first checkbox

    if checkbox2.is_selected():
        checkbox2.click() # Uncheck the second checkbox

    # Assertion: Verify the states are now reversed
    assert checkbox1.is_selected()
    assert not checkbox2.is_selected()
    
    # Teardown: Close the browser
    driver.quit()