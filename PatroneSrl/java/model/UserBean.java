package model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserBean {
	
	private int user_id;
	private String firstname;
	private String lastname;
	private String address;
	private String email;
	private String password;
	
	public UserBean() {
	}
	
	public UserBean(int user_id, String firstname, String lastname, String address, String email, String password) {
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	
	public int getUserID() {
		return user_id;
	}
	public void setUserID(int user_id) {
		this.user_id = user_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
	    return "Utente [id = " + user_id + ", nome = " + firstname + ", cognome = " + lastname + ", address = " + address + ", email = " + email + ", password = " + password + "]";
	}

}
