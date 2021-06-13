package com.marianowinar.util;

import com.marianowinar.logic.entity.Pants;
import com.marianowinar.logic.entity.Shirt;
import com.marianowinar.logic.enums.Neck;
import com.marianowinar.logic.enums.TypePants;
import com.marianowinar.logic.enums.TypeShirt;

public class Helper {

    private static final double DESCUENTO_1 = 0.10;
    private static final double DESCUENTO_2 = 0.12;
    private static final double AUMENTO_1 = 1.03;
    private static final double AUMENTO_2 = 1.3;

    public double calculatePriceStandardShirt(double priceForm, Shirt shirt) {
        return calcShirt(priceForm,shirt);
    }

    public double calculatePricePremiumShirt(double priceForm, Shirt shirt) {
        return calcShirt(priceForm,shirt) * AUMENTO_2;
    }
    private double calcShirt(double priceForm, Shirt shirt) {
        double price = priceForm;

        if(shirt.getTypeShirt().equals(TypeShirt.SHORT)) price = priceForm + (priceForm * - DESCUENTO_1);

        if(shirt.getNeck().equals(Neck.MAO)) price = priceForm * AUMENTO_1;

        if(shirt.getTypeShirt().equals(TypeShirt.SHORT) && shirt.getNeck().equals(Neck.MAO)){
            double aux = priceForm + (priceForm * - DESCUENTO_1);
            price = aux * AUMENTO_1;
        }
        return price;
    }

    public double calculatePriceStandardPants(double priceForm, Pants pants) {
        return calculatePants(priceForm,pants);
    }

    public double calculatePricePremiumPants(double priceForm, Pants pants) {
        return calculatePants(priceForm,pants) * AUMENTO_2;
    }

    private double calculatePants(double priceForm, Pants pants) {
        double price = 0;
        if(pants.getTypePants().equals(TypePants.CHUPIN)){
            price = priceForm + (priceForm * - DESCUENTO_2);
        }
        return price;
    }

}
