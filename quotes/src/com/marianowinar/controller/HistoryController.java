package com.marianowinar.controller;

import com.marianowinar.gui.History;
import com.marianowinar.gui.Welcome;
import com.marianowinar.gui.panels.HistoryPanel;
import com.marianowinar.gui.panels.MainPanel;
import com.marianowinar.gui.panels.WelcomePanel;
import com.marianowinar.logic.messages.MessageInformation;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static com.marianowinar.gui.panels.MainPanel.RETURN;
import static com.marianowinar.gui.panels.WelcomePanel.QUIT;

public class HistoryController extends Controller{

    private final History history;

    public HistoryController(History history, MainPanel panel) {
        super(history, panel);
        this.history = history;
        this.history.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.history.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        HistoryPanel historyPanel = (HistoryPanel) history.getPanel();

        switch (actionEvent.getActionCommand()){
            case RETURN:
                Welcome welcome = new Welcome("WELCOME QUOTES SYSTEM  ", new WelcomePanel());
                Controller controller = new WelcomeController(welcome);
                this.history.dispose();
                break;
            case QUIT:
                new MessageInformation("QUIT PROGRAM", "THANK YOU FOR USED SYSTEM");
                System.exit(0);
                break;
            default:
                new MessageInformation("QUOTES", "THANK YOU FOR USED THIS SYSTEM");
                break;
        }

    }

}
