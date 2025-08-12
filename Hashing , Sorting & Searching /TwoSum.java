
import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // num -> index
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] ans = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ans)); // [0,1]
    }
}

/*
 Time: O(n)
 Space: O(n)
*/
