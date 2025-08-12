
import java.util.*;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Step 1: Add all intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Step 3: Add remaining intervals
        while (i < n) res.add(intervals[i++]);

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] ans = insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
        for (int[] a : ans) System.out.println(Arrays.toString(a));
    }
}

/*
 Time: O(n)
 Space: O(n)
*/
