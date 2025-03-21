class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // If the array is already sorted, return the first element
            if (nums[left] <= nums[right]) return nums[left];

            int mid = left + (right - left) / 2;

            // Check if mid is the minimum element
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];

            // Decide which half to search
            if (nums[mid] >= nums[left]) {
                // Left half is sorted, so search in the right half
                left = mid + 1;
            } else {
                // Right half is sorted, so search in the left half
                right = mid - 1;
            }
        }

        return -1; // Should never be reached in a valid rotated sorted array
    }
}
