package swap;

public class Swap {

	public static void main(String[] args) {
		int[] a = new int[]{1, 2};
		swap(a, 0, 1);
		System.out.println(a);
	}
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void doubleBubble(int[] array) {
        int arrayLength = array.length;

        int preIndex = 0;
        int backIndex = arrayLength - 1;
        while(preIndex < backIndex) {
            preSort(array, arrayLength, preIndex);
            preIndex++;

            if (preIndex >= backIndex)
                break;

            backSort(array, backIndex);
            backIndex--;
        }
    }
	
	 // 从前向后排序
    private static void preSort(int[] array, int length, int preIndex) {
        for (int i = preIndex + 1; i < length; i++) {
            if (array[preIndex] > array[i])
                swap(array, preIndex, i);
        }
    }
    
    // 从后向前排序
    private static void backSort(int[] array, int backIndex) {
        for (int i = backIndex - 1; i >= 0; i--) {
            if (array[i] > array[backIndex]) {
                swap(array, i, backIndex);
            }
        }
    }
}
