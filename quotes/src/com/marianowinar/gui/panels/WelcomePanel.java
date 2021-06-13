package com.marianowinar.gui.panels;

import com.marianowinar.controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class WelcomePanel extends Panel{

    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 500;
    private static final int IMAGE_WIDTH = 800;
    private static final int IMAGE_HEIGHT = 500;
    private static final int MARGIN = 20;
    public static final int MARGIN_Y = 80;

    public static final String START = "START";
    public static final String QUIT = "QUIT";

    private final int BUTTON_WIDTH = 260;
    private final int BUTTON_HEIGHT = 50;

    private JButton btnStart;
    private JButton btnQuit;

    @Override
    protected void init() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));

        btnStart = new JButton(START);
        btnStart.setActionCommand(START);
        btnStart.setFont(new Font("Arial", Font.BOLD,24));
        btnStart.setForeground(Color.white);
        btnStart.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnStart.setLocation( MARGIN, PANEL_HEIGHT - MARGIN - MARGIN_Y );
        btnStart.setFocusable(false);
        btnStart.setBackground(Color.blue);
        add(btnStart);

        btnQuit = new JButton(QUIT);
        btnQuit.setActionCommand(QUIT);
        btnQuit.setFont(new Font("Arial", Font.BOLD,24));
        btnQuit.setForeground(Color.white);
        btnQuit.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnQuit.setLocation( MARGIN + 500, PANEL_HEIGHT - MARGIN - MARGIN_Y  );
        btnQuit.setFocusable(false);
        btnQuit.setBackground(Color.blue);
        add(btnQuit);

        JLabel jLabel = new JLabel(" ");
        jLabel.setSize(IMAGE_WIDTH,IMAGE_HEIGHT);
        jLabel.setLocation(0,0);
        jLabel.setBorder(new LineBorder(new Color(0,0,0),3,true));
        jLabel.setIcon(new ImageIcon("images/planet.jpg"));
        add(jLabel);
    }

    @Override
    public void setController(Controller controller) {
        btnStart.addActionListener(controller);
        btnQuit.addActionListener(controller);
    }
}
