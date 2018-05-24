import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonHandler extends KeyAdapter {

	public ButtonHandler() {
		System.out.println(" Button handler initialised! ");

	}

	// This function will be used as soon as a key is released.
	public void keyPressed(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			Instances.player.setUp(true);
			System.out.println("Pressed UP!");
			break;
		case KeyEvent.VK_DOWN:
			Instances.player.setDown(true);
			System.out.println("Pressed Down!");
			break;
		case KeyEvent.VK_LEFT:
			Instances.player.setLeft(true);
			System.out.println("Pressed Left!");
			break;
		case KeyEvent.VK_RIGHT:
			Instances.player.setRight(true);
			System.out.println("Pressed Right!");
			break;
		case KeyEvent.VK_SPACE:
			Instances.player.setRun(true);
			break;
		}
	}

	// This function will be used as soon as a key is released. they KeyEvent
	// key we can use to determine what key we just released
	public void keyReleased(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			Instances.player.setUp(false);
			System.out.println("Released UP!");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Released DOWN!");
			Instances.player.setDown(false);
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("Released LEFT!");
			Instances.player.setLeft(false);
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("Released RIGHT!");
			Instances.player.setRight(false);
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Released SPACE!");
			Instances.player.setRun(false);
			break;
		}
	}
}