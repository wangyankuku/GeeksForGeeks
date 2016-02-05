package dynamic_programming;

import java.util.Arrays;

public class Fib {
    public long[] getFibSeq(int n) {
	if (n <= 0) {
	    // or throw an IllegalArgument Exception
	    return null;
	}

	long[] fibArray = new long[n];
	fibArray[0] = 0L;
	if (n == 1) {
	    return fibArray;
	}

	fibArray[1] = 1L;

	long preTwo = 0L;
	long preOne = 1L;

	for (int i = 2; i < n; i++) {
	    fibArray[i] = preTwo + preOne;
	    preTwo = preOne;
	    preOne = fibArray[i];
	}

	return fibArray;
    }

    public static void main(String[] args) {
	System.out.println(Arrays.toString(new Fib().getFibSeq(100)));
    }

}
