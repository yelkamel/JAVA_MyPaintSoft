package plugin.basic;

import java.awt.image.BufferedImage;

import plugin.IPlugin;

public class RotateRight implements IPlugin
{
	@Override
	public BufferedImage perform(BufferedImage img)
	{
		int w = img.getHeight();
		int h = img.getWidth();
		BufferedImage res = new BufferedImage(w, h, img.getType());
		int x = 0;
		int y = 0;

		for (; x < img.getWidth(); x++)
		{
			for (; y < img.getHeight(); y++)
			{
				res.setRGB(y, img.getWidth() - x - 1, img.getRGB(x, y));
			}
		}

		return res;

	}

	@Override
	public String getName()
	{
		return "Rotate Right";
	}
}
