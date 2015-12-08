package plugin.basic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import plugin.IPlugin;

public class FlipVertical implements IPlugin
{
	@Override
	public BufferedImage perform(BufferedImage img)
	{
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dg = new BufferedImage(w, h, img.getColorModel()
                .getTransparency());
        Graphics2D g = dg.createGraphics();
        g.drawImage(img, 0, 0, w, h, 0, h, w, 0, null);
        g.dispose();
        return dg;

	}

	@Override
	public String getName()
	{
		return "Flip Vertical";
	}
}
