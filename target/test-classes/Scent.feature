Feature:  To test Scent-Arts website functionality
Background:
Given To launch the browser 
When To launch URL of Scent-Arts
Scenario: To verify the descriptions of AREAS OF SCENTING secion
And To click About Us button
And To Scroll down to the AREAS OF SCENTING section
And Click on hotels, offices and airports areas
And To check hotels, offices and airports areas description is present
Then To close the browser
@Sanity2
Scenario: To verify that clicking the Contact Us button automatically navigates to the Contact Us page
And To click the OUR SERVICES button
And To scroll down to Contact Us button
And To click the Contact Us button
And Scroll down to the form and take screenshot
Then To close the browser
@Sanity3
Scenario: To verify Contact Us page functionality
And click the contact us button
And To enter the name in name field
And To enter the company name in company name field
And To enter phone number in phone number field
And To enter email in mail address field
And To select type of services
And To enter the location in location field
And To enter the message in message field
And To click send button
Then To close the browser