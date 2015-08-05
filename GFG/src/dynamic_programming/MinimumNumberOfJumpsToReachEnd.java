package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumNumberOfJumpsToReachEnd {
    public List<Integer> getMinimumNumberOfJumpsToReachEnd(int[] array) {
	if (array == null || array.length == 0) {
	    return null;
	}

	int len = array.length;
	int[] lastPointsIdx = new int[len];
	List<Integer> res = new ArrayList<Integer>();
	int counter = 0;
	int farrest = 0;

	Arrays.fill(lastPointsIdx, -1);

	for (int i = 0; i < len; i++) {
	    counter++;
	    if (i == 0) {
		for (int j = 1; j <= array[0] && j < len; j++) {
		    lastPointsIdx[j] = 0;
		    farrest = j;
		    counter++;
		}
		continue;
	    }

	    if (lastPointsIdx[i] >= 0) {
		int start = farrest;
		for (int j = start + 1; j <= i + array[i] && j < len; j++) {
		    lastPointsIdx[j] = i;
		    farrest = j;
		    counter++;
		}
	    } else {
		return res;
	    }
	}
	System.out.println(Arrays.toString(lastPointsIdx));
	System.out.println("counter is " + counter);
	int i = len - 1;
	while (i >= 0) {
	    res.add(array[i]);
	    i = lastPointsIdx[i];

	}

	Collections.reverse(res);

	return res;

    }

    public static void main(String[] args) {
	int[] array = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9, 1, 8, 4 };
	System.out.println(new MinimumNumberOfJumpsToReachEnd()
		.getMinimumNumberOfJumpsToReachEnd(array));
    }
}
