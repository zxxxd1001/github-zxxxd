package com.git.zxxxd.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyObservers implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        Object oldValue = evt.getOldValue();
        Object newValue = evt.getNewValue();

        System.out.println("Property " + propertyName + " changed from " + oldValue + " to " + newValue);
    }
}
