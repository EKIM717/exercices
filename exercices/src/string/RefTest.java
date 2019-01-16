package string;

public class RefTest {

	public static void deal(String postcode, String postcode1, String postcode2) {
		
			postcode1 = postcode.substring(0, 2);
			postcode2 = postcode.substring(0, 5);
	}
	
	public static void main(String[] args) {
		String postcode = "14514asfgasfgaafa-54324524";
		String postcode1 = "";
		String postcode2 = "";
		deal(postcode, postcode1, postcode2);
		System.out.println(postcode);
		System.out.println(postcode1);
		System.out.println(postcode2);
	}
}
