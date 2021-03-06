package com.marianowinar.controller;

import com.marianowinar.gui.History;
import com.marianowinar.gui.Start;
import com.marianowinar.gui.Welcome;
import com.marianowinar.gui.panels.HistoryPanel;
import com.marianowinar.gui.panels.MainPanel;
import com.marianowinar.gui.panels.WelcomePanel;
import com.marianowinar.logic.entity.Pants;
import com.marianowinar.logic.entity.Quotes;
import com.marianowinar.logic.entity.Shirt;
import com.marianowinar.logic.enums.Neck;
import com.marianowinar.logic.enums.TypePants;
import com.marianowinar.logic.enums.TypeShirt;
import com.marianowinar.logic.exception.Exceptions;
import com.marianowinar.logic.exception.InvalidStockException;
import com.marianowinar.logic.factory.FactoryEntities;
import com.marianowinar.logic.messages.MessageError;
import com.marianowinar.logic.messages.MessageInformation;
import com.marianowinar.util.Helper;
import com.marianowinar.util.logger.Errors;
import com.marianowinar.util.validator.Validator;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static com.marianowinar.gui.panels.MainPanel.*;

public class MainController extends Controller{
    private final Start start;
    private final FactoryEntities factory;
    private final Helper helper;
    private final Validator validator;
    private final Errors errors;

    public MainController(Start starts) {
        super(starts);
        this.start = starts;
        this.start.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.start.setVisible(true);
        this.start.getPanel();
        factory = FactoryEntities.getInstance();
        helper = new Helper();
        validator = new Validator();
        errors = Errors.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        MainPanel panel = (MainPanel) start.getPanel();

        switch (actionEvent.getActionCommand()){
            case HISTORY:
                HistoryPanel historyPanel = new HistoryPanel(panel);
                History history= new History(" DETAILS QUOTES SELLER ", historyPanel);
                Controller historyController = new HistoryController(history, panel);
                this.start.dispose();
                break;
            case QUOTE:
                String testPrice = String.valueOf(panel.getPriceGarment().getText());
                String testAmount = String.valueOf(panel.getAmountGarment().getText());

                try{
                    validator.validData(testPrice);
                    validator.validData(testAmount);
                    getQuote(panel, Double.parseDouble(testPrice), Integer.parseInt(testAmount));
                } catch (Exceptions e) {
                    errors.logError(e.getError());
                    new MessageError("Ingreso de Datos", "Ha ingresado datos err??neos o no num??ricos.");
                }
                break;
            case NEW_QUOTES:
                clearComponents(panel);
                Start start = new Start(" EXPRESS QUOTES ", panel);
                Controller mainController = new MainController(start);
                this.start.dispose();
                break;
            case RETURN:
                Welcome welcome = new Welcome("WELCOME QUOTES SYSTEM  ", new WelcomePanel());
                Controller controller = new WelcomeController(welcome);
                this.start.dispose();
                break;
            default:
                new MessageInformation("QUOTES", "THANK YOU FOR USED THIS SYSTEM");
                break;
        }
    }

    private void clearComponents(MainPanel panel) {
        panel.setAmountStock(String.valueOf(" "));
        panel.setDetailQuote(String.valueOf(" "));
        panel.setAmountStock(String.valueOf(" "));
        panel.setPriceGarment(String.valueOf(" "));
        panel.setAmountGarment(String.valueOf(" "));
        panel.getGarmentPant().setSelected(false);
        panel.getGarmentShirt().setSelected(false);
        panel.getShirtShort().setSelected(false);
        panel.getShirtLong().setSelected(false);
        panel.getPantCommon().setSelected(false);
        panel.getPantChupin().setSelected(false);
        panel.getQualityStandard().setSelected(false);
        panel.getQualityPremium().setSelected(false);
        panel.getNeckCommon().setSelected(false);
    }

    private void getQuote(MainPanel mainPanel, double getPrice, int cant) throws InvalidStockException {
        Shirt shirt = null;
        Pants pants = null;
        double finalPrice = 0;
        int stock = 0;

        if(mainPanel.getShirtShort().isSelected() && mainPanel.getNeckMao().isSelected()){
            for(Shirt ele : mainPanel.getListShirt().getList()){
                if(ele.getTypeShirt().equals(TypeShirt.SHORT) && ele.getNeck().equals(Neck.MAO) &&
                        ele.getStock()>0){
                    stock++;
                    shirt = ele;
                }
            }
        }
        if(mainPanel.getShirtShort().isSelected() && mainPanel.getNeckCommon().isSelected()){
            for(Shirt ele : mainPanel.getListShirt().getList()){
                if(ele.getTypeShirt().equals(TypeShirt.SHORT) && ele.getNeck().equals(Neck.COMMON) &&
                        ele.getStock()>0){
                    stock++;
                    shirt = ele;
                }
            }
        }

        if(mainPanel.getShirtLong().isSelected() && mainPanel.getNeckMao().isSelected()){
            for(Shirt ele : mainPanel.getListShirt().getList()){
                if(ele.getTypeShirt().equals(TypeShirt.LONG) && ele.getNeck().equals(Neck.MAO) &&
                        ele.getStock()>0){
                    stock++;
                    shirt = ele;
                }
            }
        }

        if(mainPanel.getShirtLong().isSelected() && mainPanel.getNeckCommon().isSelected()){
            for(Shirt ele : mainPanel.getListShirt().getList()){
                if(ele.getTypeShirt().equals(TypeShirt.LONG) && ele.getNeck().equals(Neck.COMMON) &&
                        ele.getStock()>0){
                    stock++;
                    shirt = ele;
                }
            }
        }

        if(mainPanel.getPantChupin().isSelected()){
            for(Pants ele : mainPanel.getListPants().getList()){
                if(ele.getTypePants().equals(TypePants.CHUPIN) && ele.getStock()>0){
                    stock++;
                    pants = ele;
                }
            }
        }
        if(mainPanel.getPantCommon().isSelected()){
            for(Pants ele : mainPanel.getListPants().getList()){
                if(ele.getTypePants().equals(TypePants.COMMON) && ele.getStock()>0){
                    stock++;
                    pants = ele;
                }
            }
        }

        if(mainPanel.getQualityStandard().isSelected() && mainPanel.getGarmentShirt().isSelected()
                && stock > 0 ){
            finalPrice = helper.calculatePriceStandardShirt(getPrice,shirt) * cant;
        }
        if(mainPanel.getQualityPremium().isSelected() && mainPanel.getGarmentShirt().isSelected()
                && stock > 0 ){
            finalPrice = helper.calculatePricePremiumShirt(getPrice,shirt) * cant;
        }
        if(mainPanel.getQualityStandard().isSelected() && mainPanel.getGarmentPant().isSelected()
                && stock > 0 ){
            finalPrice = helper.calculatePriceStandardPants(getPrice,pants) * cant;
        }
        if(mainPanel.getQualityPremium().isSelected() && mainPanel.getGarmentPant().isSelected()
                && stock > 0){
            finalPrice = helper.calculatePricePremiumPants(getPrice,pants) * cant;
        }

        try{
            validator.validStock(stock);
            Quotes quotes = factory.createQuotes(mainPanel.getListQuotes().listSize(), finalPrice,cant);
            quotes.setNameSeller(mainPanel.getSeller().getName() + " " + mainPanel.getSeller().getSurname());
            mainPanel.getListQuotes().add(quotes);
            mainPanel.setAmountStock(String.valueOf(stock));
            mainPanel.setDetailQuote(String.valueOf(finalPrice));
        } catch (Exceptions e){
            errors.logError(e.getError());
            new MessageError("Stock No Disponible", "Est?? realizando una consulta sobre un producto el cual no hay stock disponible");
        }
    }

}
