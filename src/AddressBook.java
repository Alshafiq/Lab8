import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	public BuddyInfo getBuddy(int i)
	{
		return buddy.get(i);
	}
	
	public int getBookSize()
	{
		return buddy.size();
	}
	
	public void ViewGUI()
	{
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		
		for(BuddyInfo b: buddy)
		{
			listModel.addElement(b.getName()+", "+ b.getPhoneNum() +", "+ b.getStu_num());
		}
		
		JList<String> buddyList = new JList<>(listModel);
		
		JFrame frame = new JFrame();
		frame.add(new JScrollPane(buddyList));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("View");       
		frame.setSize(400,200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuddyInfo bud1 = new BuddyInfo("Apik", 138540520, 100866318);
		BuddyInfo bud2 = new BuddyInfo("Nida", 138540521, 100866317);
		BuddyInfo bud3 = new BuddyInfo("Apik1", 138540520, 100866318);
		BuddyInfo bud4 = new BuddyInfo("Nida1", 138540521, 100866317);
		BuddyInfo bud5 = new BuddyInfo("Apik2", 138540520, 100866318);
		BuddyInfo bud6 = new BuddyInfo("Nida2", 138540521, 100866317);
		BuddyInfo bud7 = new BuddyInfo("Apik3", 138540520, 100866318);
		BuddyInfo bud8 = new BuddyInfo("Nida3", 138540521, 100866317);
		
		AddressBook book = new AddressBook();
		
		book.addBuddy(bud1);
		book.addBuddy(bud2);
		book.addBuddy(bud3);
		book.addBuddy(bud4);
		book.addBuddy(bud5);
		book.addBuddy(bud6);
		book.addBuddy(bud7);
		book.addBuddy(bud8);
		
		BuddyMenu menu = new BuddyMenu(book);
		book.ViewGUI();
		
	}

}
