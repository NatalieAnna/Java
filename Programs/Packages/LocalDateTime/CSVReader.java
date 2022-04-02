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
		LocalDateTime start = LocalDateTime.parse("2020-01-24 05:00:00", format);
		LocalDateTime end = LocalDateTime.parse("2020-01-24 20:00:00", format);
		double maxUV = Double.MIN_VALUE;
		String maxUVDate = "";
		String[] splitDateTime = {};
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String skipHeaderLine = br.readLine();
			System.out.println("Date:      Time: " + "   " + "UV:");
			while ((line = br.readLine()) != null) {
				String cols[] = line.split(","); // all LDT are Strings
				LocalDateTime cell = LocalDateTime.parse(cols[0], format);
				if (cell.isAfter(start) && cell.isBefore(end)) {
					// prints date and uv in range
					System.out.println(cols[0] + " " + cols[3]);

					// print max UV details
					double currentUV = Double.parseDouble(cols[3]);
					if (currentUV  > maxUV) {
						maxUV = currentUV;
						maxUVDate = cols[0];
						splitDateTime = maxUVDate.split("\\s+"); // space delimiter
					}
				}
			}
			System.out.println("Max UV: " + maxUV + " on " + splitDateTime[0] + " at " + splitDateTime[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
