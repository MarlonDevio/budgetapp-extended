package com.saveandberich.model.pattern.command;

public interface Command {
  void execute();
  void undo();

}
