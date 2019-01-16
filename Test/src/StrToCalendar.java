import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StrToCalendar {

	public static void main(String[] args) throws ParseException {
		String s = "20170601";
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		c.setTime(sdf.parse(s));
	}
}
