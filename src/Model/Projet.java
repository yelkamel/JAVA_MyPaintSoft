package Model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import View.ImagePanel;

public class Projet implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final ArrayList<ImagePanel> listimg = new ArrayList<>();
	public String name = null;
	public int h = 0;
	public int l = 0;
	private ImagePanel img = null;
	
	public Projet()
	{
	}
	
	public void ajouterimg(File fichierImage)
	{
		
		try
		{
			img = new ImagePanel (ImageIO.read(fichierImage), fichierImage.getName());
			listimg.add(img);
			h = img.getHeight();
			l = img.getWidth();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public ImagePanel getI()
	{
		return img;
	}
	
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	public void setlistimg(ImagePanel im)
	{
		listimg.add(im);
	}
	
	public void removeimg(int i)
	{
		listimg.remove(i);
	}

	public ArrayList<ImagePanel> getlist ()
	{
		return listimg;
	}
	
	public int getsize()
	{
		return listimg.size();
	}
}
