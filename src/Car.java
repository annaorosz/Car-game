/** 
 * Car Game
 * Author: Anna Orosz
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Car Object.
 * 
 */
public class Car extends GameObj {
	public static final String img_file = "car.png";
	public static final int SIZE = 20;
	public static final int INIT_POS_Y = 0;
	public static final int INIT_VEL_X = 1;
	public static final int INIT_VEL_Y = 10;
	
	private static BufferedImage img;

	public Car(int courtWidth, int courtHeight) {
		super((int) (Math.random() * INIT_VEL_X), (int) (Math.random() * INIT_VEL_Y) + 5, 
				(int) (Math.random() * courtWidth), INIT_POS_Y, SIZE, SIZE,
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
		super.setcourtWidth(courtWidth - width);
		super.pos_y = INIT_POS_Y - (int) (img.getHeight() / 5.0);
		
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

