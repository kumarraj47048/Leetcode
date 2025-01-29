import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int maxSum = 0, suffixSum = 0, result = 0;

        for (int i = n - 1; i >= 0; i--) {
            suffixSum += satisfaction[i];  // Add current dish to suffix sum
            if (suffixSum + maxSum > maxSum) {
                maxSum += suffixSum;  // Update max sum
                result = maxSum;
            } else {
                break;  // Stop if including current dish doesn't improve result
            }
        }
        return result;
    }
}
