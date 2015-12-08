package plugin.bonus;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import plugin.IPlugin;

public class Light implements IPlugin
{
	@Override
	public BufferedImage perform(BufferedImage img) 
	{
		BufferedImage imgBrillant = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		RescaleOp brillance = new RescaleOp(1.2f, 0, null);
		brillance.filter(img, imgBrillant);
		return (imgBrillant);
	}

	@Override
	public String getName() 
	{
		return "Brightening";
	}
}
