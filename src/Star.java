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
public class Star extends GameObj {
	public static final String img_file = "star.png";
	public static final int SIZE = 20;
	public static final int INIT_POS_Y = 0;
	public static final int INIT_VEL_X = 3;
	public static final int INIT_VEL_Y = 15;
	
	private static BufferedImage img;

	public Star(int courtWidth, int courtHeight) {
		super((int) (Math.random() * INIT_VEL_X), (int) (Math.random() * INIT_VEL_Y) + 5, 
				(int) (Math.random() * courtWidth), INIT_POS_Y, SIZE, SIZE, courtWidth, 
				courtHeight);
		
		try {
			if (img == null) {
				img = ImageIO.read(new File(img_file));
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
		
		super.setHeight((int) (img.getHeight() / 10.0));
		super.setWidth((int) (img.getWidth() / 10.0));		
		super.setcourtWidth(courtWidth - width);
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, pos_x, pos_y, width, height, null);
	}
	
	@Override
	public void clip(){
		if (pos_x < 0) pos_x = 0;
		else if (pos_x > max_x) pos_x = max_x;

	}

	
	@Override
	public boolean intersects(GameObj obj){
		return (pos_x + this.width >= obj.pos_x
				&& pos_y + this.height >= obj.pos_y
				&& obj.pos_x + obj.width >= pos_x 
				&& obj.pos_y + obj.height >= pos_y);
	}
}