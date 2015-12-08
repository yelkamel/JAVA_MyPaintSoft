package Model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Loading extends JDialog implements ActionListener
{
	JFrame p = null;
	boolean t = false;
	JPanel panel = null;
	ImageIcon imageIcon = null;
	JLabel iconLabel = null;
	JButton pinceau = null;

	public Loading(JFrame parent, String title, String message)
	{
		super(parent, title, true);

		ImageIcon imageIcon = new ImageIcon("img/loading.gif");
		JLabel iconLabel = new JLabel();

		if (parent != null)
		{
			Dimension parentSize = parent.getSize();
			Point p = parent.getLocation();
			setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
		}
		JPanel messagePane = new JPanel();
		messagePane.add(new JLabel(message));
		getContentPane().add(messagePane);
		JPanel buttonPane = new JPanel();
		JButton button = new JButton("Cancel");

		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				t = true;
			}
		});
		t = false;
		iconLabel.setIcon(imageIcon);
		imageIcon.setImageObserver(iconLabel);
		buttonPane.add(iconLabel);
		buttonPane.add(button);
		button.addActionListener(this);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public boolean getb()
	{
		return t;
	}

	public void actionPerformed(ActionEvent e)
	{
		setVisible(false);
		dispose();
	}
}

/*
 * public class Loading { JFrame p = null; boolean t = false; JPanel panel =
 * null; ImageIcon imageIcon = null; JLabel iconLabel = null; JButton pinceau =
 * null;
 * 
 * public Loading() { JPanel panel = new JPanel(); ImageIcon imageIcon = new
 * ImageIcon("img/loading.gif"); JLabel iconLabel = new JLabel(); JButton
 * pinceau = new JButton("Cancel");
 * 
 * JFrame frame = new JFrame(" - Loading ... - ");
 * frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 * frame.setBounds(200, 200, 170, 80);
 * 
 * pinceau.addActionListener(new ActionListener() { public void
 * actionPerformed(ActionEvent e) { t = true; p.setVisible(false); } });
 * iconLabel.setIcon(imageIcon); imageIcon.setImageObserver(iconLabel);
 * 
 * panel.add(iconLabel); panel.add(pinceau); frame.add(panel);
 * 
 * this.panel = panel; this.iconLabel = iconLabel; this.pinceau = pinceau;
 * this.imageIcon = imageIcon; this.p = frame; }
 * 
 * public boolean getb() { return t; }
 * 
 * public void goload() { iconLabel.setVisible(true); pinceau.setVisible(true);
 * panel.setVisible(true); p.pack();
 * 
 * p.setVisible(true); }
 * 
 * public void finishload() {
 * 
 * iconLabel.setVisible(false); pinceau.setVisible(false);
 * panel.setVisible(false); p.setVisible(false); t = false; }
 * 
 * }
 */
