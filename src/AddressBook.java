import java.util.ArrayList;
import javax.swing.*;

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
	
	public void printBuddy()
	{
		for(BuddyInfo i : buddy)
		{
			System.out.println(i.getName() + "," + i.getPhoneNum() + "," + i.getStu_num());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BuddyInfo bud1 = new BuddyInfo("Apik", 138540520, 100866318);
		BuddyInfo bud2 = new BuddyInfo("Nida", 138540521, 100866317);
		AddressBook book = new AddressBook();
		
		book.addBuddy(bud1);
		book.addBuddy(bud2);
		
		book.printBuddy();
		
		JFrame f =  new JFrame("Address Book");
		JPanel j = new JPanel();
		JTextArea m = new JTextArea();
		
		String t = "Buddies: \n";
		m.setEditable(false);
		m.setText("Name "+"Address "+"Phone Number ");
		j.add(m);
		f.setSize(400, 300);
		f.setVisible(true);
		f.add(j);
		
		
		
	}

}
