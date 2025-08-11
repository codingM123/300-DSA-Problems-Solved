
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum right side me hoga
                left = mid + 1;
            } else {
                // Minimum left side me ho sakta hai (mid included)
                right = mid;
            }
        }
        return nums[left];
    }
