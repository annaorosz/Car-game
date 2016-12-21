/**
 * CIS 120 Game HW
 * Anna Orosz
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A basic game object displayed as a yellow circle, starting in the upper left
 * corner of the game court.
 * 
 */
public class Explosion extends GameObj {
	public static final String img_file = "explosion.png";
	public static int SIZE = 20;
	public static final int INIT_POS_X = 0;
	public static final int INIT_POS_Y = 0;
	public static final int INIT_VEL_X = 0;
	public static final int INIT_VEL_Y = 0;
	
	private static BufferedImage img;

	public Explosion(int courtWidth, int courtHeight, int px, int py) {
		super(INIT_VEL_X, INIT_VEL_Y, px, py, SIZE, SIZE,
				courtWidth, courtHeight);
		
		try {
			if (img == null) {
				img = ImageIO.read(new File(img_file));
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
		
		super.setHeight((int) (img.getHeight() / 5.0));
		super.setWidth((int) (img.getWidth() / 5.0));		
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, pos_x, pos_y, width, height, null);
	}
	

}