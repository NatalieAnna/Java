import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BeatBox {

	JFrame theFrame;
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;
	Sequencer player;
	Sequence sequence;
	Track track;

	// create instrument GUI labels
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Congo", "Cowbell", "Vibraslap", "Lowmid Tom", "High Agogo", "Open Hi Conga"};
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63}; // i.e., 35 is bass drum

	// main method
	public static void main(String[] args) {
		new BeatBox().buildGUI();
	}

	// buildGUI()
	public void buildGUI() {
		// create JFrame with title
		theFrame = new JFrame("Beatbox");
		// quits program when window is closed
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// BorderLayout has 5 regions (east, west, north, south, center)
		BorderLayout layout = new BorderLayout();
		// create another JPanel with the BorderLayout
		JPanel background = new JPanel(layout);
		// set empty border to get margin between edge of panel and components; aesthetic
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		// create ArrayList object
		checkboxList = new ArrayList<JCheckBox>();
		// create box that keeps button components stacked vertically (Y_AXIS)
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		// create buttons and event listeners, and add to buttonBox
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);

		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);

		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);

		// create box that keeps instrumentNames stacked vertically (Y_AXIS)
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < 16; i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}

		// place both boxes on JPanel
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);

		// add JPanel to JFrame
		// JFrame doesn't let you add to it directly so you must add to its content pane
		theFrame.getContentPane().add(background);

		// a GridLayout object places components in a grid of cells. Each component takes all the available space within its cell, and each cell is exactly the same size
		GridLayout grid = new GridLayout(16,16);
		grid.setVgap(1);
		grid.setHgap(2);
		// mainPanel gets another JPanel on top/centre of itself that has GridLayout
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);

		// make the checkboxes, set them to false/unchecked and add them to the ArrayList and to the GUI panel
		for ( int i = 0; i < 256; i++ ) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}

		// set up midi
		setUpMidi();

		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
	}

	// the usual midi set-up for getting sequencer/sequence/track
	public void setUpMidi() {
		try {
			player = MidiSystem.getSequencer();
			player.open();
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			player.setTempoInBPM(120);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buildTrackAndStart() {
		// array that will hold 16 elements/beats. If has value then play, else value is zero
		int[] trackList = null;

		// delete old tracks, make a fresh one
		sequence.deleteTrack(track);
		track = sequence.createTrack();

		// loop for each of the 16 rows i.e., Bass, Congo, etc
		for (int i = 0; i < 16; i++) {
			trackList = new int[16];
			// set the key/instrument
			int key = instruments[i];
			// loop for each beat per row
			for (int j = 0; j < 16; j++) {
				JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));
				if (jc.isSelected()) {
					trackList[j] = key;
				} else {
					trackList[j] = 0;
				}
			}
			// for this instrument, and for all 16 beats, make events and add them to the track
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
		}
		// we make sure that there is an event at beat 16 otherwise the beatbox might not go the full 16 beats before it starts over
		track.add(makeEvent(192,9,1,0,15));
		try {
			player.setSequence(sequence);
			player.setLoopCount(player.LOOP_CONTINUOUSLY);
			player.start();
			player.setTempoInBPM(120);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public class MyStartListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			buildTrackAndStart();
		}
	}

	public class MyStopListener implements ActionListener {
		public void actionPerformed(ActionEvent b) {
			player.stop();
		}
	}

	public class MyUpTempoListener implements ActionListener {
		public void actionPerformed(ActionEvent c) {
			float tempoFactor = player.getTempoFactor();
			player.setTempoFactor((float)(tempoFactor * 1.03));
		}
	}

	public class MyDownTempoListener implements ActionListener {
		public void actionPerformed(ActionEvent d) {
			float tempoFactor = player.getTempoFactor();
			player.setTempoFactor((float)(tempoFactor * 0.97));
		}
	}

	// makes events for one instrument at a time for all 16 beats, elements gets key or zero
	public void makeTracks(int[] list) {
		for (int i = 0; i < 16; i++) {
			int key = list[i];

			// make and add note on/off events to track
			if (key != 0) {
				track.add(makeEvent(144,9,key,100,i)); // note on
				track.add(makeEvent(128,9,key,100,i+1)); // note off
			}
		}
	}

	// utility method
	public MidiEvent makeEvent(int type, int channel, int note, int velocity, int when) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(type, channel, note, velocity);
			event = new MidiEvent(a, when);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}
}
