package com.marianowinar.controller;

import com.marianowinar.gui.History;
import com.marianowinar.gui.Start;
import com.marianowinar.gui.Welcome;
import com.marianowinar.gui.panels.MainPanel;

import java.awt.event.ActionListener;

public abstract class Controller implements ActionListener {
    public Controller(Welcome welcome){welcome.setController(this);}
    public Controller(Start start){start.setController(this);}
    public Controller(History history, MainPanel mainPanel){history.setController(this);}
}
