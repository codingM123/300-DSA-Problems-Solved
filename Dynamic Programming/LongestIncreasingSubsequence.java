
import java.util.*;

public class Q5_LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(tails, 0, size, x);
            if (i < 0) i = -(i + 1); // insertion point
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); // 4
    }
}
