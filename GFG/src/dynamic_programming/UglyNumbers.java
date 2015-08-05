package dynamic_programming;

import java.math.BigInteger;

//Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
//1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
//shows the first 11 ugly numbers. By convention, 1 is included.
//Write a program to find and print the 150’th ugly number.

public class UglyNumbers {
    public long findUglyNumbers(int n) {
	if (n <= 0) {
	    return 0;
	}

	if (n == 1)
	    return 1;

	long[] arr = new long[n + 1];
	arr[0] = 0;
	arr[1] = 1;
	int i = 2;
	int idx2 = 1;
	int idx3 = 1;
	int idx5 = 1;

	while (i <= n) {
	    arr[i] = Math.min(arr[idx2] * 2,
		    Math.min(arr[idx3] * 3, arr[idx5] * 5));

	    if (arr[i] == arr[idx2] * 2) {
		idx2++;
	    }
	    if (arr[i] == arr[idx3] * 3) {
		idx3++;
	    }
	    if (arr[i] == arr[idx5] * 5) {
		idx5++;
	    }
	    i++;
	}

	return arr[n];
    }

    public BigInteger findUglyNumbersBI(int n) {
	if (n <= 0) {
	    return new BigInteger("0");
	}

	if (n == 1)
	    return new BigInteger("1");

	BigInteger[] arr = new BigInteger[n + 1];
	arr[0] = new BigInteger("0");
	arr[1] = new BigInteger("1");
	int i = 2;
	int idx2 = 1;
	int idx3 = 1;
	int idx5 = 1;

	while (i <= n) {
	    BigInteger min = null;
	    BigInteger nextTwo = arr[idx2].multiply(new BigInteger("2"));
	    BigInteger nextThree = arr[idx3].multiply(new BigInteger("3"));
	    BigInteger nextFive = arr[idx5].multiply(new BigInteger("5"));

	    if (nextTwo.compareTo(nextThree) <= 0) {
		min = nextTwo;
	    } else {
		min = nextThree;
	    }

	    if (min.compareTo(nextFive) > 0) {
		min = nextFive;
	    }

	    arr[i] = min;

	    if (arr[i].equals(nextTwo)) {
		idx2++;
	    }
	    if (arr[i].equals(nextThree)) {
		idx3++;
	    }
	    if (arr[i].equals(nextFive)) {
		idx5++;
	    }
	    i++;
	}

	return arr[n];
    }

    private boolean verify(long num) {
	while (num % 2 == 0) {
	    num /= 2;
	}

	while (num % 3 == 0) {
	    num /= 3;
	}

	while (num % 5 == 0) {
	    num /= 5;
	}

	return num == 1;
    }

    public static void main(String[] args) {
	int n = 175;

	System.out.println(new UglyNumbers().findUglyNumbers(n));
	System.out.println(new UglyNumbers().findUglyNumbersBI(n));
	System.out.println(new UglyNumbers().verify(296148833645101056L));
    }
}
