public class HouseRobber {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev = nums[0]; // dp[i-2]
        int curr = Math.max(nums[0], nums[1]); // dp[i-1]

        for (int i = 2; i < nums.length; i++) {
            int next = Math.max(curr, prev + nums[i]); // either skip current or take current + prev
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1})); // 12 (2 + 9 + 1)
    }
}

/*
 Time: O(n)
 Space: O(1)
*/
