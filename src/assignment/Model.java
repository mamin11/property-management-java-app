package assignment;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import classes.*;

public class Model {
	public ArrayList <branch> branches = new ArrayList <branch>();
	public ArrayList <house> houses =  new ArrayList <house>();
	public ArrayList <flat> flats =  new ArrayList <flat>();
	
	public branch createBranch(branch br) throws Exception {
		
		branches.add(br);
		//System.out.println(branches);
		storeBranch(branches);
		return br;
		
	}
	
	public void removeb(int pos) {
		branches.remove(pos);
	}
	
	public void storeBranch(ArrayList <branch> branches) throws IOException {
		FileOutputStream fos = new FileOutputStream("branches.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		
		for(int i=0; i< branches.size(); i++) {
			oos.writeObject(branches.get(i));	
		}
		oos.close();
	}
	
	public ArrayList<branch> showBranches() throws Exception {
		try {
		FileInputStream fis = new FileInputStream("branches.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		branch obj = null;
		
		branches =  new ArrayList <branch>();
		
		while((obj=(branch)ois.readObject())!=null) {
			//System.out.println("Name: " + obj.getName());	
			branches.add(obj);
		}
		
		ois.close();
		
		} catch (EOFException ex) {
			//System.out.println("End of File reached");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		return branches;
	}
	
	public property createProperty() {
		property pr = new property(null, 0, 0, 0, false);
		return pr;
	}
	
	public house createHouse(house h) throws Exception {
		
		houses.add(h);
		//System.out.println(houses);
		storeHouse(houses);
		return h;
	}
	
	public void storeHouse(ArrayList <house> houses) throws IOException {
		  FileOutputStream fos = new FileOutputStream("houses.dat");
		  ObjectOutputStream oos = new ObjectOutputStream(fos);
		  
		  
		  for(int i=0; i< houses.size(); i++) {
		    oos.writeObject(houses.get(i));	
		  }
		  oos.close();
	}
	
	public ArrayList<house> showHouses() throws Exception {
		
		  try {
			  FileInputStream fis = new FileInputStream("houses.dat");
			  ObjectInputStream ois = new ObjectInputStream(fis);
			  house obj = null;
			  
			  houses =  new ArrayList <house>();
			  
			  while((obj=(house)ois.readObject())!=null) {
			   // System.out.println("Address: " + obj.getAddress());	
			    houses.add(obj);
			  }
			  
			  ois.close();
		  		} catch (EOFException ex) {
		  		//System.out.println("End of File reached");
		  			//ex.printStackTrace();
			  } catch (ClassNotFoundException ex) {
			    ex.printStackTrace();
			  } catch (FileNotFoundException ex) {
			    ex.printStackTrace();
			  } catch (IOException ex) {
			    ex.printStackTrace();
			  }
		
		return houses;
		
	}
	
	public flat createFlat(flat f) throws IOException  {
		
		flats.add(f);
		//System.out.println(flats);
		storeFlat(flats);
		return f;
	}
	
	public void storeFlat(ArrayList <flat> flats) throws IOException {
		  FileOutputStream fos = new FileOutputStream("flats.dat");
		  ObjectOutputStream oos = new ObjectOutputStream(fos);
		  
		  
		  for(int i=0; i< flats.size(); i++) {
		    oos.writeObject(flats.get(i));	
		  }
		  oos.close();
	}
	
	public ArrayList<flat> showFlats() throws Exception {
		  try {
			  FileInputStream fis = new FileInputStream("flats.dat");
			  ObjectInputStream ois = new ObjectInputStream(fis);
			  flat obj = null;
			  
			  flats =  new ArrayList <flat>();
			  
			  while((obj=(flat)ois.readObject())!=null) {
			   // System.out.println("Name: " + obj.getAddress());	
			    flats.add(obj);
			  }
			  ois.close();
			  
		  } catch (EOFException ex) {
		    //System.out.println("End of File reached");
		  } catch (ClassNotFoundException ex) {
		    ex.printStackTrace();
		  } catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		  } catch (IOException ex) {
		    ex.printStackTrace();
		  }
		
		return flats;
		
	}
	
	
	
	public void addBranch(branch br) throws IOException {
		FileOutputStream fos = new FileOutputStream("branches.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		
		oos.writeObject(br);
		oos.close();
	}
	
	
}
