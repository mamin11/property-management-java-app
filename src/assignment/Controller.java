package assignment;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import classes.*;

public class Controller implements ActionListener {
	private ArrayList <View> theview;
	private Model themodel;

	public int branchPos;
	public int branchSize = 0;
	public int houseSize = 0;
	public int flatSize = 0;
	
	private boolean loggedIn = false;
	
	public ArrayList <branch> branches = new ArrayList <branch>();
	public ArrayList <house> houses =  new ArrayList <house>();
	public ArrayList <flat> flats =  new ArrayList <flat>();
	
	public Controller(Model themodel) {
		this.theview =  new ArrayList <View>();
		this.themodel = themodel;
		
		//transfer branch data from binary file to arrayList
		try {
			int bSize = themodel.showBranches().size();
			for(int i=0; i<bSize; i++) {
				branches.add(i, themodel.showBranches().get(i));
				branchSize++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//transfer house data from binary file to arrayList
		try {
			int hSize = themodel.showHouses().size();
			for(int i=0; i<hSize; i++) {
				houses.add(i, themodel.showHouses().get(i));
				houseSize++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//transfer flat data from binary file to arrayList
		try {
			int fSize = themodel.showFlats().size();
			for(int i=0; i<fSize; i++) {
				flats.add(i, themodel.showFlats().get(i));
				flatSize++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void addView(View view) {
		this.theview.add(view);
		}		
		public void actionPerformed(ActionEvent arg0) {
			Object source = arg0.getSource();
			
			//if the user clicks on back button
			//if statements for buttons the user clicks on
			if(source == theview.get(0).btnBack) {
				//System.out.println("back button");
				theview.get(0).adminHome();
			}
			if(source == theview.get(0).btnBackFront) {
				//System.out.println("back front button");
				theview.get(0).frontPage();
			}
			if(source == theview.get(0).btnBackSecHome) {
				//System.out.println("back button");
				try {
					theview.get(0).secretaryHome(secLoginCheck(branches));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(source == theview.get(0).aboutItem) {
				theview.get(0).handleAboutItem();
			}
			if(source == theview.get(0).btnAdmin) {
				//System.out.println("admin button");
				//System.out.println("********** " + branchSize);
				theview.get(0).LoginPage();
			}
			if(source == theview.get(0).btnSecretary) {
				//System.out.println("Secretary button");
				theview.get(0).SecLoginPage();
			}
			if(source == theview.get(0).btnLogin) {
				//System.out.println("login button");
				//VALIDATE USER INPUTS
				if(theview.get(0).username.getText().isEmpty() && (!(theview.get(0).password.getText().isEmpty()))) {
					theview.get(0).username.setText("YOU MUST ENTER USERNAME");
				} 
				else if(theview.get(0).password.getText().isEmpty() && (!(theview.get(0).username.getText().isEmpty()))) {
					theview.get(0).password.setText("YOU MUST ENTER PASSWORD");
				}
				else if(theview.get(0).username.getText().isEmpty() && theview.get(0).password.getText().isEmpty()) {
					theview.get(0).username.setText("YOU MUST ENTER USERNAME");
					theview.get(0).password.setText("YOU MUST ENTER PASSWORD");
				}
				else {
					String userTypedUsername = theview.get(0).getUsername();
					String userTypedPassword = theview.get(0).password.getText();
					loginCheck(userTypedUsername, userTypedPassword);
				}
				
			}
			if(source == theview.get(0).btnSecLogin) {
				//System.out.println("Sec login button");

				//VALIDATE USER INPUTS
				if(theview.get(0).username.getText().isEmpty() && (!(theview.get(0).password.getText().isEmpty()))) {
					theview.get(0).username.setText("YOU MUST ENTER USERNAME");
				} 
				else if(theview.get(0).password.getText().isEmpty() && (!(theview.get(0).username.getText().isEmpty()))) {
					theview.get(0).password.setText("YOU MUST ENTER PASSWORD");
				}
				else if(theview.get(0).username.getText().isEmpty() && theview.get(0).password.getText().isEmpty()) {
					theview.get(0).username.setText("YOU MUST ENTER USERNAME");
					theview.get(0).password.setText("YOU MUST ENTER PASSWORD");
				}
				else {
					secLoginCheck(branches);
					if(loggedIn == true) {
						theview.get(0).secretaryHome(secLoginCheck(branches));
					}
				}
				

			
			}
			if(source == theview.get(0).btnViewBranch) {
				//System.out.println("view branch button");
				try {
					theview.get(0).viewBranch();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(source == theview.get(0).btnAddBranch) {
				//System.out.println("add branch button");
				theview.get(0).addBranch();
				onClose();
			}
			if(source == theview.get(0).btnSaveBranch) {
				//System.out.println("SAVE BRANCH BUTTON");
				branch br = new branch(theview.get(0).getBranchNameTF(),
						theview.get(0).getBranchAddressTF(), 
						theview.get(0).getBranchTelNumTF(), 
						theview.get(0).getBranchEmailTF(), 
						theview.get(0).getBranchWebTF(), 
						theview.get(0).getBranchUnameTF(), 
						theview.get(0).getBranchPwordTF());
				//try {

				//VALIDATE IF THE USER IS SUBMITTING PARTIAL DATA
					if(br.getName().isEmpty()) {
						//System.out.println("******** EMPTY BRANCH NAME ******");
						theview.get(0).setBranchNameTF("YOU MUST ENTER NAME");
					} 
					else if(br.getAddress().isEmpty()) {
						theview.get(0).setBranchAddressTF("YOU MUST ENTER ADDRESS");
					}
					else if(br.getPhoneNumber().isEmpty()) {
						theview.get(0).setBranchAddressTF("YOU MUST ENTER NUMBER");
					}
					else if(br.getEmailAddress().isEmpty()) {
						theview.get(0).setBranchAddressTF("YOU MUST ENTER EMAIL");
					}
					else if(br.getWebAddress().isEmpty()) {
						theview.get(0).setBranchAddressTF("YOU MUST ENTER WEB ADDRESS");
					}
					else if(br.getUserName().isEmpty()) {
						theview.get(0).setBranchAddressTF("YOU MUST ENTER USERNAME");
					}
					else if(br.getPassword().isEmpty()) {
						theview.get(0).setBranchAddressTF("YOU MUST ENTER PASSWORD");
					}
					else {
						//OTHERWISE ADD THE BRANCH
						branches.add(br);
						onClose();
						theview.get(0).adminHome();
					}
			}

			//loop through the branches
			for(int i =0; i<branchSize; i++) {
				if(source == theview.get(0).buttons[i]) {
					//System.out.println("MODIFY BRANCH BUTTON");	
					try {
					theview.get(0).modifyBranch(branches.get(i).getName(), 
							branches.get(i).getAddress(), branches.get(i).getPhoneNumber(), 
							branches.get(i).getEmailAddress(), 
							branches.get(i).getWebAddress(), 
							branches.get(i).getUserName(), 
							branches.get(i).getPassword());
					
					branch branch = branches.get(i);
					branches.remove(branch);
					branchSize=branchSize-1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				//delete button
				if(source == theview.get(0).delButtons[i]) {
					//System.out.println("DELETE BUTTON PRESSED " +i);
					branch branch = branches.get(i);
					branches.remove(branch);
					onClose();
					branchSize=branchSize-1;
				}
				
			}
				if(source == theview.get(0).btnUpdateBranch) {
				//System.out.println("UPDATE BRANCH BUTTON");
				//branch element = new branch(theview.get(0).getBranchNameTF(), theview.get(0).getBranchAddressTF(), theview.get(0).getBranchTelNumTF(), theview.get(0).getBranchEmailTF(), theview.get(0).getBranchWebTF(), theview.get(0).getBranchUnameTF(), theview.get(0).getBranchPwordTF());;
				branch br = new branch(theview.get(0).getBranchNameTF(), 
						theview.get(0).getBranchAddressTF(), 
						theview.get(0).getBranchTelNumTF(), 
						theview.get(0).getBranchEmailTF(), 
						theview.get(0).getBranchWebTF(), 
						theview.get(0).getBranchUnameTF(), 
						theview.get(0).getBranchPwordTF());

				try {
					branches.add(br);
					onClose();
					branchSize=branchSize+1;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				theview.get(0).adminHome();
				}

			
			if(source == theview.get(0).btnAddProperty) {
				//System.out.println("add property button");
				theview.get(0).addProperty();
			}
			if(source == theview.get(0).btnAddHouse) {
				theview.get(0).addHouse();
			}
			if(source == theview.get(0).btnAddFlat) {
				theview.get(0).addFlat();
			}
			
			if(source == theview.get(0).btnSaveHouse) {
				//System.out.println("SAVE HOUSE BUTTON");
				//secLoginCheck(branches).get(0).getName() --name of branch user is logged in to
				house h = new house(theview.get(0).getHouseaddressTF(), 
						theview.get(0).getHouseRoomsTF(), 
						theview.get(0).getHouseSellingPriceTF(), 
						0,
						false, 
						theview.get(0).getHouseNumFloorsTF(), 
						theview.get(0).getHouseGarageCombo(), 
						theview.get(0).getHouseGardenCombo());
						//add the house to the houses arrayList for the current branch
						secLoginCheck(branches).get(0).houses.add(h);
						
						try {
							houses.add(h);
							onClose();
							//theview.get(0).secretaryHome(secLoginCheck(branches));
							theview.get(0).viewHouse(secLoginCheck(branches).get(0).houses);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
			}
			if(source == theview.get(0).btnSaveFlat) {
				//System.out.println("SAVE FLAT BUTTON");
				flat f = new flat(theview.get(0).getFlataddressTF(), 
						theview.get(0).getFlatFloorNumTF(), 
						theview.get(0).getFlatSellingPriceTF(), 
						0, 
						theview.get(0).getFlatFloorNumTF(),
						theview.get(0).getFlatRentTF(), 
						false);
				secLoginCheck(branches).get(0).flats.add(f);
				try {
					flats.add(f);
					onClose();
					//theview.get(0).secretaryHome(secLoginCheck(branches));
					theview.get(0).viewFlat(secLoginCheck(branches).get(0).flats);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//DELETE HOUSE
			if(loggedIn ==true) {
			for(int i =0; i<secLoginCheck(branches).get(0).houses.size(); i++) { //houseSize
				if(source == theview.get(0).hDelButtons[i]) {
					//System.out.println("DELETE HOUSE BUTTON");
					house h = secLoginCheck(branches).get(0).houses.get(i);
					secLoginCheck(branches).get(0).houses.remove(h);
					onClose();
				}
				
			}
		}
			
			//DELETE FLAT
			if(loggedIn ==true) {
			for(int i =0; i<secLoginCheck(branches).get(0).flats.size(); i++) {
				//if deleting a flat
				if(source == theview.get(0).fDelButtons[i]) {
					//System.out.println("DELETE FLat BUTTON");
					flat f = secLoginCheck(branches).get(0).flats.get(i);
					secLoginCheck(branches).get(0).flats.remove(f);
					onClose();
				}
				
				}
			}
			
			//MODIFY HOUSE
			if(loggedIn ==true) {
			for(int i =0; i<secLoginCheck(branches).get(0).houses.size(); i++) { 
				if(source == theview.get(0).hModbuttons[i]) {
					//System.out.println("MODIFY HOUSE BUTTON");
					theview.get(0).modifyHouse(
							secLoginCheck(branches).get(0).houses.get(i).getAddress(),
							secLoginCheck(branches).get(0).houses.get(i).getNumOfRooms(),
							secLoginCheck(branches).get(0).houses.get(i).getSellingPrice(),
							0,
							false,
							secLoginCheck(branches).get(0).houses.get(i).getNumOfFloors(),
							secLoginCheck(branches).get(0).houses.get(i).hasGarage(),
							secLoginCheck(branches).get(0).houses.get(i).hasGarden()
							);
					
					house h = secLoginCheck(branches).get(0).houses.get(i);
					secLoginCheck(branches).get(0).houses.remove(h);
				}
				
			}
			
				if(source == theview.get(0).btnUpdateHouse) {
					house h = new house(theview.get(0).getHouseaddressTF(), 
							theview.get(0).getHouseRoomsTF(), 
							theview.get(0).getHouseSellingPriceTF(), 
							0, 
							false, 
							theview.get(0).getHouseNumFloorsTF(), 
							theview.get(0).getHouseGarageCombo(), 
							theview.get(0).getHouseGardenCombo());
					
					secLoginCheck(branches).get(0).houses.add(h);
					houses.add(h);
					onClose();
					theview.get(0).secretaryHome(secLoginCheck(branches));
					
				}
			
		}
			
			//MODIFY FLAT
			if(loggedIn ==true) {
			for(int i =0; i<secLoginCheck(branches).get(0).flats.size(); i++) { 
				if(source == theview.get(0).fModbuttons[i]) {
					//System.out.println("MODIFY FLAT BUTTON");
					theview.get(0).modifyFlat(
							secLoginCheck(branches).get(0).flats.get(i).getAddress(),
							secLoginCheck(branches).get(0).flats.get(i).getNumOfRooms(),
							secLoginCheck(branches).get(0).flats.get(i).getSellingPrice(),
							0,
							false,
							secLoginCheck(branches).get(0).flats.get(i).getFloorNum(),
							secLoginCheck(branches).get(0).flats.get(i).getMonthlyCharge()
							);
					
					flat f = secLoginCheck(branches).get(0).flats.get(i);
					secLoginCheck(branches).get(0).flats.remove(f);
				}
				
			}
			
				if(source == theview.get(0).btnUpdateFlat) {
					flat f = new flat(theview.get(0).getFlataddressTF(), 
							theview.get(0).getFlatFloorNumTF(), 
							theview.get(0).getFlatSellingPriceTF(), 
							0, 
							theview.get(0).getFlatRentTF(),
							theview.get(0).getFlatFloorNumTF(),
							false
							);
					
					secLoginCheck(branches).get(0).flats.add(f);
					flats.add(f);
					onClose();
					theview.get(0).secretaryHome(secLoginCheck(branches));
				}
			
		}
			
			//SELL HOUSE
			if(loggedIn ==true) {
			for(int i =0; i<secLoginCheck(branches).get(0).houses.size(); i++) { //houseSize
				if(source == theview.get(0).hSellButtons[i]) {
					//System.out.println("SELL HOUSE BUTTON");
					//secLoginCheck(branches).get(0).houses
					
					//remove from normal arrayList
					house h = secLoginCheck(branches).get(0).houses.get(i);
					secLoginCheck(branches).get(0).houses.remove(h);
					
					//record price
					h.setSoldPrice(Integer.parseInt(theview.get(0).housePrice));
	
					//add to sold 
					secLoginCheck(branches).get(0).soldHouses.add(h);

					//update binary file
					onClose();
				}
				
			}
		}
			
			
			//SELL FLAT
			if(loggedIn ==true) {
			for(int i =0; i<secLoginCheck(branches).get(0).flats.size(); i++) { 
				if(source == theview.get(0).fSellButtons[i]) {
					//System.out.println("SELL FLAT BUTTON");
					
					//remove from normal arrayList
					flat f = secLoginCheck(branches).get(0).flats.get(i);
					secLoginCheck(branches).get(0).flats.remove(f);
					
					//record price
					f.setSoldPrice(Integer.parseInt(theview.get(0).flatPrice));
	
					//add to sold 
					secLoginCheck(branches).get(0).soldFlats.add(f);

					//update binary file
					onClose();
				}
				
			}
		}
				

			
			if(source == theview.get(0).btnViewProperty) {
				//list all the properties: house & flats
				//System.out.println("view property button");
				theview.get(0).viewProperty();
			}
			if(source == theview.get(0).btnViewHouse) {
				//System.out.println("view House button");
				theview.get(0).viewHouse(secLoginCheck(branches).get(0).houses);
			}
			if(source == theview.get(0).btnViewFlat) {
				//System.out.println("view flat button");
				theview.get(0).viewFlat(secLoginCheck(branches).get(0).flats);
			}
			
			if(source == theview.get(0).btnViewSold) {
				//System.out.println("view sold button");
				theview.get(0).soldProperties(secLoginCheck(branches).get(0).soldHouses, secLoginCheck(branches).get(0).soldFlats);
			}

		
	}
	
		//login check for the admin
		public void loginCheck(String userTypedUsername2, String userTypedPassword2) {
			String username = "admin";
			String password = "admin";

				if((userTypedUsername2.equals(username)) && (userTypedPassword2.equals(password))) {
					//System.out.println("ADMIN LOGIN SUCCESS");
					theview.get(0).adminHome();
				} 

		}
		
		//login check for the secretary
		public ArrayList<branch> secLoginCheck(ArrayList<branch> showBranches) {
			
			ArrayList <branch> currentBranch = new ArrayList<branch>();
			for(int i=0; i< showBranches.size(); i++) {
			String secUname = showBranches.get(i).getUserName();
			String secPword = showBranches.get(i).getPassword();
			
			String userTypedUsername = theview.get(0).getUsername();
			String userTypedPassword = theview.get(0).password.getText();
			
 				
				 //try secretary details
				if((userTypedUsername.equals(secUname)) && (userTypedPassword.equals(secPword))) {
					//br = showBranches.get(i);
					currentBranch.add(showBranches.get(i));
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//System.out.println("SECRETARY SUCCESS");
							//theview.get(0).secretaryHome(currentBranch);
							loggedIn = true;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				}
				
			}

			return currentBranch;
		}
		

		//update the branches, houses and flats files in the model
		public void onClose() {
			try {
				//System.out.println("STORING TO BINARY FILE");
				themodel.storeBranch(branches);
				themodel.storeFlat(flats);
				themodel.storeHouse(houses);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

}
