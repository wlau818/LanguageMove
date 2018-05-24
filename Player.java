import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player{
	// variables which we will use
	private int x, y, tile_X, tile_Y;
	private boolean left = false, right = false, up = false, down = false, space = false;
	private int walk_speed = 300, run_speed = 100;
	
	private BufferedImage charaL;
	private BufferedImage charaR;
	private BufferedImage charaU;
	private BufferedImage charaD;
	
	private BufferedImage current;

	public Player(int tile_X, int tile_Y, String locL, String locR, String locU, String locD) {
		this.tile_X = tile_X;
		this.tile_Y = tile_Y;
		try {
	    	charaL = ImageIO.read(new File(locL));
	    } catch (IOException e) {
	    	
	    }
		try {
	    	charaR = ImageIO.read(new File(locR));
	    } catch (IOException e) {
	    	
	    }
		try {
	    	charaU = ImageIO.read(new File(locU));
	    } catch (IOException e) {
	    	
	    }
		try {
	    	charaD = ImageIO.read(new File(locD));
	    } catch (IOException e) {
	    	
	    }
		
		current = charaR;
		x = 0;
		y = 224;
	}

	// These 4 functions are able to set the direction
	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setRun(boolean space) {
		this.space = space;
	}

	// This function will return X as an int.
	public int getX() {
		return x;
	}

	// And this function will return Y as an int.
	public int getY() {
		return y;
	}

	public void update() {
		move();
	}

	// This function will move the player according to its direction and speed
	public void move() {
		int sleep = (space) ? this.run_speed : this.walk_speed;
		//System.out.println(width);
		//System.out.println(height);
		if (left) {
			x -= tile_X;
			
			
			current = charaL;
			//if (x - tile_X >= 0) {
			//	x -= tile_X;
			//}			
			//System.out.println(x);
		} else if (right) {
			
			x += tile_X;
			
			current = charaR;
			//if (x + tile_X <= width) {
			//	x += tile_X;
			//}
			//System.out.println(x);
		} else if (up) {
			
			y -= tile_Y;
			
			current = charaU;
			//if (y - tile_Y >= 0) {
			//	y -= tile_Y;
			//}
			
			//System.out.println(y);
		} else if (down) {
			
			y += tile_Y;
			
			current = charaD;
			//if (y + tile_Y <= height) {
			//	y += tile_Y;
			//}
			//System.out.println(y);
		}
		System.out.println("x: " + x); //688
		System.out.println("y: " + y); //544
		wait(sleep);
	}

	public void wait(int length) {
		long time = System.currentTimeMillis();
		long finish = time + length;
		while (true) {
			time = System.currentTimeMillis();
			if (time >= finish)
				break;
		}
	}
	
	public BufferedImage getImage() {
		return current;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
}