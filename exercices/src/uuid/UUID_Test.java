package uuid;

import java.util.UUID;

public class UUID_Test {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			System.out.println(UUID.randomUUID().toString().toUpperCase());//.replace("-", "").toLowerCase();
		
	}
}
