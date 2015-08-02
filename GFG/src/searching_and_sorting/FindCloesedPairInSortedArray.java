package searching_and_sorting;

import java.util.Arrays;

//Given a sorted array and a number x, find the pair in array whose sum is closest to x
public class FindCloesedPairInSortedArray {
	public int[] findCloesedPairInSortedArray(int[] array, int target) {

		int[] res = { -1, -1 };

		if (array == null) {
			return res;
		}

		int len = array.length;

		int i = 0;
		int j = len - 1;
		int min = Integer.MAX_VALUE;

		while (i < j) {
			int sum = array[i] + array[j];
			int diff = Math.abs(sum - target);

			if (diff < min) {
				min = diff;
				res[0] = array[i];
				res[1] = array[j];
			}

			if (sum == 0) {
				break;
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] array1 = { 10, 22, 28, 29, 30, 40 };
		int target = 54;

		System.out.println(Arrays.toString(new FindCloesedPairInSortedArray()
				.findCloesedPairInSortedArray(array1, target)));

		int[] array2 = { 1, 3, 4, 7, 10 };
		target = 15;

		System.out.println(Arrays.toString(new FindCloesedPairInSortedArray()
				.findCloesedPairInSortedArray(array2, target)));
	}
}
