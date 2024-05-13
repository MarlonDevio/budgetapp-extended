package com.saveandberich.model.pattern.observer;

import com.saveandberich.model.service.UpdatedInfo;

/**
 * The Observer interface represents an object that observes changes in the
 * subject.
 * It provides a method for updating the observer with new information.
 */
public interface Observer {
  /**
   * Updates the observer with new information.
   *
   * @param info the updated information
   */
  void update(UpdatedInfo info);
}
