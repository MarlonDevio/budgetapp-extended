package com.saveandberich.view;

import com.saveandberich.model.financialentities.transaction.Transaction;
import com.saveandberich.model.pattern.observer.DisplayElement;
import com.saveandberich.model.pattern.observer.Observer;
import java.util.List;
import java.util.Scanner;

/**
 * The View class is an abstract class that implements the Observer and
 * DisplayElement interfaces.
 * It provides common functionality and data members for all view classes in the
 * SaveAndBeRich application.
 */
public abstract class View implements Observer, DisplayElement {
  protected List<Transaction> transactionList;
  protected double amount;
  protected final Scanner scanner = new Scanner(System.in);
  protected static String userInput;
  protected static double doubleInput;

  /**
   * Returns the user input.
   *
   * @return the user input
   */
  public String getUserInput() {
    return userInput;
  }

  /*
   * *********************************
   * HELPERS
   ********************************/

  // INPUT HANDLING

  /**
   * Prints the specified string to the console.
   *
   * @param toPrint the string to be printed
   */
  protected void print(String toPrint) {
    System.out.println(toPrint);
  }

  /**
   * Returns the transaction list.
   *
   * @return the transaction list
   */
  protected List<Transaction> getTransactionList() {
    return this.transactionList;
  }

  /**
   * Returns the amount.
   *
   * @return the amount
   */
  protected double getAmount() {
    return this.amount;
  }

  /**
   * Reads the user input from the console.
   *
   * @return the user input
   */
  protected String readInput() {
    return scanner.nextLine();
  }

  public double getDoubleInput() {
    return doubleInput;
  }

}
