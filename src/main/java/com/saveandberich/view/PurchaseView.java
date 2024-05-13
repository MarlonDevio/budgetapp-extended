package com.saveandberich.view;

import com.saveandberich.model.service.UpdatedInfo;

/**
 * This class represents a view for purchasing items.
 * It extends the View class and provides methods for displaying the purchase
 * view and updating the view with new information.
 */
public class PurchaseView extends View {

  /**
   * Displays the purchase view and prompts the user to enter a purchase.
   */
  @Override
  public void display() {
    print("Enter purchase name: ");
    userInput = readInput();
    print("Enter it's price: ");
    doubleInput = Double.parseDouble(readInput());
  }

  /**
   * Updates the purchase view with new information.
   * This method is not implemented in this class.
   *
   * @param info The updated information.
   */
  @Override
  public void update(UpdatedInfo info) {

  }
}
