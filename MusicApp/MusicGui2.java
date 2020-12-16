import  javax.sound.midi.*;

public class MusicGui2 implements ControllerEventListener {

	public static void main(String[] args) {
		MusicGui2 app = new MusicGui2();
		app.go();
	}

	// makes a message and returns a MidiEvent
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
		try {
			// make sequencer and open it
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			// register for events with the sequencer, which takes the listener and the int array representing the list of ControllerEvents you want i.e., one event #127
			int[] eventsIWant = {127};
			player.addControllerEventListener(this, eventsIWant);

			// create sequence object and ask sequence for a track
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			// make some musical events; from piano note 5 to 61
			for (int i = 5; i < 61; i+= 4) {
				track.add(makeEvent(144, 1, i, 100, i)); // note on
				// this is here just so that we can get an event each time a note is played because we can't listen to note on/off events
				// occurs at the same time as note on/off events
				// 176 means the event type is ControllerEvent
				// event #127 does nothing
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, i, 100, i + 2)); // note off
			}

			// start it
			player.setSequence(seq);
			player.setTempoInBPM(220);
			player.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// the event handler method from the ControllerEvent listener interface
	// each time we get the event we'll print "la"
	public void controlChange(ShortMessage event) {
		System.out.println("la");
	}
}
