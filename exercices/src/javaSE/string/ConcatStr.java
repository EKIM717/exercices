package javaSE.string;

public class ConcatStr {

	
	public static  void main(String[] args) {
		String s = "SKU	ƽ̨	վ��	��˾	�����ֿ�	��������	��������	ƽ̨����	���������	�˻�����	VAT��	������	�����	�ɹ���	�����˷�	�ʷ�	˰��	���1	���2	����ۼ�	����";
				String[] str = s.split("\t");
		System.out.println("\"");
		for (String ss : str) {
			System.out.print(ss);
			System.out.print(",");
		}
		System.out.println("\"");
	}
}
