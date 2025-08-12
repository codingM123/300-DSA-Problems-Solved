
import java.util.*;

public class Q5_MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= curr[1]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                res.add(curr);
                curr = intervals[i];
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] ans = merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        for (int[] a : ans) System.out.println(Arrays.toString(a));
    }
}

/*
 Time: O(n log n)
 Space: O(n)
*/
