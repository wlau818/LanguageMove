import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	
	private BufferedImage[] backgrounds;
	
	public Background(String i) {
		try {
			backgrounds[0] = ImageIO.read(new File("C:\\Users\\winni\\OneDrive\\Pictures\\Screenshots\\town.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
