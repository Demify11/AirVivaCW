package com.example.airvivacw.ticket;

public interface I_Ticket {
    Blank addBlank(String blankType, String ID, String expirationData);
    boolean removeBlank(String ID);
    boolean checkAvailability();
    int getTotalBlank();
    int getRemainingBlank();
    String getStockLocation();
    boolean checkExpiration();
    String getBlankType();
    String getExpirationDate();
    String getBlankStatus();
    int getCustomerID();
    String getFlightDate();
    String getFlightTime();
    String getDestination();
    String getFlightNumber();
}
