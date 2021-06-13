package com.marianowinar.logic.entity;

import com.marianowinar.logic.entity.impl.Garment;
import com.marianowinar.logic.enums.Cloth;
import com.marianowinar.logic.enums.Quality;
import com.marianowinar.logic.enums.TypePants;

public class Pants extends Garment {
    private Cloth cloth;
    private TypePants typePants;

    public Pants(){}

    public Pants(Cloth cloth, TypePants typePants) {
        this.cloth = cloth;
        this.typePants = typePants;
    }

    public Pants(Long garmentId, String name, String description, Quality quality, double price, int stock, Cloth cloth, TypePants typePants) {
        super(garmentId, name, description, quality, price, stock);
        this.cloth = cloth;
        this.typePants = typePants;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public TypePants getTypePants() {
        return typePants;
    }

    public void setTypePants(TypePants typePants) {
        this.typePants = typePants;
    }
}
