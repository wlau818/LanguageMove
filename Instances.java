

public class Instances {
	static int tile_X = 8, tile_Y = 8;
	
	static String left = "C:\\Users\\winni\\OneDrive\\Pictures\\Screenshots\\girlL.png";
	static String right = "C:\\Users\\winni\\OneDrive\\Pictures\\Screenshots\\girlR.png";
	static String up = "C:\\Users\\winni\\OneDrive\\Pictures\\Screenshots\\girlU.png";
	static String down = "C:\\Users\\winni\\OneDrive\\Pictures\\Screenshots\\girl.png";
	
	public static Player player = new Player(tile_X, tile_Y, left, right, up, down);
	static String map = "C:\\Users\\winni\\OneDrive\\Pictures\\Screenshots\\town.png";
	
	public static Wall w = new Wall(map);
	
	//public static Wall walls = new Wall(tile_X, tile_Y);
}
