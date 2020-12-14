import javax.swing.*;
import java.awt.event.*;

// an instance of Gui2 IS-A ActionListener
public class Gui2 implements ActionListener {
	JButton button;

	public static void main(String[] args) {
		Gui2 gui = new Gui2();
		gui.go();
	}

	public void go() {
		JFrame frame =  new JFrame();
		button = new JButton("click");

		// add button to list of listeners; must be an object from a class that implements ActionListener
		button.addActionListener(this);

		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	// the event handling method; implements the ActionListener interface's actionPerformed() method
	public void actionPerformed(ActionEvent event) {
		button.setText("I've been clicked.");
	}

}
