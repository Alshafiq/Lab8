import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BuddyInfoTest {

	private BuddyInfo bud;
	
	@Before
	public void setUp() throws Exception {
		bud = new BuddyInfo("Apik", "Alta Vista", 613854);
	}

	@Test
	public void testBuddyInfo() {
		assertEquals("bud class should be BuddyInfo", bud.getClass(), BuddyInfo.class);
	}

	@Test
	public void testGetName() {
		assertEquals("bud name should be Apik", "Apik", bud.getName());
	}

	@Test
	public void testSetName() {
		bud.setName("Ahmad");
		assertEquals("bud name now should be Ahmad after being set", "Ahmad", bud.getName());
	}

	@Test
	public void testGetAddress() {
		assertEquals("bud address should be Alta Vista", "Alta Vista", bud.getAddress());
	}

	@Test
	public void testSetAddress() {
		bud.setAddress("Walkley");
		assertEquals("bud address now should be Walkley after being set", "Walkley", bud.getAddress());
	}

	@Test
	public void testGetPhoneNum() {
		assertEquals("bud phoneNume should be 613854", 613854, bud.getPhoneNum());
	}

	@Test
	public void testSetPhoneNum() {
		bud.setPhoneNum(6138541);
		assertEquals("bud phoneNum should now be 6138541 after being set", 6138541, bud.getPhoneNum());
	}

	@Test
	public void testToString() {
		assertEquals("bud should return Apik$Alta Vista$613854", "Apik$Alta Vista$613854", bud.toString());
	}

	@Test
	public void testImportB() {
		BuddyInfo cloneBud = BuddyInfo.importB(bud.toString());
		assertEquals("cloneBud name should be the same with bud", cloneBud.getName(), bud.getName());
		assertEquals("cloneBud address should be the same with bud", cloneBud.getAddress(), bud.getAddress());
		assertEquals("cloneBud phoneNum should be the same with bud", cloneBud.getPhoneNum(), bud.getPhoneNum());
	}

}
