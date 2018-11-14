package guiversion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * Creates the Navigation Bar at the top of the screen
 * Options for reset? other options
 */

public class Nav_Bar extends JMenuBar implements ActionListener{
	
	private GuiView view;
	
	public Nav_Bar(GuiView view) {

		this.view = view;

		JMenu menu;
		JMenuItem mi;

		menu = new JMenu("File");

		mi = new JMenuItem("Quit"); 
		mi.addActionListener(this);
		menu.add(mi);

		this.add(menu);

		menu = new JMenu("Game");

		mi = new JMenuItem("Reset"); 
		mi.addActionListener(this);
		menu.add(mi);

		this.add(menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hi, You pressed "+ e.getActionCommand());
	}

}
