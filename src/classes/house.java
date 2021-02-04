package classes;

public class house extends property {
	private int num_of_floors;
	boolean has_garage;
	boolean has_garden;

	public house(String address, int num_of_rooms, int selling_price, int sold_price, boolean sold, int num_of_floors, boolean has_garage, boolean has_garden) {
		super(address, num_of_rooms, selling_price, sold_price, sold);
		// TODO Auto-generated constructor stub
	}
	
	public int getNumOfFloors() {
		return num_of_floors;
	}
	
	public void setNumOfFloors(int num_of_floors) {
		this.num_of_floors = num_of_floors;
	}
	
	public boolean hasGarage() {
		return has_garage ;
	}
	
	public void sethasGarage(boolean has_garage) {
		this.has_garage = has_garage;
	}
	
	public boolean hasGarden() {
		return has_garden ;
	}
	
	public void sethasGarden(boolean has_garden) {
		this.has_garden = has_garden;
	}

}
