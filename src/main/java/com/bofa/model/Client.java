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

    protected Long clientPhone;

    protected String clientGender;

	public Client(int i, String string, String string2, String string3, long l, String string4) {
		// TODO Auto-generated constructor stub
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public long getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(long clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientGender() {
		return clientGender;
	}

	public void setClientGender(String clientGender) {
		this.clientGender = clientGender;
	}

    


}
