package plugin.bonus;

import java.awt.image.BufferedImage;

import plugin.IPlugin;

public class Miroir implements IPlugin
{

	@Override
	public BufferedImage perform(BufferedImage img)
	{
		int h = img.getHeight();
		int w = img.getWidth();
		BufferedImage res = new BufferedImage(w, h, img.getType());
		int x = 0;
		int y = 0;

		for (; x < img.getWidth() / 2; x++)
		{
			for (; y < img.getHeight() / 2; y++)
			{
				res.setRGB(x, y, img.getRGB(w - x, y));
			}
		}

		return res;
	}

	@Override
	public String getName()
	{
		return "Mirroir";
	}

}
