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
	 * 10����ת37����
	 * @param source ԭ����10������
	 * @return ���ص�37������
	 */
	private static String rotationDecimalTo36(long source) {
		//��
		long quotient  = 0L;
		//����
		int remain = (int) (source % ROTATION);
		StringBuffer ret = new StringBuffer();
		do {
			quotient = source / ROTATION;
			//���quato ��0��36��Χ
			if (0 <= quotient && quotient <= 35) {
				//����0~z��char
				char c = Character.forDigit((int) quotient, Character.MAX_RADIX);
				ret.append(c);
			} else {
				ret.append('1');
			}
			//���̸�ֵ��������
			source = quotient;
		} while (quotient > ROTATION);
		//�ȵ�ת
		ret = ret.reverse();
		//���������
		char lastChar = Character.forDigit(remain, Character.MAX_RADIX);
		ret.append(lastChar);
		//ǰ�油0
		for (int i = (7 - ret.length()); i > 0; i--)
			ret.insert(0, '0');
		//ת��д
		return ret.toString().toUpperCase();
	}
}
