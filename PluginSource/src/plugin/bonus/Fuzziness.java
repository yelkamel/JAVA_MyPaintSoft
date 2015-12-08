package plugin.bonus;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import plugin.IPlugin;

public class Fuzziness implements IPlugin
{
	@Override
	public BufferedImage perform(BufferedImage img) 
	{
		BufferedImage imageFlou = new BufferedImage(img.getWidth(),img.getHeight(), img.getType());
		float[ ] masqueFlou = 
		{
				0.1f, 0.1f, 0.1f,
				0.1f, 0.2f, 0.1f,
				0.1f, 0.1f, 0.1f
		};
		Kernel masque = new Kernel(3, 3, masqueFlou);
		ConvolveOp operation = new ConvolveOp(masque);
		operation.filter(img, imageFlou);
		return (imageFlou);
	}

	@Override
	public String getName() 
	{
		return "Blur Effect";
	}
}
