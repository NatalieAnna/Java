import java.time.Period;
import java.time.LocalDate;

public class AgeCalc {
	public static void main(String [] args) {
		
		LocalDate today = LocalDate.now();
		LocalDate birthDate = LocalDate.of(1989,1,24);
		int years = Period.between(birthDate, today).getYears();
		System.out.println(years);
	}
}
