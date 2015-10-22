import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BuddyMenu extends JFrame implements ActionListener, ListSelectionListener{
	
	private int changes;
	
	public BuddyMenu(AddressBook book){
		
		DefaultListModel<BuddyInfo> listModel = new DefaultListModel<>();
		
		for(int i = 0; i<book.getBookSize(); i++)
		{
			listModel.addElement(book.getBuddy(i));
		}
		
		JList<BuddyInfo> buddyList = new JList<>(listModel);
		buddyList.addListSelectionListener(this);
		
		// Set up frame itself – title,size,location
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu( "Remove" );
		menuBar.add( fileMenu );
	    JMenu editMenu = new JMenu( "Edit" );
	    menuBar.add( editMenu );
	    
	    JMenuItem item;
		 
	    item = new JMenuItem ("Change Name");
	    item.addActionListener(this);
	    editMenu.add(item);
	    item = new JMenuItem ("Change Phone Number");
	    item.addActionListener(this);
	    editMenu.add(item);
	    item = new JMenuItem ("Change Student Number");
	    item.addActionListener(this);
		editMenu.add(item);    
		
		this.getContentPane().add(menuBar);
		this.add(new JScrollPane(buddyList));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Controller");       
		this.setSize(400,200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		//System.out.println (e.getSource() );
		//System.out.println (e.getActionCommand());
		switch(e.getActionCommand()){
			case "Change Name"				:			
				
				
				System.out.println ("name");
				break;
											
									
											
			case "Change Phone Number"		:
				System.out.println ("phone_num");
				break;
									
											
											
			case "Change Student Number"	:			
				System.out.println ("student_num");
				break;
							
											
											
			default							:			
				System.out.println ("invalid");
				break;
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		JList j = JList.class.cast(arg0.getSource());
		System.out.println (j.getSelectedIndex());
		changes = j.getSelectedIndex();
	}
			
}
