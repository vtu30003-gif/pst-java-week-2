class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Extend the subarray or start fresh from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Track the global maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}