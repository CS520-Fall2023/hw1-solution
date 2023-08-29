# hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

## How to build and test (from Terminal):
1. Make sure that you have Apache Ant installed.

2. Run ```ant``` in the root directory, which contains the build.xml build file.

3. Compiled java classes will be in the bin directory.

4. Run ```ant test``` to run all unit tests.

## How to run (from Terminal):
After building the project (i.e., running ant), run: ```java -cp bin ExpenseTrackerApp```

## How to clean up (from Terminal):
Run ```ant clean``` to clean the project (i.e., delete all generated files).

## Code Modification

Create a file named ```InputValidation.java```  to validate the ```amount``` and ```category``` field of this app. Some hints are as follows:
1. The ```amount``` should be greater than 0 and less than 1000. 
2. It should be a valid number. 
3. The ```category``` should be a valid string input from the following list: "food", "travel", "bills", "entertainment", "other" . 


## solution
1. Check the ```InputValidation.java``` for possible answers on code modification. 

## Manual Review

### Two Examples of Satisfying Non-Functional Requirements
1. Performance: Efficient update of table view in the ```refreshTable``` method of the ```ExpenseTrackerView.java```. 
2. Usability: Enhancement of usability by the GUI. 

### Two examples of violated non-functional requirement
1. Security: No data encapsulation is implemented to protect transaction data. 
2. Error Handling: The code lacks proper data handling mechanisms. 
3. Modularity: The code does not demonstrate a high level of modularity. in the ```ExpenseTrackerView.java```, there is a mix of view-related code and controller-related code. 
4. Testability: The code does not facilitate any teting. In the ```ExpenseTrackerApp``` class, the main method directly creates instances of the ```ExpenseTrackerView``` and sets it as visible. This makes it difficult to write unit tests for the application logic, as it tightly couples the view and controller. 

## Modularity 

![UI Components](ui_components.png)

1. Component A: View. 
This component is part of the view. It is responsible for displaying the input fields for the amount and category.
2. Component B: View
This component is also part of the view.It is responsible for displaying the transactions.
3. Component C: Both View and Controller
This component is part of both the view and the controller. It is responsible for triggering the addition of a new transaction. It interacts with the view by displaying the button, and it interacts with the controller by triggering the addition of a new transaction when clicked.

### Identify application source code

1. Model: 
The Transaction.java file represents the model component. It defines the Transaction class, which encapsulates the data related to a transaction, including the amount, category, and timestamp.
2. View: 
The ExpenseTrackerView.java file represents the view component. It extends the JFrame class and creates a graphical user interface (GUI) for the expense tracker application. It includes UI components such as buttons, text fields, and a table for displaying transactions.
3. Controller:
The ExpenseTrackerApp.java file represents the controller component. It acts as the entry point for the application and handles the interaction between the view and the model. It creates instances of the view and model, sets up event listeners, and performs actions based on user input.
