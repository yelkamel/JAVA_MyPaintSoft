package plugin.basic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import plugin.IPlugin;

public class Binary implements IPlugin
{
	@Override
	public BufferedImage perform(BufferedImage img)
	{
		BufferedImage imgBinaire = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
		Graphics2D surfaceImg = imgBinaire.createGraphics();
		surfaceImg.drawImage(img, null, null);   
	//	mg.setImage(imgBinaire);
		return imgBinaire;
	}

	@Override
	public String getName()
	{
		return "Binary";
	}
}
