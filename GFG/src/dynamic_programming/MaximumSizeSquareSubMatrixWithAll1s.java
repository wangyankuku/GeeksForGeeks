package dynamic_programming;

import java.util.Arrays;

public class MaximumSizeSquareSubMatrixWithAll1s {
    public int getMaximumSizeSquareSubMatrixWithAll1s(int[][] matrix) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	    return 0;
	}

	int leni = matrix.length;
	int lenj = matrix[0].length;

	int[] left = new int[lenj];
	int[] right = new int[lenj];
	int[] height = new int[lenj];

	Arrays.fill(left, -1);
	Arrays.fill(right, lenj);

	int max = 0;

	for (int i = 0; i < leni; i++) {
	    // go through to save left
	    int leftmost = -1;
	    int j = 0;

	    while (j < lenj) {
		while (j < lenj && matrix[i][j] == 0) {
		    left[j] = -1;
		    j++;
		}
		leftmost = j;
		while (j < lenj && matrix[i][j] == 1) {
		    left[j] = Math.max(left[j], leftmost);
		    j++;
		}
	    }

	    // got through to save right and height
	    int rightmost = lenj;
	    j = lenj - 1;
	    while (j >= 0) {
		while (j >= 0 && matrix[i][j] == 0) {
		    right[j] = lenj;
		    height[j] = 0;
		    j--;
		}
		rightmost = j;
		while (j >= 0 && matrix[i][j] == 1) {
		    right[j] = Math.min(right[j], rightmost);
		    height[j]++;

		    // calculate the square
		    int side = Math.min(right[j] - left[j] + 1, height[j]);
		    max = Math.max(max, side * side);

		    j--;
		}
	    }
	}

	return max;
    }

    public static void main(String[] args) {
	int[][] matrix = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 },
		{ 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
		{ 0, 0, 0, 0, 0 } };

	System.out.println(new MaximumSizeSquareSubMatrixWithAll1s()
		.getMaximumSizeSquareSubMatrixWithAll1s(matrix));
    }
}
