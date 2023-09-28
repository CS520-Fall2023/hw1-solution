import org.junit.Before;
import org.junit.Test;

import javax.swing.table.DefaultTableModel;

import static org.junit.Assert.assertEquals;

/*
 * This class tests the ExpenseTrackerApp class.
 */

public class ExpenseTrackerTest {

    /*
        * Create a new ExpenseTrackerView and ExpenseTrackerApp object.
    */

    private ExpenseTrackerView view;
    private ExpenseTrackerApp app;

    @Before
    public void setup() {

        // Create the table model and set up the columns

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Serial");
        tableModel.addColumn("Amount");
        tableModel.addColumn("Category");
        tableModel.addColumn("Date");
        // Initialize the view with the table model
        view = new ExpenseTrackerView(tableModel);
        app = new ExpenseTrackerApp();
    }
    /*
        * Test that the ExpenseTrackerView is initialized correctly.
    */
    @Test
    public void testAddTransaction() {
        // Create a new transaction
        double amount = 100.0;
        String category = "Food";
        Transaction transaction = new Transaction(amount, category);

        // Add the transaction to the view
        view.addTransaction(transaction);

        // Get the transactions from the view
        java.util.List<Transaction> transactions = view.getTransactions();

        // Verify that the transaction was added
        assertEquals(1, transactions.size());
        assertEquals(amount, transactions.get(0).getAmount(), 0.001);
        assertEquals(category, transactions.get(0).getCategory());
    }
}