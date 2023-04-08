package com.example.airvivacw;

public class Flights {

    private int flight_num;
    private String depart_from;
    private String destination;
    private int flight_date;
    private String airline;
    private String duration;

    public Flights(int flight_num, String depart_from, String destination, int flight_date, String airline, String duration) {
        this.flight_num = flight_num;
        this.depart_from = depart_from;
        this.destination = destination;
        this.flight_date = flight_date;
        this.airline = airline;
        this.duration = duration;
    }

    public int getFlight_num() {
        return flight_num;
    }

    public String getDepart_from() {
        return depart_from;
    }

    public String getDestination() {
        return destination;
    }

    public int getFlight_date() {
        return flight_date;
    }

    public String getAirline() {
        return airline;
    }

    public String getDuration() {
        return duration;
    }
}
