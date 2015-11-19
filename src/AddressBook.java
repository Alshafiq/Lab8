import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private ArrayList<BuddyInfo> buddy;
	
	public AddressBook()
	{
		buddy = new ArrayList<>();
	}
	
	public void addBuddy(BuddyInfo bud)
	{
		if(bud != null)
		{
			buddy.add(bud);
		}
	}
	
	public void removeBuddy(BuddyInfo bud)
	{
		if(bud != null)
		{
			buddy.remove(bud);
		}
	}
	
	public BuddyInfo getBuddy(int i)
	{
		return buddy.get(i);
	}
	
	public int getBookSize()
	{
		return buddy.size();
	}
	
	public void export() throws IOException
	{
        List<String> list = new ArrayList<String>();
        
        for(BuddyInfo b: buddy)
        {
            list.add(b.toString());
        }

        String[] stringArr = list.toArray(new String[0]);
		
        //Change this path for result!
        File file = new File("/users/alshafiqhasbi/desktop/file.txt");
        
        if (!file.exists()) {
			file.createNewFile();
		}
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(String s: stringArr)
		{
			bw.write(s);
			bw.newLine();
		}
		
		bw.close();
	}
	
	public AddressBook importA() throws IOException
	{
		AddressBook book = new AddressBook();
		BuddyInfo bud = null;
		
		//Change this path for result!
        File file = new File("/users/alshafiqhasbi/desktop/file.txt");
        
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        
        while ((line = reader.readLine()) != null) {    		
            bud = BuddyInfo.importB(line);
			book.addBuddy(bud);
        }
        
        return book;
	}

	public static void main(String[] args) throws IOException {
		// Setup
		BuddyInfo bud1 = new BuddyInfo("Apik", "Alta Vista", 613854);
		BuddyInfo bud2 = new BuddyInfo("Ahmad", "Colonel By", 613855);
		BuddyInfo bud3 = new BuddyInfo("Ally", "Walkley", 613856);
		
		AddressBook book = new AddressBook();
		AddressBook book2 = new AddressBook();
		
		book.addBuddy(bud1);
		book.addBuddy(bud2);
		book.addBuddy(bud3);
		
		// Runner
		book.export();
		book2 = book.importA();
		System.out.println("See result in file.txt in the specified path(export).");
		System.out.println("\nThis is book2(import from file) contents:");
		
		for(int i = 0; i < book2.getBookSize(); i++)
		{
			System.out.println(book2.getBuddy(i).toString());
		}
		
	}

}
