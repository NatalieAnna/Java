import javax.swing.*;

public class Gui1 {

	public static void main(String[] args) {
		JFrame frame =  new JFrame();
		JButton button = new JButton("click");

		// quits program when window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// JFrame doesn't let you add to it directly so you must add to the JFrame's content pane
		frame.getContentPane().add(button);
		frame.setSize(300, 300); // pixels
		// required to literally make frame visible
		frame.setVisible(true);
	}

}
