package com.bofa.model;

public class Client {

    public Client() {
        System.out.println("Nothing is in this constructor");
    }

    public Client(long clientId, String clientName, String clientEmail, String clientAddress, Long clientPhone, String clientGender) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientAddress = clientAddress;
        this.clientPhone = clientPhone;
        this.clientGender = clientGender;
    }

    long clientId;
//    default access specifier
    public String clientName;

    private String clientEmail;

    private String clientAddress;

    protected long clientPhone;


    protected String clientGender;



}
