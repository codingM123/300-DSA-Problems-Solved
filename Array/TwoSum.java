import java.util.HashMap;

public class Q1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // number -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // jo value chahiye sum complete karne ke liye
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // mil gaya pair
            }
            map.put(nums[i], i); // store current value
        }
        return new int[]{}; // agar pair nahi mila
    }
