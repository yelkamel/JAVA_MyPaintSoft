package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import plugin.IPlugin;
import Controller.MyAction;
import Controller.MyJarLoader;
import Controller.Resize;
import Controller.SetFilter;
import Model.Loading;
import Model.Open;
import Model.Projet;
import Model.Save;

public class Menu extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final JMenuItem niveauGrisMenu = new JMenuItem();
	protected final JMenuItem assombrirMenu = new JMenuItem();
	protected final JMenuItem brillanceMenu = new JMenuItem();
	protected final JMenuItem binarisationMenu = new JMenuItem();

	protected final JMenuBar menuBar = new JMenuBar();
	protected final JMenu fichierMenu = new JMenu();
	protected final JMenuItem ouvrirMenu = new JMenuItem();
	protected final JMenu filtreMenu = new JMenu();
	protected final JMenuItem enregistrerMenu = new JMenuItem();
	private final ArrayList<JMenuItem> filters = new ArrayList<>();

	private final JMenuItem newpro = new JMenuItem();
	public final JMenuItem openpro = new JMenuItem();
	public final JMenuItem savepro = new JMenuItem();
	protected final JMenuItem close = new JMenuItem();

	protected final JMenu retaillerMenu = new JMenu();
	protected final JMenuItem agrandirMenu = new JMenuItem();
	protected final JMenuItem reduireMenu = new JMenuItem();
	protected final JMenu aff = new JMenu();
	protected JTabbedPane onglet = new JTabbedPane();
	public Projet p = null;
	public MyJarLoader mj = new MyJarLoader();
	public String nameproject = null;
	public boolean des = false;

	public JButton pinceau = new JButton(new ImageIcon("img/paint.ico"));
	public JPanel b3 = new JPanel();
	public JButton savee = new JButton(new ImageIcon("img/savee.ico"));
	public JButton precedent = new JButton(new ImageIcon("img/precedent.ico"));
	public JButton suivant = new JButton(new ImageIcon("img/suivant.ico"));

	public String getprojectname()
	{
		return nameproject;
	}

	public void setprojectname(String str)
	{
		nameproject = str;
	}

	public Menu()
	{
		super();
		ouvrirMenu.setAccelerator(KeyStroke.getKeyStroke("control O"));
		enregistrerMenu.setAccelerator(KeyStroke.getKeyStroke("control S"));
		close.setAccelerator(KeyStroke.getKeyStroke("control Q"));
		newpro.setAccelerator(KeyStroke.getKeyStroke("control N"));
		reduireMenu.setAccelerator(KeyStroke.getKeyStroke("control D"));
		agrandirMenu.setAccelerator(KeyStroke.getKeyStroke("control U"));
		
		p = new Projet();
		setBounds(0, 0, 600, 475);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		try
		{
			creerMenu();
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
		savepro.setEnabled(false);
		enregistrerMenu.setEnabled(false);
		ouvrirMenu.setEnabled(false);
		/*
		 * for (LookAndFeelInfo f : UIManager.getInstalledLookAndFeels())
		 * System.out.println(f.getClassName()); try {
		 * UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"
		 * ); } catch (ClassNotFoundException | InstantiationException |
		 * IllegalAccessException | UnsupportedLookAndFeelException e) {
		 * e.printStackTrace(); }
		 */
	}

	private void creerMenu() throws Exception
	{
		setTitle("- MyPhotoShop -");
		setJMenuBar(menuBar);
		menuBar.add(fichierMenu);
		fichierMenu.setText("File");

		fichierMenu.add(newpro);
		newpro.addActionListener((ActionListener) this);
		newpro.setText("new project");

		fichierMenu.add(savepro);
		savepro.addActionListener((ActionListener) this);
		savepro.setText("save project");

		fichierMenu.add(openpro);
		openpro.addActionListener((ActionListener) this);
		openpro.setText("open project");

		fichierMenu.add(ouvrirMenu);
		ouvrirMenu.addActionListener((ActionListener) this);
		ouvrirMenu.setText("open file");

		fichierMenu.add(enregistrerMenu);
		enregistrerMenu.addActionListener((ActionListener) this);
		enregistrerMenu.setText("save file");

		fichierMenu.add(close);
		close.addActionListener((ActionListener) this);
		close.setText("close file");

		menuBar.add(retaillerMenu);
		retaillerMenu.setText("Resize");

		menuBar.add(filtreMenu);
		filtreMenu.setText("Filter");

		mj.loading();

		int i = 0;
		for (Class<?> a : mj.getC())
		{
			IPlugin b = (IPlugin) a.newInstance();
			filters.add(new JMenuItem(b.getName()));
			filters.get(i).addActionListener((ActionListener) this);
			filtreMenu.add(filters.get(i));
			i++;
		}

		retaillerMenu.add(agrandirMenu);
		agrandirMenu.addActionListener((ActionListener) this);
		agrandirMenu.setText("Grown Up");

		retaillerMenu.add(reduireMenu);
		reduireMenu.addActionListener((ActionListener) this);
		reduireMenu.setText("Grown Down");

		menuBar.add(aff);
		aff.setText("View");
		aff.add(new JMenuItem("Tool box"));
		close.setEnabled(false);

	}

	public void boiteaoutil()
	{
		// MyToolBar tb = new MyToolBar();
		// MyToolBar.setbar(this);
		getContentPane().add(onglet);

		// b3.setSize(20, 100);
		b3.setLayout(new BoxLayout(b3, BoxLayout.Y_AXIS));

		pinceau.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (des)
					des = false;
				else
					des = true;
				System.out.println(des);
			}
		});
		precedent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (p != null && onglet != null)
				{
					p.getlist().remove(onglet.getSelectedIndex()).undo();
				}
			}
		});
		b3.add(pinceau);
		b3.add(savee);
		b3.add(suivant);
		b3.add(precedent);
		// b3.setPreferredSize(new Dimension(100, 100));

		getContentPane().add(b3, BorderLayout.WEST);

	}

	public void actionPerformed(ActionEvent e)
	{
		MyAction a = new MyAction();
		Resize f = new Resize();
		if (e.getSource().equals(ouvrirMenu))
		{
			setTitle("- MyPhotoShop -");
			Open.openfile(p);
			enregistrerMenu.setEnabled(true);
			close.setEnabled(true);
			setSize(p.getI().getWidth() + 120, p.getI().getHeight() + 90);
			onglet.addTab(p.getI().getFileName(), null, p.getI());
			onglet.setSelectedIndex(p.getsize() - 1);
		} else if (e.getSource().equals(newpro))
		{
			ouvrirMenu.setEnabled(true);
			savepro.setEnabled(true);
			a.newproj();
			p.setname(nameproject);
			boiteaoutil();

		} else if (e.getSource().equals(enregistrerMenu))
		{
			p.getlist()
					.get(onglet.getSelectedIndex())
					.enregistrerimg(
							Save.savefile(p.getlist().get(
									onglet.getSelectedIndex())));
		} else if (e.getSource().equals(close))
		{
			onglet.remove(onglet.getSelectedIndex());
			p.getlist().remove(onglet.getSelectedIndex());
		} else if (e.getSource().equals(openpro))
		{
			p = Open.openprojet();
			if (onglet.isEnabled())
			{
				for (ImagePanel i : p.getlist())
					i.buildImage();
			} else
				p.getlist().get(onglet.getSelectedIndex()).buildImage();

			ouvrirMenu.setEnabled(true);
			savepro.setEnabled(true);
			close.setEnabled(true);
			boiteaoutil();
			onglet.removeAll();
			for (ImagePanel ac : p.getlist())
			{
				ac.buildImage();
				onglet.addTab(ac.getFileName(), null, ac);
			}
			setSize(p.getlist().get(onglet.getSelectedIndex()).getWidth() + 120,
					p.getlist().get(onglet.getSelectedIndex()).getHeight() + 90);
			onglet.setSelectedIndex(p.getsize() - 1);

		} else if (e.getSource().equals(savepro))
		{
			Save.saveproject(p);
		} else if (e.getSource().equals(reduireMenu))
		{
			f.reduire(p.getlist().get(onglet.getSelectedIndex()));
			p.getlist().get(onglet.getSelectedIndex()).repaint();
		} else if (e.getSource().equals(agrandirMenu))
		{
			f.agrandir(p.getlist().get(onglet.getSelectedIndex()));
			p.getlist().get(onglet.getSelectedIndex()).repaint();
		} else
		{
			for (int i = 0; i < filters.size(); i++)
			{
				if (e.getSource().equals(filters.get(i)))
				{
					ImagePanel tmp = p.getlist().get(onglet.getSelectedIndex());
					IPlugin plug = null;

					try
					{
						plug = (IPlugin) mj.getC().get(i).newInstance();
					} catch (InstantiationException e1)
					{
						e1.printStackTrace();
					} catch (IllegalAccessException e1)
					{
						e1.printStackTrace();
					}

					Loading ld = new Loading(this,"loading","please wait ...");

					SetFilter sf = new SetFilter(tmp, plug);
					Thread th = new Thread(sf);
					th.start();
					while (th.isAlive())
					{
						if (ld.getb() == true)
							th.interrupt();
					}
					ld.setVisible(false);
					ld.dispose();
					ld.removeAll();
					setSize(sf.getbi().getWidth() + 120,
							sf.getbi().getHeight() + 90);
					tmp.setImage(sf.getbi());

					break;
				}
			}
		}

		repaint();
	}

}
