import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BackImage extends JFrame{
	
	JLabel ground;
	private int width;
	private int height;
	
	public BackImage() {
		setTitle("back");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		ImageIcon pic = new ImageIcon("C:\\Users\\winni\\OneDrive\\Pictures\\Saved Pictures\\FEEBAS!!!.png");
		setContentPane(new JLabel(pic));
		setLayout(new FlowLayout());
		ground = new JLabel("APPLE");
		ground.setFont(new Font("Serif", Font.PLAIN, 100));
		ground.setForeground(Color.WHITE);
		add(ground);
		//pic.getIconWidth();
		width = pic.getIconWidth();
		height = pic.getIconHeight();
		setSize(width, height);
	}
	public int getWidth() {
		return width;
	} 
	
	public int getHeight() {
		return height;
	}

	public static void main(String[] args) {
		new BackImage();
	}
	

}
