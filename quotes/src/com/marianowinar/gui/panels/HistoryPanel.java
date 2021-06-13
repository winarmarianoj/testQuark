package com.marianowinar.gui.panels;

import com.marianowinar.controller.Controller;
import com.marianowinar.logic.entity.Quotes;

import static com.marianowinar.gui.History.BG;

import javax.swing.*;
import java.awt.*;

public class HistoryPanel extends Panel{

    public static final int PANEL_WIDTH = 1800;
    public static final int PANEL_HEIGHT = 1000;
    public static final int MARGIN = 20;
    public static final int MARGIN_Y = 80;

    public static final String EXIT = "QUIT";
    public static final String RETURN = "RETURN MENU";

    private final int BUTTON_WIDTH = 260;
    private final int BUTTON_HEIGHT = 50;

    private JButton btnQUIT;
    private JButton btnReturn;
    private JTextArea area;

    public HistoryPanel(MainPanel panel){ printInformation(panel);}

    private void printInformation(MainPanel panel) {
        for(Quotes ele : panel.getListQuotes().getList()){
            setArea(ele.toString());
        }
    }

    @Override
    protected void init() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(BG);

        area = new JTextArea();
        area.setFont(new Font("Arial", Font.PLAIN,16));
        area.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        area.setLocation( MARGIN + 20, MARGIN_Y);
        area.setSize(new Dimension(1700,700));
        area.setFocusable(false);
        area.setBackground(Color.white);
        add(area);

        btnReturn = new JButton(RETURN);
        btnReturn.setActionCommand(RETURN);
        btnReturn.setFont(new Font("Arial", Font.BOLD,23));
        btnReturn.setForeground(Color.black);
        btnReturn.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnReturn.setLocation( MARGIN + 100, MARGIN_Y + 800);
        btnReturn.setFocusable(false);
        btnReturn.setBackground(Color.YELLOW);
        add(btnReturn);

        btnQUIT = new JButton(EXIT);
        btnQUIT.setActionCommand(EXIT);
        btnQUIT.setFont(new Font("Arial", Font.BOLD,22));
        btnQUIT.setForeground(Color.black);
        btnQUIT.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnQUIT.setLocation(MARGIN + 500, MARGIN_Y + 800);
        btnQUIT.setFocusable(false);
        btnQUIT.setBackground(Color.ORANGE);
        add(btnQUIT);
    }

    @Override
    public void setController(Controller controller) {
        btnReturn.addActionListener(controller);
        btnQUIT.addActionListener(controller);
    }

    public JTextArea getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area.setText(area);
    }
}
