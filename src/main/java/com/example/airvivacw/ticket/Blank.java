package com.example.airvivacw.ticket;

public class Blank {
    private String blankType;
    private String expirationDate;
    private int ID;
    private String status;

    public Blank(String blankType, String expirationDate, String itinerary, int ID, String status) {
        this.blankType = blankType;
        this.expirationDate = expirationDate;
        //this.itinerary = itinerary;
        this.ID = ID;
        this.status = status;
    }

    //public boolean checkExpiration() {
    //    ;
    //}

    public String getBlankType() {
        return blankType;
    }

    public void setBlankType(String blankType) {
        this.blankType = blankType;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    //public String getItinerary() {
    //    ;
    //}

    //public void setItinerary(String itinerary) {
    //    ;
    //}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
