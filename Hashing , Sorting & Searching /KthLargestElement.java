
import java.util.*;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) return nums[left];
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == kSmallest) return nums[pivotIndex];
        else if (pivotIndex < kSmallest) return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        else return quickSelect(nums, left, pivotIndex - 1, kSmallest);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right], storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                int temp = nums[storeIndex];
                nums[storeIndex] = nums[i];
                nums[i] = temp;
                storeIndex++;
            }
        }
        int temp = nums[storeIndex];
        nums[storeIndex] = nums[right];
        nums[right] = temp;
        return storeIndex;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // 5
    }
}

/*
 Time: Avg O(n), Worst O(n^2)
 Space: O(1)
*/
