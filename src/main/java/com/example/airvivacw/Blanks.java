package com.example.airvivacw;


public class Blanks {
    private int id;
    private String number;
    private String type;
    private int date_received;

    public Blanks(int id, String number, String type, int date_received) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.date_received = date_received;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public int getDateReceived() {
        return date_received;
    }
}
