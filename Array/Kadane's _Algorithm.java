
public class Q1_MaximumSubarraySum {
    public static int findMaxSubarraySum(int[] nums) {
        int maxSum = nums[0];    // ab tak ka max sum
        int currentSum = nums[0]; // abhi ka running sum

        for (int i = 1; i < nums.length; i++) {
            // Decide karo ki naya subarray start kare ya continue kare
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Max sum update karo
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findMaxSubarraySum(arr));
    }
}
