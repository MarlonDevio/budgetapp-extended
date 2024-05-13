package com.saveandberich.controller;

import com.saveandberich.model.pattern.command.Command;

public class MainController {

  private Command slot;

  public MainController() {
  }

  public void setCommand(Command command) {
    slot = command;
  }

  public void CommandWasRequested(){
    slot.execute();
  }


}
