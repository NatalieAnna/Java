// Script for SFZ instuments - sforzando
// Author: Natalie Anna Mazurek
// Date: 23/08/22

import java.io.*;
import java.util.*;

public class MidiMaker {

	static String[][] notes = { {"21","A0"}, {"22","A#0"}, {"23","B0"}, {"24","C1"}, {"25","C#1"}, {"26","D1"}, {"27","D#1"}, {"28","E1"}, {"29","F1"}, {"30","F#1"}, {"31","G1"}, {"32","G#1"}, {"33","A1"}, {"34","A#1"}, {"35","B1"}, {"36","C2"}, {"37","C#2"}, {"38","D2"}, {"39","D#2"}, {"40","E2"}, {"41","F2"}, {"42","F#2"}, {"43","G2"}, {"44","G#2"}, {"45","A2"}, {"46","A#2"}, {"47","B2"}, {"48","C3"}, {"49","C#3"}, {"50","D3"}, {"51","D#3"}, {"52","E3"}, {"53","F3"}, {"54","F#3"}, {"55","G3"}, {"56","G#3"}, {"57","A3"}, {"58","A#3"}, {"59","B3"}, {"60","C4"}, {"61","C#4"}, {"62","D4"}, {"63","D#4"}, {"64","E4"}, {"65","F4"}, {"66","F#4"}, {"67","G4"}, {"68","G#4"}, {"69","A4"}, {"70","A#4"}, {"71","B4"}, {"72","C5"}, {"73","C#5"}, {"74","D5"}, {"75","D#5"}, {"76","E5"}, {"77","F5"}, {"78","F#5"}, {"79","G5"}, {"80","G#5"}, {"81","A5"}, {"82","A#5"}, {"83","B5"}, {"84","C6"}, {"85","C#6"}, {"86","D6"}, {"87","D#6"}, {"88","E6"}, {"89","F6"}, {"90","F#6"}, {"91","G6"}, {"92","G#6"}, {"93","A6"}, {"94","A#6"}, {"95","B6"}, {"96","C7"}, {"97","C#7"}, {"98","D7"}, {"99","D#7"}, {"100","E7"}, {"101","F7"}, {"102","F#7"}, {"103","G7"}, {"104","G#7"}, {"105","A7"}, {"106","A#7"}, {"107","B7"}, {"108","C8"}, {"109","C#8"}, {"110","D8"}, {"111","D#8"}, {"112","E8"}, {"113","F8"}, {"114","F#8"}, {"115","G8"}, {"116","G#8"}, {"117","A8"}, {"118","A#8"}, {"119","B8"}, {"120","C9"}, {"121","C#9"}, {"122","D9"}, {"123","D#9"}, {"124","E9"}, {"125","F9"}, {"126","F#9"}, {"127","G9"}, {"128","G#9"} };

	public static void writeGlobalSettings() {
		String data = "// global settings\n"+"\n"+"<global>\n"+"<control>\n"+"label_cc7=Master Vol\n"+"label_cc10=Master Pan\n"+"label_cc99=Single Cycle\n"+"label_cc100=Attack\n"+"label_cc101=Hold\n"+"label_cc102=Decay\n"+"label_cc103=Sustain\n"+"label_cc104=Release\n"+"set_cc7=100\n"+"set_cc10=64\n"+"set_cc99=0\n"+"set_cc100=0\n"+"set_cc101=0\n"+"set_cc102=0\n"+"set_cc103=127\n"+"set_cc104=10\n"+"set_cc105=0\n"+"\n"+"<global>\n"+"amplitude_oncc7=100\n"+"pan=-100\n"+"pan_oncc10=200\n"+"ampeg_attack=0.001\n"+"ampeg_sustain=0\n"+"ampeg_release=0.001\n"+"ampeg_attack_oncc100=0.5\n"+"ampeg_hold_oncc101=2\n"+"ampeg_decay_oncc102=10\n"+"ampeg_sustain_oncc103=100\n"+"ampeg_release_oncc104=5\n"+"\n"+"// end of global settings\n"+"\n";
		try {
			FileWriter output = new FileWriter("output.txt");
			output.write(data);
			output.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void writeGroupSettings() {
		String firstNote;
		int numOfNotes;
		int firstIndex = 0;
		int count = 0;
		int key = 0;
		int octave = 0;
		String filepathLoud = "empty";
		String filepathSoft = "empty";
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter first note: ");
		firstNote = sc.nextLine();
		for (int i = 0; i < notes.length; i++) {
			if (notes[i].equals(firstNote)) {
				firstIndex = i;
				break;
			}
		}

		System.out.print("Enter first octave: ");
		octave = sc.nextInt();

		System.out.print("Enter number of notes: ");
		numOfNotes = sc.nextInt();

		System.out.print("Enter starting key: ");
		key = sc.nextInt();

//		for (int i = firstIndex; i < 11; i++) {

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {

			if (notes[i][j].contains("#")) {
				filepathLoud = "loud\\" + notes[i][j] + octave + ".wav";
				filepathSoft = "soft\\" + notes[i][j] + octave + ".wav";
				writeToFile(count, key, notes[i][j], filepathLoud, filepathSoft);
				count++;
				if (count == numOfNotes) { break; }
				if (i == 11) { break; }
			} else {
				filepathLoud = "loud\\" + notes[i][j] + octave + ".wav";
				filepathSoft = "soft\\" + notes[i][j] + octave + ".wav";
				writeToFile(count, key, notes[i][j], filepathLoud, filepathSoft);
				count++;
				if (count == numOfNotes) { break; }
				if (i == 11) { break; }
			}
			key++;
		}}
	}

	// TBC add try-catch
	public static void writeToFile(int count, int key, String note, String filepathLoud, String filepathSoft) {

		// Group specs
		String data =
			"// Group: " + count + " 50-70\n"+
			"\n"+
			"\t// Velocity Layer 1\n"+
			"\t<group>\n"+
			"\tpan=0\n"+
			"\ttranspose=0\n"+
			"\thikey="+key+"\n"+
			"\tlokey="+key+"\n"+
			"\tpitch_keycenter="+key+"\n"+
			"\tseq_length=1\n"+
			"\tlovel=63\n"+
			"\thivel=127\n"+
			"\n"+
			"\t// user opcodes\n"+
			"\n"+
				"\t\t<region>\n"+
				"\t\tsample="+filepathLoud+"\n"+
				"\t\tseq_position=1\n"+
				"\n"+
			"\t// Velocity Layer 2\n"+
			"\t<group>\n"+
			"\tvolume=0\n"+
			"\tpan=0\n"+
			"\ttranspose=0\n"+
			"\thikey="+key+"\n"+
			"\tlokey="+key+"\n"+
			"\tpitch_keycenter="+key+"\n"+
			"\tseq_length=1\n"+
			"\tlovel=0\n"+
			"\thivel=62\n"+
			"\n"+
			"\t// user opcodes\n"+
			"\n"+
				"\t\t<region>\n"+
				"\t\tsample="+filepathSoft+"\n"+
				"\t\tseq_position=1\n"+
				"\n";

		try (FileWriter fw = new FileWriter("output.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw)) {
			out.println(data);
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public static void main(String [] args) {
		writeGlobalSettings();
		writeGroupSettings();
	}
}
