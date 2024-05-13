package com.saveandberich.model.service;

import com.saveandberich.model.financialentities.category.Category;
import com.saveandberich.model.financialentities.category.ExpenseCategory;
import com.saveandberich.model.financialentities.category.IncomeCategory;
import com.saveandberich.model.financialentities.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * The TransactionManager class manages transactions and provides various
 * methods to retrieve transaction information.
 */
public class TransactionManager {

  private final Category expenseCategory = new ExpenseCategory("expense", "-");
  private final Category incomeCategory = new IncomeCategory("income", "+");
  private final List<Transaction> transactionList;

  /**
   * Constructs a new TransactionManager object.
   */
  TransactionManager() {
    transactionList = new ArrayList<>();
    transactionList.addAll(expenseCategory.getTransactionList());
    transactionList.addAll(incomeCategory.getTransactionList());
  }

  /*
   * *************************************
   * TRANSACTION METHODS
   ***************************************/

  /**
   * Adds a transaction to the transaction list.
   *
   * @param transaction The transaction to be added.
   */
  void addTransaction(Transaction transaction) {
    if (isDuplicate(transaction)) {
      System.out.println("Duplicate transaction, failed to add transaction.");
      return;
    }
    String transactionType = transaction.getType().equals("-") ? "purchase" : "income";
    System.out.println(transactionType + " was added!");
    transactionList.add(transaction);
  }

  // TOTAL TRANSACTION METHODS

  /**
   * Retrieves the complete list of transactions.
   *
   * @return The complete list of transactions.
   */
  List<Transaction> getCompleteTransactionList() {
    return this.transactionList;
  }

  /**
   * Calculates the balance total by subtracting the total expenses from the total
   * income.
   *
   * @return The balance total.
   */
  double getBalanceTotal() {
    return calculate("+") - calculate("-");
  }

  // INCOME METHODS

  /**
   * Retrieves the list of income transactions.
   *
   * @return The list of income transactions.
   */
  List<Transaction> getIncomeTransactions() {
    return getSpecificTransactionsList("+");
  }

  /**
   * Calculates the total income.
   *
   * @return The total income.
   */
  double getTotalIncome() {
    return calculate("+");
  }

  // EXPENSE METHODS

  /**
   * Retrieves the list of expense transactions.
   *
   * @return The list of expense transactions.
   */
  List<Transaction> getExpenseTransactions() {
    return getSpecificTransactionsList("-");
  }

  /**
   * Calculates the total expenses.
   *
   * @return The total expenses.
   */
  double getTotalExpense() {
    return calculate("-");
  }

  /*
   * *************************************
   * HELPER METHODS
   ***************************************/

  private double calculate(String key) {
    return getSpecificTransactionsList(key).stream().mapToDouble(Transaction::getAmount).sum();
  }

  private List<Transaction> getSpecificTransactionsList(String key) {
    return transactionList.stream()
        .filter(transaction -> transaction.getType().equals(key))
        .toList();
  }

  private boolean isDuplicate(Transaction transaction) {
    return transactionList.stream().anyMatch(t -> t.equals(transaction));
  }

}
