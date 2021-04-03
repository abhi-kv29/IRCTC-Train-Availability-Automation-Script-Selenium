# PROJECT NAME : IRCTC TRAIN AVAILABILITY AUTOMATION SCRIPT 

## STARTING MONTH : MARCH 2021
## ENDING MONTH : MARCH 2021 

## STATUS: COMPLETED

---

### DESCRIPTION 

The IRCTC TRAIN AVAILABILITY AUTOMATION SCRIPT is an end to end test script automated to search for all available trains under a particular quota and train class with berth availability. The script is made using Java and Selenium WebDriver for Google Chrome Web Browser. 

---

### ABOUT 

- This Automation Script is developed with the help of Java and Selenium Web Driver for Google Chrome.
- The main aim of this script is to connect to IRCTC main website and invoke the script which enters all the particular information to search for availability of trains.
- The parameters on which the script is based are source and destination dynamic dropdowns, calendar UI, suggestive dropdowns.
- On invoking the browser and getting the URL of the site, some implicit and thread delays provided in order to prevent script failure and provide synchronization with the parameters. 
- After setting all the parameters with dynamic inputs it submits the response and redirects to the main availability page where all the available trains for the particular inputted parameters can be viewed. 
- In addition most of the responses are recorded in console for validation also some methods are used for that only. 
- Improved Script speed performance by adding explicit wait. 

---

### FUTURE SCOPE AND LIMITATIONS

- All the trains available can be logged into console.
- More dynamicness can be added to the working of script.
- Script performancing and run time can be improved.

---

### PROBLEMS FACED 

- Passing text paramaters in conditions to make the calendar UI select element.
- Working with absolute and relative xpaths and css selectors.
- Synchronization due to delays with Script failures.
  
