

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List; 

/**
 * Represents the main GUI view for the Expense Tracker application.
 * This class extends the JFrame class and implements the ExpenseTrackerViewInterface interface.
 */

public class ExpenseTrackerView extends JFrame {

  // Instance variables

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  private List<Transaction> transactions = new ArrayList<>();

  /**
   * @return the transactions table.
   */  

  public JTable getTransactionsTable() {
    return transactionsTable;
  }

    /**
     * @return the value from the amount field.
     * If the amount field is empty, return 0.
     * Otherwise, parse the amount field value to a double and return it.
     */  

  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  /**
   * @param amountField the amountField to set
   */

  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }


  /**
   * @return the value from the category field.
   */
  public String getCategoryField() {
    return categoryField.getText();
  }

  /**
   * @param categoryField the categoryField to set
   */
  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  /**
   * @return the "Add Transaction" button.
   */
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  /**
  * @return the table's data model.
  */

  public DefaultTableModel getTableModel() {
    return model;
  }


  /**
   * Constructs a new ExpenseTrackerView object.
   * 
   * @param model The table model to use for the view.
   */

  public ExpenseTrackerView(DefaultTableModel model) {
    // Set frame properties


    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    // Create UI components

    addTransactionBtn = new JButton("Add Transaction");
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);
    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  /**
   * Updates the table with the given list of transactions.
   * 
   * @param transactions The list of transactions to display in the table.
   */

  public void refreshTable(List<Transaction> transactions) {
      // Clear existing rows
      model.setRowCount(0);
      // Get row count
      int rowNum = model.getRowCount();
      double totalCost=0;
      // Calculate total cost
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
  
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()});
      }
      // Add total row
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);
      // Fire table update
      transactionsTable.updateUI();
  
    }  

  /**
   * Refreshes the view to reflect the current state of the model.
   */

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = getTransactions();
  
    // Pass to view
    refreshTable(transactions);
  
  }

  /**
   * @return the list of transactions.
   */

  public List<Transaction> getTransactions() {
    return transactions;
  }
  
  /**
   * Adds a transaction to the view.
   * 
   * @param t The transaction to add.
   */
  public void addTransaction(Transaction t) {
    transactions.add(t);
    getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
  }
  


  // Other view methods
}
