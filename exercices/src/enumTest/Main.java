package enumTest;


public class Main {

	public static void main(String[] args) {
//		System.out.println(Country.GB.name());
//		System.out.println("GB == Country.GB.name() " + ("GB" == Country.GB.name()));
		T t = new T();
		t.setA(Coin.DIME);
		Coin c = t.getA();
		
		t.setA(Coin.NICKEL);
		
		System.out.println(c.name());
		System.out.println(t.getA().name());
	}
}


class T {
	private Coin a;

	public Coin getA() {
		return a;
	}

	public void setA(Coin a) {
		this.a = a;
	}
	
	
}