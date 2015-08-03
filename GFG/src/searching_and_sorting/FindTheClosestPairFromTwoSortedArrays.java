package searching_and_sorting;

import java.util.Arrays;

public class FindTheClosestPairFromTwoSortedArrays {

    public int[] findPair(int[] arr1, int[] arr2, int num) {

	int[] res = { -1, -1 };

	if (arr1 == null || arr2 == null)
	    return res;

	int len1 = arr1.length;
	int len2 = arr2.length;

	int i = 0;
	int j = len2 - 1;

	int min = Integer.MAX_VALUE;

	while (i < len1 && j >= 0) {
	    int sum = arr1[i] + arr2[j];
	    int dist = Math.abs(sum - num);

	    if (min > dist) {
		min = dist;
		res[0] = i;
		res[1] = j;
	    }

	    if (sum == num) {
		break;
	    } else if (sum < num) {
		i++;
	    } else {
		j--;
	    }
	}

	System.out.println(arr1[res[0]]);
	System.out.println(arr2[res[1]]);

	return res;

    }

    public static void main(String[] args) {
	int[] arr1 = { 3, 10, 2, 3, 7, 3 };
	int[] arr2 = { 9, 4, 6, 8, 1, 3, 75, 12, 5, 1, 0, 9, 5 };
	Arrays.sort(arr1);
	Arrays.sort(arr2);
	System.out.println(Arrays.toString(arr1));
	System.out.println(Arrays.toString(arr2));
	int num = 13;
	int[] res = new FindTheClosestPairFromTwoSortedArrays()
		.findPair(arr1, arr2, num);
	System.out.println(Arrays.toString(res));
    }

}
