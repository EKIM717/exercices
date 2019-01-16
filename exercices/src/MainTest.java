import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainTest {

	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			try {
//				System.out.println(i/0);
//				continue;
//			} catch (Exception e) {
//				//执行这个可以是不同步的
//				e.printStackTrace();
//				//system.out.println是同步的
//				System.out.println(e.getMessage());
//			} finally {
//				System.out.println("finally");
//			}
//		}
		String d = "17-12-23";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(d);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			System.out.println(c.get(Calendar.YEAR));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
