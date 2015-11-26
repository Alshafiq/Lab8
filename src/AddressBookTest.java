import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class AddressBookTest {
	
	private AddressBook book;
	
	private BuddyInfo bud1;
	private BuddyInfo bud2;
	private BuddyInfo bud3;
	
	private File file;
	private BufferedReader reader;


	@Before
	public void setUp() throws Exception {
		book = new AddressBook();
		bud1 = new BuddyInfo("Apik", "Alta Vista", 613854);
		bud2 = new BuddyInfo("Ahmad", "Colonel By", 613855);
		bud3 = new BuddyInfo("Ally", "Walkley", 613856);
		book.addBuddy(bud1);
		book.addBuddy(bud2);
		book.addBuddy(bud3);
		
		file = new File("/users/alshafiqhasbi/desktop/file.txt");
        reader = new BufferedReader(new FileReader(file));
	}

	@Test
	public void testExport() throws IOException {
		book.export();
        String line;
        BuddyInfo bud = null;
        AddressBook clone = new AddressBook();
        while ((line = reader.readLine()) != null) {    		
            bud = BuddyInfo.importB(line);
			clone.addBuddy(bud);
        }
        
        assertEquals("First buddy in clone should be Apik", "Apik", book.getBuddy(0).getName());
        assertEquals("Second buddy in clone should be Ahmad", "Ahmad", book.getBuddy(1).getName());
        assertEquals("Third buddy in clone should be Ally", "Ally", book.getBuddy(2).getName());
	}

	@Test
	public void testImportA() throws IOException {
		book.export();
		AddressBook book2 = new AddressBook();
		book2 = book.importA();
		
		//check same name
		assertEquals("First buddy name should be "  + book.getBuddy(0).getName(), book.getBuddy(0).getName(), book2.getBuddy(0).getName());
		assertEquals("Second buddy name should be "  + book.getBuddy(1).getName(), book.getBuddy(1).getName(), book2.getBuddy(1).getName());
		assertEquals("Third buddy name should be "  + book.getBuddy(2).getName(), book.getBuddy(2).getName(), book2.getBuddy(2).getName());
		
		//check same address
		assertEquals("First buddy address should be " + book.getBuddy(0).getAddress(), book.getBuddy(0).getAddress(), book2.getBuddy(0).getAddress());
		assertEquals("Second buddy address should be " + book.getBuddy(1).getAddress(), book.getBuddy(1).getAddress(), book2.getBuddy(1).getAddress());
		assertEquals("Third buddy address should be " + book.getBuddy(2).getAddress(), book.getBuddy(2).getAddress(), book2.getBuddy(2).getAddress());
				
		//check same phoneNum
		assertEquals("First buddy phoneNum should be " + book.getBuddy(0).getPhoneNum(), book.getBuddy(0).getPhoneNum(), book2.getBuddy(0).getPhoneNum());
		assertEquals("Second buddy phoneNum should be " + book.getBuddy(1).getPhoneNum(), book.getBuddy(1).getPhoneNum(), book2.getBuddy(1).getPhoneNum());
		assertEquals("Third buddy phoneNum should be " + book.getBuddy(2).getPhoneNum(), book.getBuddy(2).getPhoneNum(), book2.getBuddy(2).getPhoneNum());
	}

}
