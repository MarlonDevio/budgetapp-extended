package com.saveandberich.model.pattern.command;

import com.saveandberich.controller.Controllable;
import com.saveandberich.model.financialentities.category.Category;
import com.saveandberich.model.financialentities.transaction.Transaction;

public class AddTransactionCommand implements Command, Controllable {
  private Transaction transaction;
  private Category category;

  public AddTransactionCommand(Transaction transaction, Category category){
    this.transaction = transaction;
    this.category = category;
  }

  public void setTransaction(Transaction transaction){
    this.transaction = transaction;
  }

  public void setCategory(Category category){
    this.category = category;
  }

  @Override
  public <T> void control(T t) {

  }

  @Override
  public void execute() {
    category.addTransactionToList(transaction);
  }

  @Override
  public void undo() {
    category.removeTransactionFromList(transaction);

  }
}
