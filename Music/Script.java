import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Script {

	static String velocity = "velocity";

	public static void main(String [] args) {
		String [] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
		String firstNote;
		int numOfNotes;
		int firstIndex = 0;
		int count = 0;
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

		for (int i = firstIndex; i < 12; i++) {
			filepath = "/" + velocity + "/" + notes[i] + ".txt";
			writeToFile(velocity, notes[i], filepath);
			count++;
                        System.out.println("count=" + count + " numOfNotes=" + numOfNotes + " i=" + i);
			if (count == numOfNotes) { break; }
			if (i == 11) { break; }
		}

		for (int i = 0; i < 24; i++) {
			filepath = "/" + velocity + "/" + notes[i] + ".txt";
			writeToFile(velocity, notes[i], filepath);
			count++;
                        System.out.println("count=" + count + " numOfNotes=" + numOfNotes + " i=" + i);
			if (count == numOfNotes) { break; }
			if (i == 23) { break; }
		}
	}

	public static void writeToFile(String velocity, String note, String file) {
		try(FileWriter fw = new FileWriter("file.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw)) {
				out.println(velocity + " " + note + " with filepath " + file);
		} catch (IOException e) {}
	}
}
