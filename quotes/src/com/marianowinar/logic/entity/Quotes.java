package com.marianowinar.logic.entity;

import com.marianowinar.logic.entity.impl.Garment;

import java.time.LocalDateTime;
import java.util.List;

public class Quotes {
    private Long quotesId;
    private LocalDateTime regdate;
    private String nameSeller;
    private int quotesAmount;
    private double totalQuotes;

    public Quotes() { }

    public Quotes(Long quotesId, LocalDateTime regdate, String nameSeller,
                  List<Garment> garmentList, int quotesAmount, double totalQuotes) {
        this.quotesId = quotesId;
        this.regdate = regdate;
        this.nameSeller = nameSeller;
        this.quotesAmount = quotesAmount;
        this.totalQuotes = totalQuotes;
    }

    public Long getQuotesId() {
        return quotesId;
    }

    public void setQuotesId(Long quotesId) {
        this.quotesId = quotesId;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }

    public String getNameSeller() {
        return nameSeller;
    }

    public void setNameSeller(String nameSeller) {
        this.nameSeller = nameSeller;
    }

    public int getQuotesAmount() {
        return quotesAmount;
    }

    public void setQuotesAmount(int quotesAmount) {
        this.quotesAmount = quotesAmount;
    }

    public double getTotalQuotes() {
        return totalQuotes;
    }

    public void setTotalQuotes(double totalQuotes) {
        this.totalQuotes = totalQuotes;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "quotesId=" + quotesId +
                ", regdate=" + regdate +
                ", nameSeller='" + nameSeller + '\'' +
                ", quotesAmount=" + quotesAmount +
                ", totalQuotes=" + totalQuotes +
                '}';
    }
}
