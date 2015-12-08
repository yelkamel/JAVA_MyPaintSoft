package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import View.Menu;

public class MyAction extends Menu
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7473773870887278267L;

	/**
	 * 
	 */
	public void newproj()
	{
		final JFrame frame = new JFrame("New Project");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(200, 200, 200, 100);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel);
		final JLabel n = new JLabel("Project name ?", JLabel.LEFT);
		panel.add(n);

		final JTextField name = new JTextField(10);
		panel.add(name, BoxLayout.Y_AXIS);

		JPanel b = new JPanel();
		panel.add(b);

		JButton val = new JButton("Ok");
		val.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setprojectname(name.getText());
				System.out.println(name.getText());
				frame.dispose();
			}
		});
		b.add(val);

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		b.add(cancel);
	}
}
