package searching_and_sorting;

public class CountOneInASortedBinaryArray {
	public int countOneInASortedBinaryArray(int[] array) {

		if (array == null)
			return 0;

		int len = array.length;

		int i = 0;
		int j = len - 1;

		while (i < j) {
			int m = i + (j - i) / 2;
			if (m == i)
				m = j;
			if (array[m] == 1) {
				i = m;
			} else {
				j = m - 1;
			}
		}

		if (array[i] == 0) {
			return 0;
		}

		return i - 0 + 1;

	}

	public static void main(String[] args) {
		int[] array = { 1,1};
		System.out.println(new CountOneInASortedBinaryArray().countOneInASortedBinaryArray(array));
	}
}
