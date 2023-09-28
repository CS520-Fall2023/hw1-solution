import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class serves as the main entry point for the Expense Tracker application.
 * This application provides an interface for users to track their expenses, categorize them, 
 * and view them in a tabulated format.
 * 
 * @author Mahbuba
 * @version 1.0
 */

public class ExpenseTrackerApp {

  /**
   * The main method of the ExpenseTrackerApp. It initializes the components of the application,
   * sets up event listeners, and handles user interactions.
   * 
   * @param args The command-line arguments (not used in this application).
   */
 

  public static void main(String[] args) {
    
    // Create the table model and set up the columns
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize the view with the table model
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      // validation specification for amount input
      if(!InputValidation.isValidAmount(view.getAmountField())){
        System.out.println("Invalid amount entered");
         JOptionPane.showMessageDialog(view, "Invalid amount entered");
         view.toFront();
        return;
      }
      // validation specification for category input
      if(!InputValidation.isValidCategory(view.getCategoryField())){
        System.out.println("Invalid category entered");
         JOptionPane.showMessageDialog(view, "Invalid category entered");
         view.toFront();
        return;
      }
      //Retrieve and create a new transaction object
      double amount = view.getAmountField();
      String category = view.getCategoryField(); 
      Transaction t = new Transaction(amount, category);


      // update the view with the new transaction
      view.addTransaction(t);
      



    });

  }

}