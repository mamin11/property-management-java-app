package assignment;
import assignment.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tests {
	Model model = new Model();

	@Test
	void test() throws Exception {
		//fail("Not yet implemented");
		int size = model.showBranches().size();
		assertEquals(size, 4);
	}
	
	void testShowHouses() throws Exception {
		int size = model.showHouses().size();
		assertTrue(size>0);
	}

}
