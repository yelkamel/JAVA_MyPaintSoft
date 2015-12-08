package View;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JToolBar;

public class MyToolBar extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyToolBar ()
	{
		
	}
	  public static void setbar (JFrame frame)
	  {
		//  JFrame frame = new JFrame("Create a toolbar Which have three ");
		  JToolBar toolbar = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
		  JButton cutbutton = new JButton(new ImageIcon("cut.gif"));
		  toolbar.add(cutbutton);
		  JButton copybutton = new JButton(new ImageIcon("copy.gif"));
		  toolbar.add(copybutton);
		  JButton pastebutton = new JButton(new ImageIcon("paste.gif"));
		  toolbar.add(pastebutton);
		  frame.getContentPane().add(toolbar,BorderLayout.NORTH);
		  frame.setUndecorated(true);
		  frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(500,400);
		  frame.setVisible(true);
	  }
}
