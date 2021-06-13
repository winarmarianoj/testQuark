package com.marianowinar.controller;

import com.marianowinar.gui.Start;
import com.marianowinar.gui.Welcome;
import com.marianowinar.gui.panels.MainPanel;
import com.marianowinar.gui.panels.WelcomePanel;
import com.marianowinar.logic.messages.MessageInformation;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static com.marianowinar.gui.panels.WelcomePanel.*;

public class WelcomeController extends Controller{

    private final Welcome welcome;
    private final MainPanel mainPanel;

    public WelcomeController(Welcome welcome) {
        super(welcome);
        this.welcome = welcome;
        this.welcome.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.welcome.setVisible(true);
        this.welcome.getPanel();
        this.mainPanel = new MainPanel();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        WelcomePanel panel = (WelcomePanel) welcome.getPanel();

        switch (actionEvent.getActionCommand()){
            case START:
                Start start = new Start(" EXPRESS QUOTES ", mainPanel);
                Controller mainController = new MainController(start);
                welcome.dispose();
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
