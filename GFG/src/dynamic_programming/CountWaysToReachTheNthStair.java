package dynamic_programming;

public class CountWaysToReachTheNthStair {
	public int countWaysToReachTheNthStair(int k) {
		if (k < 0)
			return 0;
		if (k <= 1)
			return 1;

		int preTwo = 1;
		int preOne = 1;
		for (int i = 2;i <= k;i++) {
			int cur = preTwo + preOne;
			preTwo = preOne;
			preOne = cur;
		}
		
		return preOne;
	}
	
	public static void main(String[] args) {
		for (int i = 0;i < 10;i++)
			System.out.println("" + i + ":" + new CountWaysToReachTheNthStair().countWaysToReachTheNthStair(i));
	}
}
