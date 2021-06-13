package com.marianowinar.gui.panels;

import com.marianowinar.controller.Controller;

import javax.swing.*;

public abstract class Panel extends JPanel {

    public Panel (){
        this.setLayout(null);
        init();
    }
    protected abstract void init();
    public abstract void setController(Controller controller);
}
