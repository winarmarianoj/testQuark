package com.marianowinar.gui;

import com.marianowinar.controller.Controller;
import com.marianowinar.gui.panels.Panel;

import javax.swing.*;
import java.awt.*;

public class Start extends JFrame {
    public static final Color BG = Color.orange;
    private Panel panel;

    public Start(String title, Panel panel) throws HeadlessException {
        init(panel,title);
        setLocationRelativeTo(null);
    }

    /**
     * Funcion de inicio
     * @param panel tipo dato Panel
     * @param title String con el titulo
     */
    private void init(Panel panel, String title) {
        setTitle(title);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.panel = panel;
        add((panel));
        pack();
    }

    /**
     * Devuelve panel de Panel
     * @return tipo de dato Panel
     */
    public Panel getPanel(){return panel;}

    /**
     * Setea el Controlador
     * @param controller tipo de dato Controller
     */
    public void setController(Controller controller){
        panel.setController(controller);
    }
}
