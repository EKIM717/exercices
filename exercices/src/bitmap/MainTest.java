package bitmap;

public class MainTest {

	public static void main(String[] args) {
		int[] source = new int[]{1, 2, 4, 6, 1, 1, 3};//{1, 2, 4, 6, 0, 0, -2};
		int[] output = new int[source.length];
		int max = 0, min = 0;
		
		//find the maximum and minimum values
		for (int s = 0; s < source.length; s++) {
			if (max < source[s])
				max = source[s];
			if (min > source[s])
				min = source[s];
		}
		
		int[] arr = new int[max - min + 1];
		int index = 0;
		if (min <= 0) {//存在小于等于0的情况
			for (int j = 0; j < source.length; j++)//set the bit map
				arr[source[j] - min]++;
			for (int j = 0; j < arr.length; j++)
				for (int n = 0; arr[j] > 0 && n < arr[j]; n++)
					output[index++] = j + min;
		} else {//正整数
			for (int m = 0; m < source.length; m++)//set the bit map
				arr[source[m]]++;
			for (int j = 0; j < arr.length; j++)
				for (int n = 0; arr[j] > 0 && n < arr[j]; n++)
					output[index++] = j;
		}
		//还可以选择升序降序输出
		for (int in : output)
			System.out.println(in);
	}
}
