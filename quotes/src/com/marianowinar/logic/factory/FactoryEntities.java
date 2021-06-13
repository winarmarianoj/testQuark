package com.marianowinar.logic.factory;

import com.marianowinar.logic.entity.*;
import com.marianowinar.logic.enums.*;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class FactoryEntities {

    private static FactoryEntities factory;

    private FactoryEntities(){}

    public static FactoryEntities getInstance(){
        if(factory == null) factory = new FactoryEntities();

        return factory;
    }

    public Store createStore() {
        Store store = new Store();
        store.setStoreId(Long.valueOf(1));
        store.setName("Store Villa Ballester");
        store.setAddress("Independencia y Alvear");
        return store;
    }

    public Seller createSeller() {
        Seller seller = new Seller();
        seller.setSellerId(Long.valueOf(1));
        seller.setName("Pepe");
        seller.setSurname("Argento");
        seller.setSellerCode("ABC1234");
        return seller;
    }

    public Shirt createShirtShortMao(int i) {
        Shirt shirt = new Shirt();
        shirt.setGarmentId(Long.valueOf(i));
        shirt.setName("shirtShort");
        shirt.setTypeShirt(TypeShirt.SHORT);
        shirt.setNeck(Neck.MAO);
        shirt.setStock(i+1);
        shirt.setQuality(Quality.PREMIUM);
        shirt.setPrice(0);
        return shirt;
    }

    public Shirt createShirtShortNormal(int i) {
        Shirt shirt = new Shirt();
        shirt.setGarmentId(Long.valueOf(i));
        shirt.setName("shirtShort");
        shirt.setTypeShirt(TypeShirt.SHORT);
        shirt.setNeck(Neck.COMMON);
        shirt.setStock(i+1);
        shirt.setQuality(Quality.STANDARD);
        shirt.setPrice(0);
        return shirt;
    }

    public Shirt createShirtLongMao(int i) {
        Shirt shirt = new Shirt();
        shirt.setGarmentId(Long.valueOf(i));
        shirt.setName("shirtShort");
        shirt.setTypeShirt(TypeShirt.LONG);
        shirt.setNeck(Neck.MAO);
        shirt.setStock(i+1);
        shirt.setQuality(Quality.PREMIUM);
        shirt.setPrice(0);
        return shirt;
    }

    public Shirt createShirtLongNormal(int i) {
        Shirt shirt = new Shirt();
        shirt.setGarmentId(Long.valueOf(i));
        shirt.setName("shirtShort");
        shirt.setTypeShirt(TypeShirt.LONG);
        shirt.setNeck(Neck.COMMON);
        shirt.setStock(i+1);
        shirt.setQuality(Quality.STANDARD);
        shirt.setPrice(0);
        return shirt;
    }

    public Pants createPantsChupin(int i) {
        Pants pants = new Pants();
        pants.setGarmentId(Long.valueOf(i));
        pants.setName("PantsChupin");
        pants.setTypePants(TypePants.CHUPIN);
        pants.setQuality(Quality.PREMIUM);
        pants.setCloth(Cloth.COMMON);
        pants.setStock(i + 1);
        pants.setPrice(0);
        return pants;
    }

    public Pants createPantsCommon(int i) {
        Pants pants = new Pants();
        pants.setGarmentId(Long.valueOf(i));
        pants.setName("PantsChupin");
        pants.setTypePants(TypePants.COMMON);
        pants.setQuality(Quality.STANDARD);
        pants.setCloth(Cloth.COMMON);
        pants.setStock(i + 1);
        pants.setPrice(0);
        return pants;
    }

    public Quotes createQuotes(int amountQuotes, double finalPrice, int amountForm) {
        Quotes quotes = new Quotes();
        quotes.setQuotesId(Long.valueOf(amountQuotes+1));
        quotes.setRegdate(LocalDateTime.now());
        quotes.setQuotesAmount(amountForm);
        quotes.setTotalQuotes(finalPrice);
        return  quotes;
    }
}
