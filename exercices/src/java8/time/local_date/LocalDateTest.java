package java8.time.local_date;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTest {

	public static void main(String[] args) throws ParseException {
		
		  String s="10 de enero de 2018";
		  java8(s);
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
	
	
}
