import  javax.sound.midi.*;

public class MusicGui1 {

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

	public static void main(String[] args) {
		try {
			// make sequencer and open it
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			// create sequence object and ask sequence for a track
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			// make some musical events; from piano note 5 to 61
			for (int i = 5; i < 61; i+= 4) {
				track.add(makeEvent(144, 1, i, 100, i)); // note on
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
}
