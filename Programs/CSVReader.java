import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	public static void main(String[] args) {
		String path = "uv-sydney-2020.csv";
		String line = "";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime start = LocalDateTime.parse("2020-01-24 11:00:00", format);
		LocalDateTime end = LocalDateTime.parse("2020-01-24 15:00:00", format);
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String skipHeaderLine = br.readLine();
			System.out.println("Date:      Time:    UV:");
			while ((line = br.readLine()) != null) {
				String[] cols = line.split(",");
				LocalDateTime cell = LocalDateTime.parse(cols[0], format);
				dataInDateRange(cell, cols, start, end);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// prints data in date range
	public static void dataInDateRange(LocalDateTime cell, String[] cols, LocalDateTime start, LocalDateTime end) {
                if (cell.isAfter(start) && cell.isBefore(end))
			System.out.println(cols[0] + " " + cols[3]);
	}
}
