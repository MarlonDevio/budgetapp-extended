package com.saveandberich.view;

import com.saveandberich.model.service.UpdatedInfo;

/**
 * The BalanceView class represents a view that displays the total balance.
 * It extends the View class and overrides the display and update methods.
 */
public class BalanceView extends View {

  /**
   * Displays the total balance by printing it to the console.
   */
  @Override
  public void display() {
    String formatted = String.format("Balance: $%.2f", getAmount());
    print(formatted);
  }

  /**
   * Updates the total balance based on the provided UpdatedInfo object.
   *
   * @param info The UpdatedInfo object containing the updated balance
   *             information.
   */
  @Override
  public void update(UpdatedInfo info) {
    amount = info.getTotalBalance();
  }
}
