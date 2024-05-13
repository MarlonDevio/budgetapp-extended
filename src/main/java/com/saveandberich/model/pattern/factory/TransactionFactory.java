package com.saveandberich.model.pattern.factory;

import com.saveandberich.model.financialentities.transaction.Transaction;

/**
 * The TransactionFactory class is responsible for creating Transaction objects.
 */
public class TransactionFactory {
  /**
   * Creates a new Transaction object with the specified description, amount, and
   * type.
   *
   * @param description the description of the transaction
   * @param amount      the amount of the transaction
   * @param type        the type of the transaction
   * @return a new Transaction object
   */
  public Transaction create(String description, double amount, String type) {
    return new Transaction(description, amount, type);
  }
}
