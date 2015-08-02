package dynamic_programming;

import java.util.*;

public class LongestIncreasingSubsequence {
	public int longestIncreasingSubsequence(int[] array) {
		if (array == null)
			return 0;

		int len = array.length;

		if (len == 0)
			return 0;

		int[] lenArray = new int[len];
		lenArray[0] = 1;

		for (int i = 1; i < len; i++) {
			for (int j = i - 1; j >= 0; j--) {
				int tempLen = lenArray[j];
				if (array[i] > array[j]) {
					tempLen++;
				}

				if (tempLen > lenArray[i]) {
					lenArray[i] = tempLen;
				}
			}
		}

		int i = 0;
		int pre = 0;
		List<Integer> print = new ArrayList<Integer>();
		while (i < len) {
			if (lenArray[i] > pre) {
				print.add(array[i]);
				pre = lenArray[i];
			}
			i++;
		}

		System.out.println(print);

		return lenArray[len - 1];

	}

	public static void main(String[] args) {
		int[] array = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(new LongestIncreasingSubsequence()
				.longestIncreasingSubsequence(array));
	}
}
