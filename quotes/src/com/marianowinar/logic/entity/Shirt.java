package com.marianowinar.logic.entity;

import com.marianowinar.logic.entity.impl.Garment;
import com.marianowinar.logic.enums.Neck;
import com.marianowinar.logic.enums.Quality;
import com.marianowinar.logic.enums.TypeShirt;

public class Shirt extends Garment {
    private Neck neck;
    private TypeShirt typeShirt;

    public Shirt(){}

    public Shirt(Neck neck, TypeShirt typeShirt) {
        this.neck = neck;
        this.typeShirt = typeShirt;
    }

    public Shirt(Long garmentId, String name, String description, Quality quality, double price, int stock, Neck neck, TypeShirt typeShirt) {
        super(garmentId, name, description, quality, price, stock);
        this.neck = neck;
        this.typeShirt = typeShirt;
    }

    public Neck getNeck() {
        return neck;
    }

    public void setNeck(Neck neck) {
        this.neck = neck;
    }

    public TypeShirt getTypeShirt() {
        return typeShirt;
    }

    public void setTypeShirt(TypeShirt typeShirt) {
        this.typeShirt = typeShirt;
    }
}
