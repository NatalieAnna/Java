// Global settings documented for posterity: "// global settings\n"+"<global>\n"+"<control>\n"+"label_cc7=Master Vol\n"+"label_cc10=Master Pan\n"+"label_cc99=Single Cycle\n"+"label_cc100=Attack\n"+"label_cc101=Hold\n"+"label_cc102=Decay\n"+"label_cc103=Sustain\n"+"label_cc104=Release\n"+"set_cc7=100\n"+"set_cc10=64\n"+"set_cc99=0\n"+"set_cc100=0\n"+"set_cc101=0\n"+"set_cc102=0\n"+"set_cc103=127\n"+"set_cc104=10\n"+"set_cc105=0\n"+"\n"+"<global>\n"+"amplitude_oncc7=100\n"+"pan=-100\n"+"pan_oncc10=200\n"+"ampeg_attack=0.001\n"+"ampeg_sustain=0\n"+"ampeg_release=0.001\n"+"ampeg_attack_oncc100=0.5\n"+"ampeg_hold_oncc101=2\n"+"ampeg_decay_oncc102=10\n"+"ampeg_sustain_oncc103=100\n"+"ampeg_release_oncc104=5\n"+"\n"+"// end of global settings\n"
// SFZ instuments - sforzando - midiMaker
// TBC rename output.txt to MelodicaStretched.sfz, actually get UI input for filename

import java.io.*;
import java.util.*;

public class Script {

	static String velocity = "velocity";

	public static void writeGlobalSettings() {
		String data = "// global settings\n"+"<global>\n"+"<control>\n"+"label_cc7=Master Vol\n"+"label_cc10=Master Pan\n"+"label_cc99=Single Cycle\n"+"label_cc100=Attack\n"+"label_cc101=Hold\n"+"label_cc102=Decay\n"+"label_cc103=Sustain\n"+"label_cc104=Release\n"+"set_cc7=100\n"+"set_cc10=64\n"+"set_cc99=0\n"+"set_cc100=0\n"+"set_cc101=0\n"+"set_cc102=0\n"+"set_cc103=127\n"+"set_cc104=10\n"+"set_cc105=0\n"+"\n"+"<global>\n"+"amplitude_oncc7=100\n"+"pan=-100\n"+"pan_oncc10=200\n"+"ampeg_attack=0.001\n"+"ampeg_sustain=0\n"+"ampeg_release=0.001\n"+"ampeg_attack_oncc100=0.5\n"+"ampeg_hold_oncc101=2\n"+"ampeg_decay_oncc102=10\n"+"ampeg_sustain_oncc103=100\n"+"ampeg_release_oncc104=5\n"+"\n"+"// end of global settings\n"+"\n";
		try {
			FileWriter output = new FileWriter("output.txt");
			output.write(data);
			output.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void getGroupSettings() {
		String [] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
		String firstNote;
		int numOfNotes;
		int firstIndex = 0;
		int count = 0;
		int key = 0; // TBC
		String filepath = "empty";
		Scanner sc = new Scanner(System.in);

		System.out.print("Velocity (loud/soft): ");
		velocity = sc.nextLine();

		System.out.print("Enter first note: ");
		firstNote = sc.nextLine();
		for (int i = 0; i < notes.length; i++) {
			if (notes[i].equals(firstNote)) {
				firstIndex = i;
				break;
			}
		}

		System.out.print("Enter number of notes: ");
		numOfNotes = sc.nextInt();

		System.out.print("Enter starting key: ");
		key = sc.nextInt();

		for (int i = firstIndex; i < 12; i++) {
			filepath = "/" + velocity + "/" + notes[i] + ".txt";
			writeToFile(velocity, notes[i], filepath);
			count++;
			if (count == numOfNotes) { break; }
			if (i == 11) { break; }
		}

		for (int i = 0; i < 24; i++) {
			filepath = "/" + velocity + "/" + notes[i] + ".txt";
			writeToFile(velocity, notes[i], filepath);
			count++;
			if (count == numOfNotes) { break; }
			if (i == 23) { break; }
		}
	}

    public static void writeToFile(String velocity, String note, String filepath) {
        try(FileWriter fw = new FileWriter("output.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw)) {
			out.println(velocity + " " + note + " with filepath " + filepath);
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public static void main(String [] args) {
		writeGlobalSettings();
		getGroupSettings();
	}
}

