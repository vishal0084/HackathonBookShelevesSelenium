Overview - Display Bookshelves

This project aims to automate the Urban Ladder Shopping Website using Selenium WebDriver.
It uses www.urbanladder.com webpage, extracting product details and sending gift card request.

Libraries and Dependencies
Maven Repository: Maven 3.12.1

Apache POI: 5.2.5

TestNG: 7.9.0

Extent Report: 5.1.1

Selenium WebDriver: 4.18.1

extentreports-cucumber7-adapter: 1.14.0

cucumber-junit: 7.16.1

cucumber-java : 7.16.1


Automation Flow
1. Navigate to the https://www.urbanladder.com/ url
2. Search for "BookShelves" with price below Rs.15000
3. Chooses any category (like Wall Shelves / Kid Bookshelves / Study Tables, etc) & excludes out of stock. 
4. Sort by price "High to Low", fetch the top 3 items & print all details in console output.
5. From Living, retrieve all items under any one of sub-menu items like “Seating & Chairs" or "Living Storage". 
6. Print the same in console output.
7. Under "Gift cards", choose "Birthday/Anniversary".
8. Fill "Customize your gift card" with valid price & date and click "Next" button.
9. Fill "To" & "From" details under "who is this lucky person" with any one email id invalid (example: without @ symbol)
10. Click "Submit"; Capture & display the error message in console output.
11. Then give valid email id & validate all the given details in the "Confirm Details" section.


Challenges
Overcame issues related to dynamic content and page structure.​
Fetching the pop message while entering the wrong details in the gift card request section.

Benefits
Increased efficiency through automated product fetching. ​Reduced manual effort and minimized the chance of human errors.

Contributors

Vishal Kumar – 2317372

Moupali Sen - 2317616

Vaibhav Mishra - 2317330

Sankha Subhra Nandy - 2317648
​