// work in progress

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Script {

	public static void main(String [] args) {

		String [] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
		int numOfNotes;
		String firstNote;
		String velocity;
		int firstIndex = 0;
		int count = 0;
		int remainingNotes = 0;
		Scanner sc = new Scanner(System.in);

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

		while (count < numOfNotes) {
			for (int i = firstIndex; i < 12; i++) {
				System.out.println(notes[i]);
				writeToFile(notes[i]);
				count++;
			}
			for (int i = 0; count < numOfNotes; i++) {
				System.out.println(notes[i]);
				count++;
			}
		}
	}

	public static void writeToFile(String note) {
		try(FileWriter fw = new FileWriter("file.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
			{
			out.println("the text");
			out.println(note);
		} catch (IOException e) {}
	}
}
