package com.saveandberich;

import com.saveandberich.model.financialentities.category.Category;
import com.saveandberich.model.financialentities.category.ExpenseCategory;
import com.saveandberich.model.financialentities.category.IncomeCategory;
import com.saveandberich.model.financialentities.transaction.Transaction;
import com.saveandberich.model.pattern.command.AddTransactionCommand;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

//    ViewController viewController = new ViewController();
//    viewController.init();


    List<Category> categoryList = new ArrayList<>();
    ExpenseCategory expenseCategory = new ExpenseCategory("Expenses", "-");
    ExpenseCategory food = new ExpenseCategory("Food","-");
    ExpenseCategory food2 = new ExpenseCategory("foo","-");

    expenseCategory.addCategory(food);
    expenseCategory.addCategory(food2);
    System.out.println(expenseCategory.getSubCategories().size());

  }
}
