package com.saveandberich.view;

import com.saveandberich.model.service.UpdatedInfo;

/**
 * The ActionView class represents a view that displays a menu of actions for
 * the user to choose from.
 * It extends the View class and overrides the display() and update() methods.
 */
public class ActionView extends View {

  /**
   * Displays the menu of actions for the user to choose from.
   * The available actions include adding income, adding a purchase, showing a
   * list of purchases,
   * checking the balance, and exiting the program.
   * This method prompts the user for input and stores it in the userInput
   * variable.
   */
  @Override
  public void display() {
    print("Choose your action:");
    print("1) Add income");
    print("2) Add purchase");
    print("3) Show list of purchases");
    print("4) Balance");
    print("0) Exit");
    userInput = readInput();
  }

  /**
   * Updates the ActionView with the latest information.
   * This method is called when the model's data has been updated.
   * It receives an UpdatedInfo object containing the updated transaction list,
   * and assigns it to the transactionList variable of the ActionView.
   *
   * @param info The UpdatedInfo object containing the updated transaction list.
   */
  @Override
  public void update(UpdatedInfo info) {
    this.transactionList = info.getAllTransactions();
  }
}
