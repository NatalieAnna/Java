import java.awt.*;
import javax.swing.*;

public class Gui3 extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		// display blue square
		g.setColor(Color.blue);
		g.fillRect(20, 50, 100, 100); // coordinates & size

		// display jpeg
		Image image = new ImageIcon("banksia.jpg").getImage();
		g.drawImage(image, 3, 4, this); // 3,4 = x,y coords in pixels

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

		// paint circle with gradient
		// cast Graphics object back to Graphics2D
		Graphics2D g2d = (Graphics2D) g;
		// call method that only Graphics2D has
		// starting point, starting color, ending point, ending color
		GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.green);
		g2d.setPaint(gradient);
		// fill oval/circle with gradient
		g2d.fillOval(70, 70, 100, 100);
	}

	public static void main(String[] args) {
		Gui3 gui = new Gui3();
		JFrame frame =  new JFrame("Test");
		// if replace 'gui' with 'frame' and delete gui object, get error: IllegalArgumentException: adding container's parent to itself
		frame.add(gui, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}


