import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      // Get transaction data from view
      if(!InputValidation.isValidAmount(view.getAmountField())){
        System.out.println("Invalid amount entered");
         JOptionPane.showMessageDialog(view, "Invalid amount entered");
         view.toFront();
        return;
      }
      if(!InputValidation.isValidCategory(view.getCategoryField())){
        System.out.println("Invalid category entered");
         JOptionPane.showMessageDialog(view, "Invalid category entered");
         view.toFront();
        return;
      }
      double amount = view.getAmountField();
      String category = view.getCategoryField(); 
      // Create transaction object
      Transaction t = new Transaction(amount, category);
      // Call controller to add transaction
      view.addTransaction(t);
      



    });

  }

}