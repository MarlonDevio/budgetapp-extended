package com.saveandberich.model.financialentities.transaction;

import com.saveandberich.model.financialentities.category.Category;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

  private static int globalTransactionCounter;
  private final int TRANSACTION_NUMBER = globalTransactionCounter;
  private final String id;
  private String description;
  private Category category;

  private String type;
  private double amount;
  private LocalDate date;

  {
    globalTransactionCounter++;
    date = LocalDate.now();
    id = TRANSACTION_NUMBER + "-" + date.toString().replaceAll("-", "");
  }


  public Transaction(String description, double amount, String type) {
    this.description = description;
    this.amount=amount;
    if (!setType(type)) {
      this.type = null;
    }
  }

  /* *************************************
  * GETTERS AND SETTERS
  ***************************************/

  public int getTRANSACTION_NUMBER() {
    return TRANSACTION_NUMBER;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public Category getCategory() {
    return category;
  }

  public double getAmount() {
    return amount;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getType() {
    return type;
  }

  public boolean setType(String type) {
    if (type.equals("+") || type.equals("-")) {
      this.type = type;
      return true;
    }
    System.out.println("The type should be '+' or '-'. Assigned type is null");
    return false;
  }

  /* *************************************
  * OVERRIDES
  ***************************************/

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Transaction that)) {
      return false;
    }
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
