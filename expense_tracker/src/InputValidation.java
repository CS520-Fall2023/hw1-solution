import java.util.Arrays;

/**
 * Represents a class that validates user input.
 * e.g. amount and category
 */

public class InputValidation {

  /**
   * @param amount the amount to validate
   * @return true if the amount is valid, false otherwise
   */

  public static boolean isValidAmount(double amount) {
    
    // Check range
    if(amount >1000) {
      return false;
    }
    if (amount < 0){
      return false;
    }
    if (amount == 0){
      return false;
    }
    return true;
  }

  public static boolean isValidCategory(String category) {
    /*
     * Valid categories are:"food", "travel", "bills", "entertainment", "other"
     * check if the category is null
     * return false if the category is null
     */

    if(category == null) {
      return false; 
    }
  
    if(category.trim().isEmpty()) {
      return false;
    }

    if(!category.matches("[a-zA-Z]+")) {
      return false;
    }

    String[] validWords = {"food", "travel", "bills", "entertainment", "other"};

    if(!Arrays.asList(validWords).contains(category.toLowerCase())) {
      // invalid word  
      return false;
    }
  
    return true;
  
  }

}