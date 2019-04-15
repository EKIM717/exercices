package java8.time.local_date;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTest {

	public static void main(String[] args) throws ParseException {
		getLengthOfMonth();
		  String s="10 de enero de 2018";
		  java8(s);
//		  to_method();
	}
	
	public static void getLengthOfMonth() {
		LocalDate ld = LocalDate.now();
		System.out.println(ld.withYear(2019).withMonth(2).lengthOfMonth());
	}
	
	public static void java8( String s) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd \'de\' MMMM \'de\' yyyy", new Locale("es"));
		System.out.println(LocalDate.parse(s, dtf));
		
	}
	
	public static void java8Pre( String s) throws ParseException {
		Locale l = new Locale("es");
		DateFormat dtf = DateFormat.getDateInstance(DateFormat.LONG, l);
		 System.out.println(dtf.parse(s));
	}
	
	public static void to_method() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("localDateTime转localDate  " + ldt.toLocalDate());
		
		
		LocalDate ld = LocalDate.now();
		System.out.println("localDate转EpochDay (long类型)" + ld.toEpochDay());
	}
	
	public static void of_method() {
		LocalDate ld = LocalDate.of(2019, 2, 28);
		System.out.println(ld);
	}
	
	
}
