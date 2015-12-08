package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import View.Menu;

public class Open extends Menu
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Open()
	{

	}

	public static void openfile(Projet img)
	{
		img.ajouterimg(new File("/Users/YouCef/Desktop/img.jpeg"));
		/*
		 * JFileChooser openimage = new JFileChooser(); if
		 * (openimage.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
		 * img.ajouterimg(new File(openimage.getSelectedFile()
		 * .getAbsolutePath())); }
		 */

	}
	
	public static Projet openprojet ()
	{
		Projet p = null;
		
		FileInputStream file = null;
		ObjectInputStream oos = null;
		
		try
		{
			file = new FileInputStream("/Users/YouCef/Desktop/testprojet"
				+ ".myPSD");
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

		try
		{
			oos = new ObjectInputStream(file);

		} catch (IOException e)
		{
			e.printStackTrace();
		} 
		try
		{
			p = (Projet) oos.readObject();
			oos.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		return p;
	}
}
