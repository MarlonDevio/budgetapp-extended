package com.saveandberich.model.service;

import com.saveandberich.model.financialentities.transaction.Transaction;
import com.saveandberich.model.pattern.observer.Observer;
import com.saveandberich.model.pattern.observer.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 * The BankAccountService class represents a service for managing bank accounts.
 * It implements the Subject interface to provide observer functionality.
 */
public class BankAccountService implements Subject {
  private static BankAccountService instance;
  private final TransactionManager transactionManager;
  private List<Observer> observers;

  private BankAccountService() {
    transactionManager = new TransactionManager();
    observers = new ArrayList<>();
  }

  /**
   * Returns the singleton instance of the BankAccountService class.
   *
   * @return The BankAccountService instance.
   */
  public static BankAccountService getInstance() {
    if (instance == null) {
      return new BankAccountService();
    }
    return instance;
  }

  /*
   * *************************************
   * SUBJECT INTERFACE METHODS
   ***************************************/

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(buildCompleteTransactionInfo());
    }
  }

  /*
   * *************************************
   * ADDING TRANSACTIONS
   ***************************************/

  /**
   * Adds a transaction to the transaction manager and notifies the observers.
   *
   * @param transaction The transaction to be added.
   */
  public void addTransaction(Transaction transaction) {
    transactionManager.addTransaction(transaction);
    notifyObservers();
  }

  /*
   * *************************************
   * GETTER - TRANSACTION METHODS
   ***************************************/

  private List<Transaction> getAllTransactions() {
    return transactionManager.getCompleteTransactionList();
  }

  private List<Transaction> getAllIncomeTransactions() {
    return transactionManager.getIncomeTransactions();
  }

  private List<Transaction> getAllExpenseTransactions() {
    return transactionManager.getExpenseTransactions();
  }

  private double getTotalIncome() {
    return transactionManager.getTotalIncome();
  }

  private double getTotalExpenses() {
    return transactionManager.getTotalExpense();
  }

  private double getTotalBalance() {
    return transactionManager.getBalanceTotal();
  }

  /*
   * *************************************
   * ALL TRANSACTION INFO BUILT
   ***************************************/

  private UpdatedInfo buildCompleteTransactionInfo() {
    UpdatedInfo info = new UpdatedInfo();
    info.setTotalBalance(getTotalBalance());
    info.setTotalIncome(getTotalIncome());
    info.setTotalExpenses(getTotalExpenses());
    info.setAllTransactions(getAllTransactions());
    info.setAllIncomeTransactions(getAllIncomeTransactions());
    info.setAllExpenseTransactions(getAllExpenseTransactions());
    return info;
  }
}
