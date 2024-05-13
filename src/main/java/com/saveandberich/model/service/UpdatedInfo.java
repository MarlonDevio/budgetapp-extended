package com.saveandberich.model.service;

import com.saveandberich.model.financialentities.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * The UpdatedInfo class represents the updated information about the financial
 * transactions.
 * It includes the total balance, total income, total expenses, and lists of all
 * transactions,
 * income transactions, and expense transactions.
 */
public class UpdatedInfo {
  private double totalBalance;
  private double totalIncome;
  private double totalExpenses;
  private List<Transaction> allTransactions;
  private List<Transaction> allIncomeTransactions;
  private List<Transaction> allExpenseTransactions;

  /**
   * Constructs a new UpdatedInfo object with empty lists for transactions.
   */
  UpdatedInfo() {
    allTransactions = new ArrayList<>();
    allIncomeTransactions = new ArrayList<>();
    allExpenseTransactions = new ArrayList<>();
  }

  /**
   * Sets the total balance.
   * 
   * @param totalBalance the total balance to set
   */
  void setTotalBalance(double totalBalance) {
    this.totalBalance = totalBalance;
  }

  /**
   * Sets the total income.
   * 
   * @param totalIncome the total income to set
   */
  void setTotalIncome(double totalIncome) {
    this.totalIncome = totalIncome;
  }

  /**
   * Sets the total expenses.
   * 
   * @param totalExpenses the total expenses to set
   */
  void setTotalExpenses(double totalExpenses) {
    this.totalExpenses = totalExpenses;
  }

  /**
   * Sets the list of all transactions.
   * 
   * @param allTransactions the list of all transactions to set
   */
  void setAllTransactions(List<Transaction> allTransactions) {
    this.allTransactions = allTransactions;
  }

  /**
   * Sets the list of all income transactions.
   * 
   * @param allIncomeTransactions the list of all income transactions to set
   */
  void setAllIncomeTransactions(List<Transaction> allIncomeTransactions) {
    this.allIncomeTransactions = allIncomeTransactions;
  }

  /**
   * Sets the list of all expense transactions.
   * 
   * @param allExpenseTransactions the list of all expense transactions to set
   */
  void setAllExpenseTransactions(List<Transaction> allExpenseTransactions) {
    this.allExpenseTransactions = allExpenseTransactions;
  }

  /**
   * Returns the total balance.
   * 
   * @return the total balance
   */
  public double getTotalBalance() {
    return totalBalance;
  }

  /**
   * Returns the total income.
   * 
   * @return the total income
   */
  public double getTotalIncome() {
    return totalIncome;
  }

  /**
   * Returns the total expenses.
   * 
   * @return the total expenses
   */
  public double getTotalExpenses() {
    return totalExpenses;
  }

  /**
   * Returns the list of all transactions.
   * 
   * @return the list of all transactions
   */
  public List<Transaction> getAllTransactions() {
    return allTransactions;
  }

  /**
   * Returns the list of all income transactions.
   * 
   * @return the list of all income transactions
   */
  public List<Transaction> getAllIncomeTransactions() {
    return allIncomeTransactions;
  }

  /**
   * Returns the list of all expense transactions.
   * 
   * @return the list of all expense transactions
   */
  public List<Transaction> getAllExpenseTransactions() {
    return allExpenseTransactions;
  }
}
