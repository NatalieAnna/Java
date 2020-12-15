import javax.swing.*;
import java.awt.event.*;

// an instance of Gui2 IS-A ActionListener
// ActionListener is an interface for receiving action events
// class Gui1 is interested in processing action events
// interface ActionListener contains the method actionPerformed(ActionEvent e)
public class Gui2 implements ActionListener {
	JButton button;

	public static void main(String[] args) {
		// object gui will be registered with a component using the component's addActionListener method
		Gui2 gui = new Gui2();
		gui.go();
	}

	public void go() {
		JFrame frame =  new JFrame();
		button = new JButton("click");

		// said component is registered using the component's (JButton's) addActionListener method
		// i.e., add button to list of listeners; must be an object from a class that implements ActionListener
		// public void addActionListener(ActionListener l)
		// when the action event occurs, that object's actionPerformed method is invoked
		button.addActionListener(this);

		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	// when the action event occurs, the object's actionPerformed method is invoked
	// the event handling method; implements the ActionListener interface's actionPerformed() method
	// void actionPerformed(ActionEvent e)
	// ActionEvent: https://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionEvent.html
	public void actionPerformed(ActionEvent event) {
		button.setText("I've been clicked.");
	}

}
