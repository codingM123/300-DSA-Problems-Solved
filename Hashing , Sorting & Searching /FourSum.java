import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private static List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length) return res;

        long average = target / k;
        if (nums[start] > average || nums[nums.length - 1] < average) return res;

        if (k == 2) return twoSum(nums, target, start);

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (var subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(subset);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1])) lo++;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) hi--;
            else res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }
}

/*
 Time: O(n^(k-1)) => O(n^3) for 4-sum
 Space: O(n)
*/
