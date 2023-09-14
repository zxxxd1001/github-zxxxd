package com.git.zxxxd.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MyBean {
    private String property;
    private PropertyChangeSupport support;

    public MyBean() {
        support = new PropertyChangeSupport(this);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String newValue) {
        String oldValue = this.property;
        this.property = newValue;
        support.firePropertyChange("property", oldValue, newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
