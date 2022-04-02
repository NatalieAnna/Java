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
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String skipHeaderLine = br.readLine();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime start = LocalDateTime.parse("2020-01-24 05:00:00", format);
			LocalDateTime end = LocalDateTime.parse("2020-01-24 20:00:00", format);
			while ((line = br.readLine()) != null) {
				String cols[] = line.split(","); // splits data into indexed columns
				LocalDateTime cell = LocalDateTime.parse(cols[0], format);
				if (cell.isAfter(start) && cell.isBefore(end)) {
					System.out.println(cols[0] + " " + cols[3]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
