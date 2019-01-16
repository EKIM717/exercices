package interface2;

import interface1.IF1;
import interface1.Impl;

public class TestIF1 {

	public static void main(String[] args) {
		IF1 if1 = new Impl();
		if1.test();
	}
}
