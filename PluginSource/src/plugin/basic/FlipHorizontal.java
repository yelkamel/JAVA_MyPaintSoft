package plugin.basic;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import plugin.IPlugin;

public class FlipHorizontal implements IPlugin
{
	@Override
	public BufferedImage perform(BufferedImage img)
	{
        BufferedImage image = img;
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);
        return image;
	}

	@Override
	public String getName()
	{
		return "Flip Horizontal";
	}
}
