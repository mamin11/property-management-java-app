package assignment;

//puts everything together
public class PropertiesAppMain {

	public static void main(String[] args) {
		Model themodel = new Model();
		Controller thecontroller = new Controller(themodel);
		View theview = new View(thecontroller, themodel);

	}
	
}
