package plugin.bonus;

import java.awt.Color;
import java.awt.image.BufferedImage;

import plugin.IPlugin;

public class Freeze implements IPlugin
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
				Color bufo = new Color(img.getRGB(x, y));
				Color buf = new Color(img.getRGB(x, y));

				// if(x % 15 == 0 || y % 15 == 0)
				if (bufo.getBlue() * 1.5 <= 255)
					buf = new Color(bufo.getRed(),
							bufo.getGreen(), (int) (bufo.getBlue() * 1.5));
				res.setRGB(y, img.getWidth() - x - 1, buf.getRGB());
			}
		}

		return res;
	}

	@Override
	public String getName()
	{
		return "Freeze";
	}
}
