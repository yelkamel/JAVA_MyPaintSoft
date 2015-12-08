package Controller;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import View.ImagePanel;


public class Resize
{
	public Resize()
	{
	}

	public void reduire(ImagePanel mg)
	{
		BufferedImage img = mg.getImage();
		BufferedImage imageReduite = new BufferedImage((int)(img.getWidth()*0.5),(int)( img.getHeight()*0.5), img.getType());
		AffineTransform reduire = AffineTransform.getScaleInstance(0.5, 0.5);
		int interpolation = AffineTransformOp.TYPE_BICUBIC;
		AffineTransformOp retaillerImage = new AffineTransformOp(reduire, interpolation);
		retaillerImage.filter(img, imageReduite );
		mg.setImage(imageReduite);
	}


	public void agrandir(ImagePanel mg)
	{
		BufferedImage img = mg.getImage();
		BufferedImage imageZoomer = new BufferedImage((int)(img.getWidth()*1.5),(int)( img.getHeight()*1.5), img.getType());
		AffineTransform agrandir = AffineTransform.getScaleInstance(1.5, 1.5);
		int interpolation = AffineTransformOp.TYPE_BICUBIC;
		AffineTransformOp retaillerImage = new AffineTransformOp(agrandir, interpolation);
		retaillerImage.filter(img, imageZoomer );
		mg.setImage(imageZoomer);
	}
}
