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
 * A basic game object displayed as a black square, starting in the upper left
 * corner of the game court.
 * 
 */
public class Player extends GameObj {
	public static final String img_file = "player.png";
	public static final int SIZE = 20;
	public static final int INIT_VEL_X = 0;
	public static final int INIT_VEL_Y = 0;
	
	private static BufferedImage img;

	/**
	 * Note that, because we don't need to do anything special when constructing
	 * a Player, we simply use the superclass constructor called with the
	 * correct parameters
	 */
	public Player(int courtWidth, int courtHeight) {
		super(INIT_VEL_X, INIT_VEL_Y, (int) (courtWidth / 2.0), courtHeight - 
				SIZE, SIZE, SIZE, courtWidth, courtHeight);
		
		try {
			if (img == null) {
				img = ImageIO.read(new File(img_file));
				
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
		
		super.setHeight((int) (img.getHeight() / 5.0));
		super.setWidth((int) (img.getWidth() / 5.0));
		super.setY(courtHeight - height);
		super.setcourtWidth(courtWidth - width);
		
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, pos_x, pos_y, width, height, null);
	}
	
	@Override
	public boolean intersects(GameObj obj){
		return (pos_x + this.width >= obj.pos_x
				&& pos_y + this.height >= obj.pos_y
				&& obj.pos_x + obj.width >= pos_x 
				&& obj.pos_y + obj.height >= pos_y);
	}

}
