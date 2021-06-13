package com.marianowinar;

import com.marianowinar.controller.Controller;
import com.marianowinar.controller.WelcomeController;
import com.marianowinar.gui.Welcome;
import com.marianowinar.gui.panels.WelcomePanel;

public class Main {

    public static void main(String[] args) {
        Welcome welcome = new Welcome("WELCOME QUOTES SYSTEM", new WelcomePanel());
        Controller controller = new WelcomeController(welcome);
    }
}
