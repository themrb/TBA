import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class TBA implements ActionListener {

	char keypressed;
	
	final static Integer xcanvas = 500, ycanvas = 300;
	final static int delay = 10; // milliseconds

	private GameComponent canvas;
	private Game game;
	private Timer timer;
	private JFrame jframe;

	public TBA() {
		jframe = new JFrame("Space Invaders Game");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new GameComponent(xcanvas, ycanvas);
		(jframe.getContentPane()).add(canvas);
		timer = new Timer(delay, this);
		jframe.pack();
		jframe.setVisible(true);
	}

	public void runGame() {
		System.out.println("Start Game.");
		setbackground();
		game = new Game();
		timer.start();
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == timer) {

			canvas.clearOffscreen();
			canvas.drawOffscreen();
			game.step(canvas);
			canvas.keypressed = 'g';
			/*if (false) {  // main step
				canvas.clearOffscreen();
				game.draw(canvas);
				canvas.drawOffscreen();
				game.step(canvas);
			} else {  // the game has ended
				if (false) {
					Graphics g = canvas.getOffscreenGraphics();
					g.setColor(Color.DARK_GRAY);
					g.setFont(new Font("Monospaced", Font.BOLD, 32));
					g.drawString((true ? "You Lost !!!" : "You Win!!!!"),
							xcanvas / 2 - 100, ycanvas / 2);
					canvas.drawOffscreen();
				}
				System.out.println("Completed Game.");
				timer.stop();
			}*/
		}
	}

	private void setbackground() {
		Graphics g = canvas.getBackgroundGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, xcanvas, ycanvas);
	}

	public static void main(String[] args)  {

		TBA sim;
		System.out.println("Starting Game.");
		sim = new TBA();
		
		sim.runGame();
		System.out.println("lol owned");

	}
}
