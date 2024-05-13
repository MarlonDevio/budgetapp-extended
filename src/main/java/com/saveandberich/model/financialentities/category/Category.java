package com.saveandberich.model.financialentities.category;

import com.saveandberich.model.financialentities.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The Category class represents a category of transactions. It is an abstract class that provides
 * common functionality for different types of categories.
 */
public abstract class Category {

  protected final String marker;
  protected final List<Transaction> transactionList;
  protected final String categoryName;
  protected final List<Category> subCategories;


  /**
   * Constructs a Category object with the specified category name.
   *
   * @param categoryName the name of the category
   */
  public Category(String categoryName, String marker) {
    this.categoryName = categoryName;
    this.marker = marker;
    transactionList = new ArrayList<>();
    subCategories = new ArrayList<>();
  }

  /* *************************************
  * CATEGORY REMOVING AND ADDING
  ***************************************/

  public boolean addCategory(Category category){
    if(!category.marker.equals(this.marker)){
      System.out.println("Incorrect category!");
      return false;
    }
    if(subCategories.contains(category)){
      System.out.println("Duplicate category!");
      return false;
    }
    subCategories.add(category);
    return true;
  }

  public boolean removeCategory(Category category){
    if(!subCategories.contains(category)){
      System.out.println("No such category present.");
      return false;
    }
    return subCategories.remove(category);
  }

  /* *************************************
  * GETTERS AND SETTERS FOR CATEGORYLIST
  ***************************************/

  public List<Category> getSubCategories() {
    return subCategories;
  }

  /**
   * This method is called when a transaction is added to the category's transaction list.
   * Subclasses can override this method to perform additional actions when a transaction is added.
   *
   * @param transaction the transaction that was added
   */
  protected abstract void transactionAddedDisplay(Transaction transaction);

  /* *************************************
  * ADDING AND REMOVING TRANSACTIONS
  ***************************************/
  /**
   * Adds a transaction to the category's transaction list. This method also calls the
   * transactionAddedDisplay method to perform any necessary actions.
   *
   * @param transaction the transaction to be added
   */
  public boolean addTransactionToList(Transaction transaction) {
    if (transactionList.stream().anyMatch(tr -> tr.getId().equals(transaction.getId()))) {
      System.out.println("Duplicate transaction. Was not added!");
      return false;
    }
    transactionList.add(transaction);
    return true;
  }

  public boolean removeTransactionFromList(Transaction transaction) {
    return transactionList.remove(transaction);
  }

  /**
   * Returns the list of transactions in the category.
   *
   * @return the list of transactions
   */
  public List<Transaction> getTransactionList() {
    return transactionList;
  }

  /**
   * Returns the name of the category.
   *
   * @return the category name
   */
  public String getCategoryName() {
    return categoryName;
  }

  /**
   * Returns a string representation of the category.
   *
   * @return a string representation of the category
   */
  @Override
  public String toString() {
    return "I am " + categoryName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Category category)) {
      return false;
    }
    return Objects.equals(categoryName.toLowerCase(), category.categoryName.toLowerCase());
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryName.toLowerCase());
  }
}
