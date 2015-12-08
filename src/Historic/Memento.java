package Historic;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import View.ImagePanel;

public class Memento
{
	public static ArrayList<BufferedImage> list;
	public static int index;
	
	public Memento ()
	{
		index = 0;
		list = new ArrayList<>();
	}
	
	public void add_i(BufferedImage image)
	{
		if (index == list.size())
			list.add(image);
		else
		{
			while (index != list.size())
				list.remove(list.size());
			list.add(image);
		}
		index++;
	}
	
	public BufferedImage get_i()
	{
		index--;
		return list.get(index);
	}

	public Memento getSavedState()
	{
		return null;
	}
	
	
} 
