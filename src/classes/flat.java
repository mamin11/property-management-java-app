package classes;

public class flat extends property {
	private int floor_num;
	private int monthly_charge;

	public flat(String address, int num_of_rooms, int selling_price, int sold_price, int floor_num, int monthly_charge, boolean sold) {
		super(address, num_of_rooms, selling_price, sold_price, sold);
		// TODO Auto-generated constructor stub
	}
	
	public int getFloorNum() {
		return floor_num;
	}
	
	public void setFloorNum(int floor_num) {
		this.floor_num = floor_num;
	}
	
	public int getMonthlyCharge() {
		return monthly_charge;
	}
	
	public void setMonthlyCharge(int monthly_charge) {
		this.monthly_charge = monthly_charge;
	}
}
