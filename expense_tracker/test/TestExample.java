import org.junit.Before;
import org.junit.Test;

import javax.swing.table.DefaultTableModel;

import static org.junit.Assert.assertEquals;

public class TestExample {

    private ExpenseTrackerView view;

    @Before
    public void setUp() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Amount");
        tableModel.addColumn("Category");
        tableModel.addColumn("Date");
        view = new ExpenseTrackerView(tableModel);
    }

    @Test
    public void testAddTransaction() {
        // Create a test transaction
        Transaction testTransaction = new Transaction(100.00, "Food");

        // Add the test transaction to the view
        view.addTransaction(testTransaction);

        // Check if the transaction is added to the transactions list in the view
        assertEquals(1, view.getTransactions().size());

        // Check if the transaction details are displayed in the table
        assertEquals(100.00, view.getTableModel().getValueAt(0, 0));
        assertEquals("Food", view.getTableModel().getValueAt(0, 1));
        // You can check the timestamp if you have a specific value for it.
    }
}
