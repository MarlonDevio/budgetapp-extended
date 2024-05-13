package com.saveandberich.model.financialentities.category;

import com.saveandberich.model.financialentities.transaction.Transaction;

public class ExpenseCategory extends Category{

  /**
   * Constructs a Category object with the specified category name.
   *
   * @param categoryName the name of the category
   */
  public ExpenseCategory(String categoryName, String marker) {
    super(categoryName, marker);
  }

  @Override
  protected void transactionAddedDisplay(Transaction transaction) {
    System.out.println(transaction.getDescription()+" was added.");
  }
}
