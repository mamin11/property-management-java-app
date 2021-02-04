package classes;

import java.io.Serializable;

public class property  implements Serializable {
	private String address;
	private int num_of_rooms;
	private int selling_price;
	private int sold_price;
	private boolean sold;
	
	public property(String address, int num_of_rooms, int selling_price, int sold_price, boolean sold) {
		this.address = address;
		this.num_of_rooms = num_of_rooms;
		this.selling_price = selling_price;
		this.sold_price = sold_price;
		this.sold = sold = false;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getNumOfRooms() {
		return num_of_rooms;
	}
	
	public void setNumOfRooms(int num_of_rooms) {
		this.num_of_rooms = num_of_rooms;
	}
	
	public int getSellingPrice() {
		return selling_price;
	}
	
	public void setSellingPrice(int selling_price) {
		this.selling_price = selling_price;
	}
	
	public int getSoldPrice() {
		return sold_price;
	}
	
	public void setSoldPrice(int sold_price) {
		this.sold_price = sold_price;
	}
	
	public boolean isSold() {
		return sold ;
	}
	
	public void setIsSold(boolean sold) {
		this.sold = sold;
	}
}
