package com.saveandberich.view;

import com.saveandberich.model.service.UpdatedInfo;

/**
 * This class represents the view for entering income in the SaveAndBeRich
 * application.
 * It extends the View class and overrides the display() method to prompt the
 * user for income input.
 * The update() method is left empty as it is not needed for this view.
 */
public class IncomeView extends View {

  @Override
  public void display() {
    print("Enter income: ");
    userInput = readInput();
  }

  @Override
  public void update(UpdatedInfo info) {

  }
}
