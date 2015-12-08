package plugin.basic;

import java.awt.Color;
import java.awt.image.BufferedImage;

import plugin.IPlugin;

public class InvertColors implements IPlugin
{

	@Override
	public BufferedImage perform(BufferedImage img)
	{
		int RGBA = 0;
		Color c;
		for (int x = 0; x < img.getWidth(); x++)
		{
			for (int y = 0; y < img.getHeight(); y++)
			{
				RGBA = img.getRGB(x, y);
				c = new Color(RGBA, true);
				c = new Color(Math.abs(c.getRed() - 255), Math.abs(c
						.getGreen() - 255), Math.abs(c.getBlue() - 255));
				img.setRGB(x, y, c.getRGB());
			}
		}
		return img;
	}

	@Override
	public String getName()
	{
		return "Invert Color";
	}
}
