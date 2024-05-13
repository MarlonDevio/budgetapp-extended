package com.saveandberich.model.pattern.observer;

/**
 * The Subject interface represents the subject in the Observer pattern.
 * It defines the methods for registering, removing, and notifying observers.
 */
public interface Subject {
  void registerObserver(Observer o);

  void removeObserver(Observer o);

  void notifyObservers();
}
