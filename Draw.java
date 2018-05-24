import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw extends Canvas {
	private JFrame frame = null;
	private Canvas canvas = null;
	private BufferedImage map = null;
	private BufferedImage map2 = null;
	private BufferedImage current = null;
	
	private BufferedImage chara = null;

	BufferStrategy bufferStrategy;
	private final int tile_X = 8, tile_Y = 8, tile_R = 100, tile_C = 100;
	private final int tile_Total = tile_R * tile_C;
	private final int map_Size = tile_X * tile_Y * tile_Total;
	
	private final int WIDTH = 480;
	private final int HEIGHT = 320;
	
	private boolean change = false;

	public Draw() {
		//Load the first map
		try {
			map = ImageIO.read(new File("C:\\Users\\winni\\OneDrive\\Pictures\\Screenshots\\town.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			map2 = ImageIO.read(new File("C:\\Users\\winni\\OneDrive\\Pictures\\Screenshots\\House.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		current = map;
		chara = Instances.player.getImage();
		// Makes a new window, with the name " Basic game ".
		frame = new JFrame("Basic Game");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(map.getWidth() - 10, map.getHeight() - 10));
		panel.setSize(map.getWidth(), map.getHeight());
		panel.setLayout(null);

		canvas = new Canvas();
		canvas.setBounds(0, 0, map.getWidth(), map.getHeight());
		canvas.setIgnoreRepaint(true);
		canvas.setSize(map.getWidth(), map.getHeight());
		frame.setSize(map.getWidth(), map.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		// this will make the frame not re-sizable
		frame.setResizable(false);
		frame.setVisible(true);
		// this will add the canvas to our frame
		panel.add(canvas);
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		// This will make sure the canvas has focus, so that it can take input
		// from mouse/keyboard
		canvas.requestFocus();
		// this will set the background to black
		//canvas.setBackground(Color.black);
		// This will add our button handler to our program
		canvas.addKeyListener(new ButtonHandler());

	}

	/*@Override
	public Dimension getPreferredSize() {
		return (map == null) ? new Dimension(this.WIDTH, this.HEIGHT) : new Dimension(map.getWidth(), map.getHeight());
	}*/

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (map != null) {
			if (change) {
				current = map2;
			}
			g.drawImage(current, 0, 0, this);
		}
	}

	public void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		paint(g);
		render(g);
		g.setColor(Color.MAGENTA);
		//g.drawString("Hello", 50, 50);
		g.dispose();
		bufferStrategy.show();
	}

	protected void render(Graphics2D g) {
		g.setColor(Color.pink);
		if (Instances.player.getX() > 688) {
			
			g.drawImage(Instances.player.getImage(), 0, Instances.player.getY(), this);
			Instances.player.setX(0);
			change = true;
			
		} else if (Instances.player.getY() > 544) {
			
			g.drawImage(Instances.player.getImage(), Instances.player.getX(), 0, this);
			Instances.player.setY(0);
			
		} else if (Instances.player.getX() < 0) {
			
			g.drawImage(Instances.player.getImage(), 688, Instances.player.getY(), this);
			Instances.player.setX(688);
			
		} else if (Instances.player.getY() < 0) {
			
			g.drawImage(Instances.player.getImage(), 0, 544, this);
			Instances.player.setY(544);
			
		} else {
			g.drawImage(Instances.player.getImage(), Instances.player.getX(), Instances.player.getY(), this);
		}
		//System.out.println("Difference in Y:" + (map.getHeight() - 544));// x = 54 y = 65
		//g.fillRect(Instances.player.getX(), Instances.player.getY(), 15, 15);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public int getHeight() {
		return map.getHeight() - 10;
	}
	
	public int getWidth() {
		return map.getWidth() - 10;
	}
}