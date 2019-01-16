package lambda.impl;

import lambda.Convert;

public class ConvertStringToFloat implements Convert<String, Float> {

	@Override
	public Float convert(String s) {
		return Float.valueOf(s);
	}
	
	public static void main(String[] args) {
		Convert<String, Float> c1 = new ConvertStringToFloat();
		Float f = c1.convert("2");
		Convert<Float, String> c2 = new ConvertFloatToString();
		String s = c2.convert(0.2f);
		System.out.println(f + "-" + s);
	}
	
}
