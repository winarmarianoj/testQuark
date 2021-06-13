package com.marianowinar.mapper;

import com.marianowinar.logic.entity.Pants;
import com.marianowinar.logic.entity.Shirt;
import com.marianowinar.logic.factory.FactoryEntities;
import com.marianowinar.persistance.impl.ListShirt;

import java.util.ArrayList;
import java.util.List;

public class ListMapper {

    private FactoryEntities factory;

    public ListMapper() {
        this.factory = FactoryEntities.getInstance();
    }

    private static final int AMOUNT_SHORT_MAO = 200;
    private static final int AMOUNT_SHORT_NORMAL = 300;

    private static final int AMOUNT_LONG_MAO = 150;
    private static final int AMOUNT_LONG_NORMAL = 350;

    private static final int AMOUNT_PANTS_CHUPIN = 1500;
    private static final int AMOUNT_PANTS_COMMON = 500;

    public List<Shirt> createShirtShort() {
        List<Shirt> listShirt = new ArrayList<>();

        for(int i=0; i<AMOUNT_SHORT_MAO; i++){
            Shirt shortMao = factory.createShirtShortMao(i);
            listShirt.add(shortMao);
        }

        for(int i=0; i<AMOUNT_SHORT_NORMAL; i++){
            Shirt shortMao = factory.createShirtShortNormal(i);
            listShirt.add(shortMao);
        }
        return listShirt;
    }

    public List<Shirt> createShirtLong() {
        List<Shirt> listShirt = new ArrayList<>();

        for(int i=0; i<AMOUNT_LONG_MAO; i++){
            Shirt shortMao = factory.createShirtLongMao(i);
            listShirt.add(shortMao);
        }

        for(int i=0; i<AMOUNT_LONG_NORMAL; i++){
            Shirt shortMao = factory.createShirtLongNormal(i);
            listShirt.add(shortMao);
        }
        return listShirt;
    }

    public List<Pants> createPantChupin() {
        List<Pants> listPants = new ArrayList<>();

        for(int i=0; i<AMOUNT_PANTS_CHUPIN; i++){
            Pants pantsChupin = factory.createPantsChupin(i);
            listPants.add(pantsChupin);
        }

        return listPants;
    }

    public List<Pants> createPantCommon() {
        List<Pants> listPants = new ArrayList<>();

        for(int i=0; i<AMOUNT_PANTS_COMMON; i++){
            Pants pantsChupin = factory.createPantsCommon(i);
            listPants.add(pantsChupin);
        }

        return listPants;
    }
}
