
package bat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class MainTest {

	 public static void runbat(String batName) {
	        String cmd = "cmd /c start E:\\" + batName;// pass
	        try {
	            Process ps = Runtime.getRuntime().exec(cmd);
	            ps.waitFor();
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	        catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) throws IOException {
	    	//生成bat随机名字
	    	String findPid = "E:\\" + Calendar.getInstance().getTimeInMillis() + "-" + "tmp.bat";
	    	String killTask = "E:\\" + Calendar.getInstance().getTimeInMillis() + "-" + "tmp.bat";
	    	File fOut = new File(findPid);
	    	OutputStream out = new FileOutputStream(fOut);
	    	String str = "netstat -ona|findstr :9080 > e:\target.txt";
	    	
	    	
	    	
	    	MainTest.runbat("findPID");
	    	InputStream in = new FileInputStream(findPid);
	    	int s = 0;
	    	byte[] bs = new byte[1024];
	    	s = in.read(bs);
	    	String s1 = new String(bs);
	    	System.out.println(s1);
	    	String[] arr = s1.split("LISTENING");
	    	System.out.println(arr[arr.length-1]);
	    	String pid = arr[arr.length-1].trim();
	    	System.out.println();
	        System.out.println("main thread");
	    }
}
