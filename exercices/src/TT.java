
public class TT {

	static int l = 4000;
	static int p = 7000;
	static int f = 6000;
	static int s = 7000;

	public static void main(String[] args) {
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j<1000; j++) {
				foo(j, 5, i);
			}
		}
	}

	private static boolean foo(int order, float profit, int count) {
		int totalOrderCount = order * count;
		int lCount = (int) Math.ceil(totalOrderCount / 200d);
		int lCost = l * lCount;
		int pCount = (int) Math.ceil(totalOrderCount / 500d);
		int pCost = p * pCount;
		int fCount = (int) Math.ceil(totalOrderCount / 2000d);
		int fCost = f * fCount;
		int sum = (int) (lCost + pCost + fCost + s * count);
		if (order * 30 * count * profit >= sum) {
			System.out.println("����:" + order + " ����:" + count);
			System.out.println("��������*�ɱ�=" + l + "*"  + lCount + "=" + (l * lCount));
			System.out.println("�ɹ�����*�ɱ�=" + p + "*"  + pCount + "=" + (p * pCount));
			System.out.println("���񵥼�*�ɱ�=" + f + "*"  + fCount + "=" + (f * fCount));
			return true;
		}
		return false;
	}
}
