import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MusicGui3 {
	static JFrame f = new JFrame("Music video");
	static MyDrawPanel drawPanel;

	public static void main(String[] args) {
		MusicGui3 app = new MusicGui3();
		app.go();
	}

	// set up GUI
	public void setUpGui() {
		drawPanel = new MyDrawPanel();
		f.setContentPane(drawPanel);
		f.setBounds(30, 30, 300, 300);
		f.setVisible(true);
	}

	public static MidiEvent makeEvent(int type, int channel, int note, int velocity, int when) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(type, channel, note, velocity);
			event = new MidiEvent(a, when);
		} catch(Exception e) {}
		return event;
	}

	public void go() {
		// create GUI
		setUpGui();

		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			player.addControllerEventListener(drawPanel, new int[] {127});
			// MusicApp2 version:
			// int[] eventsIWant = {127};
			// player.addControllerEventListener(this, eventsIWant);

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			// add r
			int r = 0;
			for (int i = 0; i < 61; i+= 4) {
				r = (int) ((Math.random() * 50) + 1);
				track.add(makeEvent(144, 1, r, 100, i)); // note on
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, r, 100, i + 2)); // note off
			}

			player.setSequence(seq);
			player.setTempoInBPM(220);
			player.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// inner class (but also worked as outer class)
	class MyDrawPanel extends JPanel implements ControllerEventListener {
		// set to true only when we get event
		boolean msg = false;

		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();
		}

		public void paintComponent(Graphics g) {
			if (msg) {
				Graphics2D g2 = (Graphics2D) g;
				int r = (int) (Math.random() * 250);
				int gr = (int) (Math.random() * 250);
				int b = (int) (Math.random() * 250);

				g.setColor(new Color(r, gr, b));

				int ht = (int) ((Math.random() * 120) + 10);
				int width = (int) ((Math.random() * 120) + 10);
				int x = (int) ((Math.random() * 40) + 10);
				int y = (int) ((Math.random() * 40) + 10);
				g.fillRect(x, y, ht, width);
				msg = false;
			}
		}
	}
}
