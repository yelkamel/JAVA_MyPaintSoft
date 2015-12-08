package plugin.bonus;

import java.awt.Color;
import java.awt.image.BufferedImage;

import plugin.IPlugin;

public class Quadirllage implements IPlugin
{
	@Override
	public BufferedImage perform(BufferedImage img)
	{
		int h = img.getHeight();
		int w = img.getWidth();
		BufferedImage res = new BufferedImage(w, h, img.getType());
		int x = 0;
		int y = 0;

		for (; x < w; x++)
		{
			for (; y < h; y++)
			{
				Color buf = new Color(img.getRGB(x, y));
				 if(x % 20 == 0 || y % 20 == 0)
					buf = new Color(0,0,0);
				 res.setRGB(y, img.getWidth() - x - 1, buf.getRGB());
			}
		}

		return res;
	}

	@Override
	public String getName()
	{
		return "Grid";
	}
	
}
