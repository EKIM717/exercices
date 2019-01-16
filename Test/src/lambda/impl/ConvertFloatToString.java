package lambda.impl;

import lambda.Convert;

public class ConvertFloatToString implements Convert<Float, String> {

	@Override
	public String convert(Float f) {
		return String.valueOf(f);
	}

}
