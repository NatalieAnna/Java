import  javax.sound.midi.*;

public class MusicApp {

	public void play() {
		try {
			// get sequencer and open it
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			System.out.println("Sequencer has been opened.");
			// create sequence object
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			// ask sequence for a track
			Track track = seq.createTrack();

			// add midi events to track
			// Message object holds midi instruction
			// WHAT
			// ie "start playing Middle C"
			ShortMessage a = new ShortMessage();
			// message type (144 means "note on")
			// channel (1 ie musician 1 ie piano player)
			// note to play (44 ie a number from 0 [low notes] to 127 [high notes])
			// velocity (100; how fast and hard you press note)
			a.setMessage(144, 1, 44, 100);
			// MidiEvent noteOn =  when to starting playing a note
			// WHEN
			// ie "Trigger this message at beat 1"
			MidiEvent noteOn = new MidiEvent(a, 1);
			// add the MidiEvent to the track
			track.add(noteOn);

			// ?
			ShortMessage b = new ShortMessage();
			// message type (128 means "note off")
			b.setMessage(128, 1, 44, 100);
			// noteOff = when to stop playing a note
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);

			ShortMessage c = new ShortMessage();
			c.setMessage(144, 1, 45, 100);
			MidiEvent noteOn2 = new MidiEvent(c, 4);
			track.add(noteOn2);

			ShortMessage d = new ShortMessage();
			d.setMessage(144, 1, 40, 100);
			MidiEvent noteOn3 = new MidiEvent(d, 8);
			track.add(noteOn3);

			// give the sequence to the sequencer
			player.setSequence(seq);
                        // start the sequencer
			player.start();
		} catch(Exception ex) {
                        ex.printStackTrace();
		}

	}

	public static void main(String[] args) {
		MusicApp app = new MusicApp();
		app.play();
	}
}
