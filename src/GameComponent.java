import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
/**
 * 
 * GameJComponent - This class enables double buffering for a simple game. To use
 * this class construct the GameJComponent of your desired size. Draw the required fixed
 * background using the Graphics object obtained from getBackgroundGraphics.
 * Then in the simulation loop: + clearOffscreen + either add images to the
 * off screen with drawImage or draw using the Graphics object obtained via
 * getOffscreenGraphic() + drawOffscreen
 * 
 * This class also listens for key presses.  
 * 
 * 
 * @author Eric McCreath
 * 
 * Copyright 2005
 * 
 */
public class GameComponent extends JComponent implements KeyListener {

	Integer xdim, ydim; // the size of the JComponent

	private BufferedImage background;

	private BufferedImage offscreen;
	
	char keypressed;


	public GameComponent(int xd, int yd) {
		xdim = xd;
		ydim = yd;
		this.setSize(xdim, ydim);
		this.setPreferredSize(new Dimension(xdim,ydim));
		background = new BufferedImage(xdim, ydim, BufferedImage.TYPE_INT_RGB);
		offscreen = new BufferedImage(xdim, ydim, BufferedImage.TYPE_INT_RGB);
		this.setFocusable(true);
		addKeyListener(this);
		keypressed = 'g';
	}

	public void clearOffscreen() {
		Graphics g = offscreen.getGraphics();
		g.drawImage(background, 0, 0, null);
	}

	public Graphics getBackgroundGraphics() {
		return background.getGraphics();
	}

	public Graphics getOffscreenGraphics() {
		return offscreen.getGraphics();
	}

	public void drawImage(Image i, int x, int y) {
		Graphics g = offscreen.getGraphics();
		g.drawImage(i, x, y, null);
	}

	public void drawOffscreen() {
		Graphics g;
		g = this.getGraphics();
		g.drawImage(offscreen, 0, 0, null);
	}

	public void paint(Graphics g) {
		g.drawImage(offscreen, 0, 0, null);
	}

public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {

			keypressed = '4';
		} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {

			keypressed = '6';
		} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {

			keypressed = '8';
		} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {

			keypressed = '2';
		} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {

			keypressed = '7';
		} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {

			keypressed = '9';
		} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {

			keypressed = '3';
		} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {

			keypressed = '1';
		} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {

			keypressed = '5';
		}
		
	}

	
	public void keyReleased(KeyEvent arg0) {
		keypressed = 'g';
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}