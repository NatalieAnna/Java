// execute on command line ie java MusicAppCL 40 70

import  javax.sound.midi.*;

public class MusicAppCL {

	public void play(int instrument, int note) {
		try {
			// get sequencer and open it
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			// create sequence object
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			// ask sequence for a track
			Track track = seq.createTrack();

			MidiEvent event = null;

			// add midi events to track (WHAT)
			// > message type (144 means "note on")
			// > channel (1 ie musician 1 ie piano player)
			// > note to play (44 ie a number from 0 [low notes] to 127 [high notes])
			// > velocity (100; how fast and hard you press note)
			// MidiEvent noteOn =  when to starting playing a note (WHEN)
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);

			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, note, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, note, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);

			player.setSequence(seq);
			player.start();

		} catch(Exception ex) {
                        ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MusicAppCL app = new MusicAppCL();
		if (args.length < 2) {
			System.out.println("Add instrument and note args.");
		} else {
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			app.play(instrument, note);
		}
	}
}
