import  javax.sound.midi.*;

public class MusicTest {

	public void play() {
		try {
			Sequencer s = MidiSystem.getSequencer();
			System.out.println("We got a sequencer");
		} catch(MidiUnavailableException ex) {
			System.out.print("Failed");
		} finally {
			System.out.println("'Finally'");
		}

	}

	public static void main(String[] args) {
		MusicTest mt = new MusicTest();
		mt.play();
	}
}
