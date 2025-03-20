package com.bofa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    //    default access specifier
    private long clientId;
    public String clientName;

    private String clientEmail;

    private String clientAddress;

    protected long clientPhone;

    protected String clientGender;



}
