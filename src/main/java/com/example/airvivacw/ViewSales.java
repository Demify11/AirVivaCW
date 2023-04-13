package com.example.airvivacw;

public class ViewSales {
    private int id;
    private String blankNo;
    private String customerName;
    private int advisorId;
    private double discount;
    private double commission;
    private double amountUsd;
    private double amountLocal;
    private String cardHolder;
    private String expirationDate;
    private int lastFourDigits;

    public ViewSales(int id, String blankNo, String customerName, int advisorId, double discount, double commission, double amountUsd, double amountLocal, String cardHolder, String expirationDate, int lastFourDigits) {
        this.id = id;
        this.blankNo = blankNo;
        this.customerName = customerName;
        this.advisorId = advisorId;
        this.discount = discount;
        this.commission = commission;
        this.amountUsd = amountUsd;
        this.amountLocal = amountLocal;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        this.lastFourDigits = lastFourDigits;
    }
    public int getId() {
        return id;
    }

    public String getBlankNo() {
        return blankNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getAdvisorId() {
        return advisorId;
    }

    public double getDiscount() {
        return discount;
    }

    public double getCommission() {
        return commission;
    }

    public double getAmountUsd() {
        return amountUsd;
    }

    public double getAmountLocal() {
        return amountLocal;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getLastFourDigits() {
        return lastFourDigits;
    }

}
