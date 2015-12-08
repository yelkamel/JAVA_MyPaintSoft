package Controller;

import java.awt.image.BufferedImage;

import javax.swing.SwingWorker;

import plugin.IPlugin;
import View.ImagePanel;

public class SetFilter implements Runnable
{
	ImagePanel img = null;
	BufferedImage res = null;
	IPlugin plug = null;
	
	public SetFilter (ImagePanel tmp, IPlugin pl)
	{
		img = tmp;
		plug = pl;
	}

	public BufferedImage getbi()
	{
		return res;
	}

	@Override
	public void run()
	{
		res = plug.perform(img.getImage());
	}
}
