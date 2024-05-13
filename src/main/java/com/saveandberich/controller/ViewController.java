package com.saveandberich.controller;

import com.saveandberich.model.pattern.factory.TransactionFactory;
import com.saveandberich.model.service.BankAccountService;
import com.saveandberich.view.ActionView;
import com.saveandberich.view.BalanceView;
import com.saveandberich.view.IncomeView;
import com.saveandberich.view.PurchaseListView;
import com.saveandberich.view.PurchaseView;
import com.saveandberich.view.View;

/**
 * The ViewController class handles the main logic and flow of the SaveAndBeRich
 * application.
 * It manages the different views and user interactions.
 */
public class ViewController  {

  BankAccountService bankAccountService = BankAccountService.getInstance();
  TransactionFactory transactionFactory = new TransactionFactory();
  View currentView;
  View incomeView = new IncomeView();
  View purchaseView = new PurchaseView();
  View purchaseListView = new PurchaseListView();
  View actionView = new ActionView();
  View balanceView = new BalanceView();

  {
    bankAccountService.registerObserver(incomeView);
    bankAccountService.registerObserver(purchaseView);
    bankAccountService.registerObserver(purchaseListView);
    bankAccountService.registerObserver(actionView);
    bankAccountService.registerObserver(balanceView);
    bankAccountService.notifyObservers();
  }

  /**
   * Initializes the SaveAndBeRich application.
   * Starts the main loop for user interactions.
   */
  public void init() {

    // 1) Start
    while (true) {
      displayActionMenu();
      if (currentView.getUserInput().equals("0")) {
        System.out.println("");
        System.out.println("Bye!");
        return;
      }
      System.out.println("");
      handleUserChoice();
      System.out.println("");
    }
  }

  private void displayActionMenu() {
    setView(actionView);
    currentView.display();
  }

  private void setView(View view) {
    this.currentView = view;
  }

  /*
   * *********************************
   * USER-CHOICE LOGIC
   ***********************************/

  private void handleUserChoice() {
    switch (currentView.getUserInput()) {
      case "1" -> {
        setView(incomeView);
        currentView.display();
        double amount = Double.parseDouble(currentView.getUserInput());
        bankAccountService.addTransaction(transactionFactory.create("", amount, "+"));
      }
      case "2" -> {
        setView(purchaseView);
        currentView.display();
        double amount = currentView.getDoubleInput();
        String description = currentView.getUserInput();
        bankAccountService.addTransaction(transactionFactory.create(description, amount, "-"));
      }
      case "3" -> {
        setView(purchaseListView);
        currentView.display();
      }
      case "4" -> {
        setView(balanceView);
        currentView.display();
      }
    }
  }


}
