
public class Q3_HouseRobberII {
    private static int robLinear(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int prev = nums[l];
        int curr = Math.max(nums[l], nums[l+1]);
        for (int i = l + 2; i <= r; i++) {
            int next = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        // either skip last or skip first
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2})); // 3
        System.out.println(rob(new int[]{1,2,3,1})); // 4
    }
}

/*
 Time: O(n)
 Space: O(1)
*/
