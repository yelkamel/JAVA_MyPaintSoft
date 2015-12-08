package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import View.ImagePanel;
import View.Menu;

public class Save extends Menu
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static File savefile (ImagePanel img)
	{
		File filesave = new File("/Users/YouCef/Desktop/test"
			+ ".JPG");

	/*
	 * JFileChooser saveimage = new JFileChooser(); if
	 * (saveimage.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
	 * 
	 * File filesave = new File(saveimage
	 * .getSelectedFile().getAbsolutePath() + ".JPG");
	 * img.enregistrerimg(filesave); }
	 * 
	 */
		return filesave;
	}
	
	public static void saveproject (Projet p)
	{
		FileOutputStream file = null;
		ObjectOutputStream oos = null;
		
		try
		{
			file = new FileOutputStream("/Users/YouCef/Desktop/testprojet"
				+ ".myPSD");
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

		try
		{
			oos = new ObjectOutputStream(file);
		} catch (IOException e)
		{
			e.printStackTrace();
		} 
		try
		{
			oos.writeObject(p);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
