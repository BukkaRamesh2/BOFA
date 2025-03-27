package com.bofa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
    //    default access specifier
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    public String clientName;

    private String clientEmail;

    private String clientAddress;

    protected long clientPhone;

    protected String clientGender;



}
