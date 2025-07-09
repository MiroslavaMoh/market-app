package com.tecdesoftware.market.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {
    private int purcahseID;
    private String clientID;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String State;
    private List<PurchaseItem> item;

    public int getPurcahseID() {
        return purcahseID;
    }

    public void setPurcahseID(int purcahseID) {
        this.purcahseID = purcahseID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public List<PurchaseItem> getItem() {
        return item;
    }

    public void setItem(List<PurchaseItem> item) {
        this.item = item;
    }
}
