package hacker_rank.project_euler;

import java.util.Scanner;

public class P11_Largest_Product_in_a_Grid {

	private static int matric_num = 20;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] grid = new int[20][20];
		for (int grid_i = 0; grid_i < 20; grid_i++) {
			for (int grid_j = 0; grid_j < 20; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		int a = maxResult(getRowMax(grid), getColumnMax(grid));
		int b = maxResult(getLeftDiagonalMax(grid), getRightDisgonalMax(grid));
		System.out.println(maxResult(a, b));
		in.close();
	}

	private static int maxResult(int a0, int a1) {
		return (a0 > a1) ? a0 : a1;
	}

	/**
	 * from left to right, and then from top to bottom
	 * @param c
	 * @return
	 */
	private static int getRowMax(int[][] c) {
		int max = 0;
		// from left to right
		for (int i = 0; i < matric_num; i++) {
			for (int j = 0; j + 3 < matric_num; j++) {
				if (isZero(c[i][j])) {
					j++;
					continue;
				} else {
					int tmpMax = c[i][j] * c[i][j + 1] * c[i][j + 2] * c[i][j + 3];
					max = (max > tmpMax) ? max : tmpMax;
				}
			}
		}
		return max;
	}

	/**
	 * from top to bottom, and then from left to right
	 * @param c
	 * @return
	 */
	private static int getColumnMax(int[][] c) {
		int max = 0;
		// from top to bottom
		for (int i = 0; i + 3 < matric_num; i++) {
			for (int j = 0; j < matric_num; j++) {// column
				if (isZero(c[i][j])) {
					i++;
					continue;
				} else {
					int tmpMax = c[i][j] * c[i + 1][j] * c[i + 2][j] * c[i + 3][j];
					max = maxResult(max, tmpMax);
				}
			}
		}
		return max;
	}

	/**
	 * from left to right, and then from top to bottom
	 * @param c
	 * @return
	 */
	private static int getLeftDiagonalMax(int[][] c) {
		int max = 0;
		// from left to right
		for (int j = 0; j + 3 < matric_num; j++) {
			int tmp = j;
			for (int i = 0; i + 3 < matric_num &&  j + 3 < matric_num; i++) {
				if (isZero(c[i][j])) {
					i++;
					j++;
					continue;
				} else {
					int tmpMax = c[i][j] * c[i + 1][j + 1] * c[i + 2][j + 2] * c[i + 3][j + 3];
					max = maxResult(max, tmpMax);
				}
			}
			j = tmp;
		}
		// from top to bottom
		for (int i = 0; i + 3 < matric_num; i++) {
			int tmp = i;
			for (int j = 0; j + 3 < matric_num - 1 &&  i + 3 < matric_num; j++) {// column
				if (isZero(c[i][j])) {
					j++;
					i++;
					continue;
				} else {
					int tmpMax = c[i][j] * c[i + 1][j + 1] * c[i + 2][j + 2] * c[i + 3][j + 3];
					max = maxResult(max, tmpMax);
				}
			}
			i = tmp;
		}
		return max;
	}

	/**
	 * from right to left, and then from top to bottom
	 * @param c
	 * @return
	 */
	private static int getRightDisgonalMax(int[][] c) {
		int max = 0;
		// from right to left
		for (int j = matric_num - 1; j - 3 >= 0; j--) {
			int tmp = j;
			for (int i = 0; i + 3 < matric_num &&  j - 3 >= 0; i++) {
				if (isZero(c[i][j])) {
					i++;
					j--;
					continue;
				} else {
					int tmpMax = c[i][j] * c[i + 1][j - 1] * c[i + 2][j - 2] * c[i + 3][j - 3];
					max = maxResult(max, tmpMax);
				}
			}
			j = tmp;
		}
		// from top to bottom
		for (int i = 0; i + 3 < matric_num; i++) {
			int tmp = i;
			for (int j = matric_num - 1; j - 3 >= 0 &&  i + 3 < matric_num; j--) {// column
				if (isZero(c[i][j])) {
					i++;
					j--;
					continue;
				} else {
					int tmpMax = c[i][j] * c[i + 1][j - 1] * c[i + 2][j - 2] * c[i + 3][j - 3];
					max = maxResult(max, tmpMax);
				}
			}
			i = tmp;
		}
		return max;

	}

	private static boolean isZero(int a) {
		return a == 0;
	}
}
