package plugin.basic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import plugin.IPlugin;

public class Greyscale implements IPlugin
{
	@Override
	public BufferedImage perform(BufferedImage img)
	{
		BufferedImage imageGris = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_USHORT_GRAY);
		Graphics2D surfaceImg = imageGris.createGraphics();
		surfaceImg.drawImage(img, null, null);	 
		return (imageGris);
	}

	@Override
	public String getName()
	{
		return "GreyScale";
	}
}
