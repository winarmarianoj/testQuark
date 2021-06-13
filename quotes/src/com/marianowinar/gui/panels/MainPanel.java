package com.marianowinar.gui.panels;

import com.marianowinar.controller.Controller;
import com.marianowinar.logic.entity.Pants;
import com.marianowinar.logic.entity.Seller;
import com.marianowinar.logic.entity.Shirt;
import com.marianowinar.logic.entity.Store;
import com.marianowinar.logic.factory.FactoryEntities;
import com.marianowinar.mapper.ListMapper;
import com.marianowinar.persistance.impl.ListPants;
import com.marianowinar.persistance.impl.ListQuotes;
import com.marianowinar.persistance.impl.ListShirt;

import static com.marianowinar.gui.Start.BG;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainPanel extends Panel{

    private Store store;
    private Seller seller;
    private final FactoryEntities factory;
    private final ListPants listPants;
    private final ListQuotes listQuotes;
    private final ListShirt listShirt;
    private final ListMapper mapper;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 900;
    private static final int MARGIN = 20;
    public static final int MARGIN_Y = 40;

    public static final String HISTORY = "HISTORY QUOTES";
    public static final String QUOTE = "QUOTE";
    public static final String RETURN = "RETURN MENU";

    public static final String GARMENT_PANT = "PANT";
    public static final String PANT_CHUPIN = "PANT CHUPIN";
    public static final String PANT_COMMON = "PANT COMMON";
    public static final String GARMENT_SHIRT = "SHIRT";
    public static final String SHIRT_SHORT = "SLEEVE SHORT";
    public static final String SHIRT_LONG = "SLEEVE LONG";
    public static final String NECK_COMMON = "NECK COMMON";
    public static final String NECK_MAO = "NECK MAO";
    public static final String QUALITY_STANDARD = "STANDARD";
    public static final String QUALITY_PREMIUM = "PREMIUM";
    public static final String STOCK = "STOCK AVAILABLE";
    public static final String QUALITY = "QUALITY GARMENT";
    public static final String PRICE = "PRICE GARMENT";
    public static final String SYMBOL = "$ ";
    public static final String AMOUNT = "AMOUNT ";
    public static final String NEW_QUOTES = "NEW QUOTES";

    private final int BUTTON_WIDTH = 320;
    private final int BUTTON_HEIGHT = 50;

    private final int JLABEL_WIDTH = 300;
    private final int JLABEL_HEIGHT = 50;
    private final int TEXT_WIDTH = 400;
    private final int TEXT_HEIGHT = 50;

    private JButton btnHistory;
    private JButton btnQuote;
    private JButton btnReturn;
    private JButton btnNewQuote;

    private JCheckBox garmentPant;
    private JCheckBox pantChupin;
    private JCheckBox pantCommon;
    private JCheckBox garmentShirt;
    private JCheckBox shirtShort;
    private JCheckBox shirtLong;
    private JCheckBox neckCommon;
    private JCheckBox neckMao;
    private JCheckBox qualityStandard;
    private JCheckBox qualityPremium;

    private JLabel nameSeller;
    private JLabel nameStore;
    private JLabel addressStore;
    private JLabel prenda;
    private JLabel stock;
    private JLabel quality;
    private JLabel price;
    private JLabel symbolPrice;
    private JLabel amount;
    private JTextField namesSeller;
    private JTextField namesStore;
    private JTextField addressStores;
    private JTextField amountStock;
    private JTextField priceGarment;
    private JTextField amountGarment;
    private JTextField detailQuote;

    public MainPanel(){
        this.factory = FactoryEntities.getInstance();
        this.seller = factory.createSeller();
        this.store = factory.createStore();
        setNamesStore(this.store.getName());
        setNamesSeller(this.seller.getName() + " " + this.seller.getSurname());
        setAddressStores(this.store.getAddress());
        listPants = new ListPants();
        listQuotes = new ListQuotes();
        listShirt = new ListShirt();
        mapper = new ListMapper();
        createEntities();
    }

    private void createEntities() {
        java.util.List<Shirt> shirtShortList = mapper.createShirtShort();
        java.util.List<Shirt> shirtLongList = mapper.createShirtLong();
        java.util.List<Pants> pantsChupinList = mapper.createPantChupin();
        List<Pants> pantsCommonList = mapper.createPantCommon();
        this.listShirt.addList(shirtShortList);
        this.listShirt.addList(shirtLongList);
        this.listPants.addList(pantsChupinList);
        this.listPants.addList(pantsCommonList);
    }

    @Override
    protected void init() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(BG);

        nameStore = new JLabel(" Store Names : ");
        nameStore.setFont(new Font("Arial", Font.BOLD, 22));
        nameStore.setForeground(Color.red);
        nameStore.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        nameStore.setLocation(MARGIN, MARGIN_Y);
        add(nameStore, BorderLayout.NORTH);

        namesStore = new JTextField();
        namesStore.setFont(new Font("Serif", Font.PLAIN, 30));
        namesStore.setForeground(Color.black);
        namesStore.setSize(TEXT_WIDTH , TEXT_HEIGHT);
        namesStore.setLocation(MARGIN + 250 ,MARGIN_Y);
        add(namesStore);

        nameSeller = new JLabel(" Seller Names : ");
        nameSeller.setFont(new Font("Arial", Font.BOLD, 22));
        nameSeller.setForeground(Color.red);
        nameSeller.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        nameSeller.setLocation(MARGIN, MARGIN_Y + 70);
        add(nameSeller, BorderLayout.NORTH);

        namesSeller = new JTextField();
        namesSeller.setFont(new Font("Serif", Font.PLAIN, 30));
        namesSeller.setForeground(Color.black);
        namesSeller.setSize(TEXT_WIDTH , TEXT_HEIGHT);
        namesSeller.setLocation(MARGIN + 250,MARGIN_Y + 70);
        add(namesSeller);

        addressStore = new JLabel(" Address Store : ");
        addressStore.setFont(new Font("Arial", Font.BOLD, 22));
        addressStore.setForeground(Color.red);
        addressStore.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        addressStore.setLocation(MARGIN + 650, MARGIN_Y);
        add(addressStore, BorderLayout.NORTH);

        addressStores = new JTextField();
        addressStores.setFont(new Font("Serif", Font.PLAIN, 30));
        addressStores.setForeground(Color.black);
        addressStores.setSize(TEXT_WIDTH , TEXT_HEIGHT);
        addressStores.setLocation(MARGIN + 950,MARGIN_Y);
        add(addressStores);

        btnHistory = new JButton(HISTORY);
        btnHistory.setActionCommand(HISTORY);
        btnHistory.setFont(new Font("Arial", Font.BOLD,23));
        btnHistory.setForeground(Color.white);
        btnHistory.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnHistory.setLocation( MARGIN + 950, MARGIN_Y + 70);
        btnHistory.setFocusable(false);
        btnHistory.setBackground(Color.MAGENTA);
        add(btnHistory);

        prenda = new JLabel(" Prenda : ");
        prenda.setFont(new Font("Arial", Font.BOLD, 22));
        prenda.setForeground(Color.red);
        prenda.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        prenda.setLocation(MARGIN + 50, MARGIN_Y + 130);
        add(prenda, BorderLayout.NORTH);

        garmentShirt = new JCheckBox();
        garmentShirt.setText(GARMENT_SHIRT);
        garmentShirt.setBounds(MARGIN + 50,MARGIN_Y + 200,150,40);
        add(garmentShirt);

        shirtShort = new JCheckBox();
        shirtShort.setText(SHIRT_SHORT);
        shirtShort.setBounds(MARGIN + 210,MARGIN_Y + 200,150,40);
        add(shirtShort);

        shirtLong = new JCheckBox();
        shirtLong.setText(SHIRT_LONG);
        shirtLong.setBounds(MARGIN + 370,MARGIN_Y + 200,150,40);
        add(shirtLong);

        neckCommon = new JCheckBox();
        neckCommon.setText(NECK_COMMON);
        neckCommon.setBounds(MARGIN + 530,MARGIN_Y + 200,150,40);
        add(neckCommon);

        neckMao = new JCheckBox();
        neckMao.setText(NECK_MAO);
        neckMao.setBounds(MARGIN + 690,MARGIN_Y + 200,150,40);
        add(neckMao);

        garmentPant = new JCheckBox();
        garmentPant.setText(GARMENT_PANT);
        garmentPant.setBounds(MARGIN + 50,MARGIN_Y + 300,150,40);
        add(garmentPant);

        pantChupin = new JCheckBox();
        pantChupin.setText(PANT_CHUPIN);
        pantChupin.setBounds(MARGIN + 210,MARGIN_Y + 300,150,40);
        add(pantChupin);

        pantCommon = new JCheckBox();
        pantCommon.setText(PANT_COMMON);
        pantCommon.setBounds(MARGIN + 370,MARGIN_Y + 300,150,40);
        add(pantCommon);

        stock = new JLabel(STOCK);
        stock.setFont(new Font("Arial", Font.BOLD, 22));
        stock.setForeground(Color.red);
        stock.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        stock.setLocation(MARGIN + 50, MARGIN_Y + 400);
        add(stock, BorderLayout.NORTH);

        amountStock = new JTextField();
        amountStock.setFont(new Font("Serif", Font.PLAIN, 30));
        amountStock.setForeground(Color.black);
        amountStock.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        amountStock.setLocation(MARGIN + 420,MARGIN_Y + 400);
        add(amountStock);

        quality = new JLabel(QUALITY);
        quality.setFont(new Font("Arial", Font.BOLD, 22));
        quality.setForeground(Color.red);
        quality.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        quality.setLocation(MARGIN + 50, MARGIN_Y + 500);
        add(quality, BorderLayout.NORTH);

        qualityStandard = new JCheckBox();
        qualityStandard.setText(QUALITY_STANDARD);
        qualityStandard.setBounds(MARGIN + 50,MARGIN_Y + 580,150,40);
        add(qualityStandard);

        qualityPremium = new JCheckBox();
        qualityPremium.setText(QUALITY_PREMIUM);
        qualityPremium.setBounds(MARGIN + 210,MARGIN_Y + 580,150,40);
        add(qualityPremium);

        price = new JLabel(PRICE);
        price.setFont(new Font("Arial", Font.BOLD, 22));
        price.setForeground(Color.red);
        price.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        price.setLocation(MARGIN + 500, MARGIN_Y + 500);
        add(price, BorderLayout.NORTH);

        symbolPrice = new JLabel(SYMBOL);
        symbolPrice.setFont(new Font("Arial", Font.BOLD, 22));
        symbolPrice.setForeground(Color.red);
        symbolPrice.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        symbolPrice.setLocation(MARGIN + 500, MARGIN_Y + 580);
        add(symbolPrice, BorderLayout.NORTH);

        priceGarment = new JTextField();
        priceGarment.setFont(new Font("Serif", Font.PLAIN, 30));
        priceGarment.setForeground(Color.black);
        priceGarment.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        priceGarment.setLocation(MARGIN + 550,MARGIN_Y + 580);
        add(priceGarment);

        amount = new JLabel(AMOUNT);
        amount.setFont(new Font("Arial", Font.BOLD, 22));
        amount.setForeground(Color.red);
        amount.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        amount.setLocation(MARGIN + 880, MARGIN_Y + 580);
        add(amount, BorderLayout.NORTH);

        amountGarment = new JTextField();
        amountGarment.setFont(new Font("Serif", Font.PLAIN, 30));
        amountGarment.setForeground(Color.black);
        amountGarment.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        amountGarment.setLocation(MARGIN + 1000,MARGIN_Y + 580);
        add(amountGarment);

        btnQuote = new JButton(QUOTE);
        btnQuote.setActionCommand(QUOTE);
        btnQuote.setFont(new Font("Arial", Font.BOLD,23));
        btnQuote.setForeground(Color.black);
        btnQuote.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnQuote.setLocation( MARGIN + 50, MARGIN_Y + 750);
        btnQuote.setFocusable(false);
        btnQuote.setBackground(Color.GREEN);
        add(btnQuote);

        detailQuote = new JTextField();
        detailQuote.setFont(new Font("Serif", Font.PLAIN, 30));
        detailQuote.setForeground(Color.black);
        detailQuote.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        detailQuote.setLocation(MARGIN + 450,MARGIN_Y + 750);
        add(detailQuote);

        btnNewQuote = new JButton(NEW_QUOTES);
        btnNewQuote.setActionCommand(NEW_QUOTES);
        btnNewQuote.setFont(new Font("Arial", Font.BOLD,23));
        btnNewQuote.setForeground(Color.black);
        btnNewQuote.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnNewQuote.setLocation( MARGIN + 1200, MARGIN_Y + 700);
        btnNewQuote.setFocusable(false);
        btnNewQuote.setBackground(Color.MAGENTA);
        add(btnNewQuote);

        btnReturn = new JButton(RETURN);
        btnReturn.setActionCommand(RETURN);
        btnReturn.setFont(new Font("Arial", Font.BOLD,23));
        btnReturn.setForeground(Color.white);
        btnReturn.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnReturn.setLocation( MARGIN + 1200, MARGIN_Y + 800);
        btnReturn.setFocusable(false);
        btnReturn.setBackground(Color.blue);
        add(btnReturn);

    }

    @Override
    public void setController(Controller controller) {
        btnHistory.addActionListener(controller);
        btnQuote.addActionListener(controller);
        btnReturn.addActionListener(controller);
        btnNewQuote.addActionListener(controller);
    }

    public void setNamesSeller(String namesSeller) {
        this.namesSeller.setText(namesSeller);
    }

    public void setNamesStore(String namesStore) {
        this.namesStore.setText(namesStore);
    }

    public void setAddressStores(String addressStores) {
        this.addressStores.setText(addressStores);
    }

    public void setAmountStock(String amountStock) {
        this.amountStock.setText(amountStock);
    }

    public void setPriceGarment(String priceGarment) {
        this.priceGarment.setText(priceGarment);
    }

    public void setAmountGarment(String amountGarment) {
        this.amountGarment.setText(amountGarment);
    }

    public void setDetailQuote(String detailQuote) {
        this.detailQuote.setText(detailQuote);
    }

    public JTextField getNamesSeller() {
        return namesSeller;
    }

    public JTextField getNamesStore() {
        return namesStore;
    }

    public JTextField getAddressStores() {
        return addressStores;
    }

    public JTextField getAmountStock() {
        return amountStock;
    }

    public JTextField getPriceGarment() {
        return priceGarment;
    }

    public JTextField getAmountGarment() {
        return amountGarment;
    }

    public JTextField getDetailQuote() {
        return detailQuote;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }



    public JCheckBox getGarmentPant() {
        return garmentPant;
    }

    public void setGarmentPant(JCheckBox garmentPant) {
        this.garmentPant = garmentPant;
    }

    public JCheckBox getPantChupin() {
        return pantChupin;
    }

    public void setPantChupin(JCheckBox pantChupin) {
        this.pantChupin = pantChupin;
    }

    public JCheckBox getPantCommon() {
        return pantCommon;
    }

    public void setPantCommon(JCheckBox pantCommon) {
        this.pantCommon = pantCommon;
    }

    public JCheckBox getGarmentShirt() {
        return garmentShirt;
    }

    public void setGarmentShirt(JCheckBox garmentShirt) {
        this.garmentShirt = garmentShirt;
    }

    public JCheckBox getShirtShort() {
        return shirtShort;
    }

    public void setShirtShort(JCheckBox shirtShort) {
        this.shirtShort = shirtShort;
    }

    public JCheckBox getShirtLong() {
        return shirtLong;
    }

    public void setShirtLong(JCheckBox shirtLong) {
        this.shirtLong = shirtLong;
    }

    public JCheckBox getNeckCommon() {
        return neckCommon;
    }

    public void setNeckCommon(JCheckBox neckCommon) {
        this.neckCommon = neckCommon;
    }

    public JCheckBox getNeckMao() {
        return neckMao;
    }

    public void setNeckMao(JCheckBox neckMao) {
        this.neckMao = neckMao;
    }

    public JCheckBox getQualityStandard() {
        return qualityStandard;
    }

    public void setQualityStandard(JCheckBox qualityStandard) {
        this.qualityStandard = qualityStandard;
    }

    public JCheckBox getQualityPremium() {
        return qualityPremium;
    }

    public void setQualityPremium(JCheckBox qualityPremium) {
        this.qualityPremium = qualityPremium;
    }

    public ListPants getListPants() {
        return listPants;
    }

    public ListQuotes getListQuotes() {
        return listQuotes;
    }

    public ListShirt getListShirt() {
        return listShirt;
    }
}
