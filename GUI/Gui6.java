import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui6 {
	JFrame frame;
	// coordinates of dot
	int x = 70;
	int y = 70;

	public static void main(String[] args) {
		Gui6 gui = new Gui6();
		gui.go();
	}

	public void go() {
		frame =  new JFrame("Animation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel drawPanel = new MyDrawPanel();

		frame.getContentPane().add(drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);

		for (int i = 0; i < 130; i++) {
			x++;
			y++;
			drawPanel.repaint();

			// slow it down
			try {
				Thread.sleep(50);
			} catch(Exception ex) {}
		}
	}

	// this time it's an inner class
	class MyDrawPanel extends JPanel {
		public void paintComponent(Graphics g) {
			// fill frame with white bg else the dot smears
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			g.setColor(Color.green);
			// use the continually-updated coordinates of the outer class
			g.fillOval(x, y, 40, 40);
		}
	}
}


