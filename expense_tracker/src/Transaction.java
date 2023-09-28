

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a transaction in the Expense Tracker application.
 * A transaction has an amount, a category, and a timestamp.
 * The amount is a double, the category is a String, and the timestamp is a String.
 * The timestamp is generated automatically when the transaction is created.
 */

public class Transaction {

  // Instance variables

  private double amount;
  private String category;
  private String timestamp;

  /*
   * Constructs a new transaction with the specified amount and category.
   * @param amount The amount of the transaction.
   * @param category The category of the transaction.
   * @return A new Transaction object with the provided amount and category.
   */

  public Transaction(double amount, String category) {
    /*
     * Initialize the instance variables with the values provided in the constructor.
     */
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category; 
  }
  /**
   * @return the timestamp
   */
  public String getTimestamp() {
    return timestamp;
  }
  /*
   * Generates a timestamp for the transaction.
   */
  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}