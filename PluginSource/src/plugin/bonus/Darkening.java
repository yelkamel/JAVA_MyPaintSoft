package plugin.bonus;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import plugin.IPlugin;

public class Darkening implements IPlugin
{
	@Override
	public BufferedImage perform(BufferedImage img)
	{
		BufferedImage imgSombre = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		RescaleOp assombrir = new RescaleOp(0.7f, 10, null);
		assombrir.filter(img, imgSombre);
		return (imgSombre);
	}

	@Override
	public String getName()
	{
		return "Darkening";
	}
}
