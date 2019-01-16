package rotation;

public class Rotation {
	
	private static int ROTATION = 36;
	
	public static void main(String[] args) {
		for (int i = 10; i <ROTATION;i++) {
			char c = Character.forDigit(i, Character.MAX_RADIX);
			System.out.println("i:" + i + " c:" + c);
		}
//		System.out.println(rotationDecimalTo36(37L*('a'-48) + 1));
	}

	/**
	 * 10进制转37进制
	 * @param source 原来的10进制数
	 * @return 返回的37进制数
	 */
	private static String rotationDecimalTo36(long source) {
		//商
		long quotient  = 0L;
		//余数
		int remain = (int) (source % ROTATION);
		StringBuffer ret = new StringBuffer();
		do {
			quotient = source / ROTATION;
			//如果quato 在0到36范围
			if (0 <= quotient && quotient <= 35) {
				//返回0~z的char
				char c = Character.forDigit((int) quotient, Character.MAX_RADIX);
				ret.append(c);
			} else {
				ret.append('1');
			}
			//把商赋值给被除数
			source = quotient;
		} while (quotient > ROTATION);
		//先倒转
		ret = ret.reverse();
		//余数放最后
		char lastChar = Character.forDigit(remain, Character.MAX_RADIX);
		ret.append(lastChar);
		//前面补0
		for (int i = (7 - ret.length()); i > 0; i--)
			ret.insert(0, '0');
		//转大写
		return ret.toString().toUpperCase();
	}
}
