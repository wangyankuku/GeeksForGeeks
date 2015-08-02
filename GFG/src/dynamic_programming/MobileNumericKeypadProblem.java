package dynamic_programming;

import java.util.*;

public class MobileNumericKeypadProblem {
	@SuppressWarnings("serial")
	public int mobileNumericKeyPad(int k) {
		if (k <= 0) {
			return 0;
		}
		
		int[] combo = new int[10];
		int[] newCombo = new int[10];
		
		Arrays.fill(combo, 1);
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		map.put(0, new ArrayList<Integer>() {{add(0);add(8);}});
		map.put(1, new ArrayList<Integer>() {{add(1);add(2);add(4);}});
		map.put(2, new ArrayList<Integer>() {{add(2);add(1);add(3);add(5);}});
		map.put(3, new ArrayList<Integer>() {{add(3);add(2);add(6);}});
		map.put(4, new ArrayList<Integer>() {{add(4);add(1);add(5);add(7);}});
		map.put(5, new ArrayList<Integer>() {{add(5);add(2);add(4);add(6);add(8);}});
		map.put(6, new ArrayList<Integer>() {{add(6);add(3);add(5);add(9);}});
		map.put(7, new ArrayList<Integer>() {{add(7);add(4);add(8);}});
		map.put(8, new ArrayList<Integer>() {{add(8);add(5);add(7);add(9);add(0);}});
		map.put(9, new ArrayList<Integer>() {{add(9);add(6);add(8);}});
		
		for (int i = 2;i <= k;i++) {
			for (int j = 0;j < 10;j++) {
				newCombo[j] = 0;
				List<Integer> temp = map.get(j);
				for (int n : temp) {
					newCombo[j] += combo[n];
				}
			}
			int[] temp = combo;
			combo = newCombo;
			newCombo = temp;
		}
		
		int sum = 0;
		
		for (int n : combo) {
			sum += n;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(new MobileNumericKeypadProblem().mobileNumericKeyPad(99999));
	}
}
