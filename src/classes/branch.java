package classes;

import java.io.Serializable;
import java.util.ArrayList;


public class branch implements Serializable {
	public ArrayList <house> houses =  new ArrayList <house>();
	public ArrayList <flat> flats =  new ArrayList <flat>();
	public ArrayList <house> soldHouses =  new ArrayList <house>();
	public ArrayList <flat> soldFlats =  new ArrayList <flat>();
	private String name;
	private String address;
	private String phone_number;
	private String email_address;
	private String web_address;
	private String username;
	private String password;
	
	public branch(String name, String address, String phone_number, String email_address, String web_address, String username, String password) {
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.email_address = email_address;
		this.web_address = web_address;
		this.username = username;
		this.password =  password;
//		this.houses = houses;
//		this.flats = flats;
	}
	
	public void addHouse(house house) {
		this.houses.add(house);
	}
	public ArrayList<house> getHouses() {
		return houses;
	}
	
	public void addFkat(flat flat) {
		this.flats.add(flat);
	}
	
	public ArrayList<flat> getFlats() {
		return flats;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phone_number;
	}
	
	public void setPhoneNumbere(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getEmailAddress() {
		return email_address;
	}
	
	public void setEmailAddress(String email_address) {
		this.email_address = email_address;
	}
	
	public String getWebAddress() {
		return web_address;
	}
	
	public void setWebAddress(String web_address) {
		this.web_address = web_address;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
