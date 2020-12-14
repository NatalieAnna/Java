import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui4 implements ActionListener {
	JFrame frame;

	public static void main(String[] args) {
		Gui4 gui = new Gui4();
		gui.go();
	}

	public void go() {
		frame =  new JFrame("Colour changing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Change colours");
		button.addActionListener(this);

		MyDrawPanel drawPanel = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		// frame repaints itself after user clicks button
		// means that paintComponent() is call on every widget in the frame
		frame.repaint();
	}
}

class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
		// paint randomly coloured circle on black background
		// x, y = 0 pixels from left and top edge, width/height as wide/tall as panel
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		int red = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		Color randomColor = new Color(red, green, blue);
		g.setColor(randomColor);
		// start 70 pixels from left and right, 100 pixels wide and tall
		g.fillOval(70, 70, 100, 100);
	}
}

