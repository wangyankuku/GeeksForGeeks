package searching_and_sorting;

import java.util.*;

public class Find_common_elements_in_three_sorted_arrays {
	public List<Integer> findThreeCommonEle(int[] arr1, int[] arr2, int[] arr3) {

		List<Integer> res = new ArrayList<Integer>();

		if (arr1 == null || arr2 == null || arr3 == null) {
			return res;
		}

		int len1 = arr1.length;
		int len2 = arr2.length;
		int len3 = arr3.length;
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < len1) {
			int curNum = arr1[i];

			while (j < len2 && arr2[j] < curNum) {
				j++;
			}
			if (j == len2) {
				break;
			}
			
			if (arr2[j] == curNum) {
				while (k < len3 && arr3[k] < curNum) {
					k++;
				}
				if (k == len3) {
					break;
				}
				
				if (arr3[k] == curNum) {
					res.add(curNum);
					j++;
					k++;
				}
			}

			i++;

		}

		return res;

	}

	public static void main(String[] args) {
		int[] arr1 = { 1,3};
		int[] arr2 = { 1, 2,5,5,9,19 };
		int[] arr3 = { 5,5,13,155 };

		List<Integer> res = new Find_common_elements_in_three_sorted_arrays()
				.findThreeCommonEle(arr1, arr2, arr3);

		System.out.println(res);
	}
}
