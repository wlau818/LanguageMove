import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.security.jca.GetInstance.Instance;

public class Wall {
	public boolean[][] walls = null;
	public int tile_X, tile_Y;
	
	private boolean[][] wall;
	private BufferedImage back;

	public Wall(String map) {
		try {
			back = ImageIO.read(new File(map));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		wall = new boolean[back.getWidth()][back.getHeight()];
		
		for (int i = 0; i < 100; i ++) {
			for (int j = 0; j < 50; j ++) {
				wall[i][j] = true;
			}
		}
		
		//walls = new boolean[tile_X][tile_Y];
		//this.tile_X = tile_X;
		//this.tile_Y = tile_Y;
	}
	
	public boolean[][] getLocations() {
		return wall;
	}
	
	public int getHeight() {
		return tile_Y;
	}
	
	public boolean canPass(int x, int y) {
		if (wall[x][y]) {
			return false;
		}
		return true;
	}
}
