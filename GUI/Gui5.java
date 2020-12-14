import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui5 {
	JFrame frame;
	JLabel label;

	public static void main(String[] args) {
		Gui5 gui = new Gui5();
		gui.go();
	}

	public void go() {
		frame =  new JFrame("Two buttons");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton labelButton = new JButton("Change label");
		labelButton.addActionListener(new LabelListener());

		JButton colourButton = new JButton("Change colour");
		colourButton.addActionListener(new ColourListener());

		label = new JLabel("I'm a label");

		MyDrawPanel drawPanel = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, colourButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	// inner class for label
	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			label.setText("New text");
		}
	}

	// inner class for colour change
	class ColourListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
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


