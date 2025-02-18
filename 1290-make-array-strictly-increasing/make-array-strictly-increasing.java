import java.util.*;

class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length;
        Arrays.sort(arr2);
        HashMap<String, Integer> map = new HashMap<>();
        int x = solve(-1, 0, arr1, arr2, map);
        return (x >= 200001) ? -1 : x;
    }

    public static int solve(int prev, int idx, int arr1[], int arr2[], HashMap<String, Integer> dp) {
        if (idx >= arr1.length) return 0;
        
        String key = prev + "," + idx; // Memoization Key
        if (dp.containsKey(key)) return dp.get(key);

        int op1 = 200001, op2 = 200001;

        // Case 1: Keep arr1[idx] if it's valid
        if (prev < arr1[idx]) {
            op1 = solve(arr1[idx], idx + 1, arr1, arr2, dp);
        }

        // Case 2: Replace arr1[idx] with the next greater element from arr2
        int ceilVal = ceil(prev, arr2);
        if (ceilVal != -1) {
            op2 = 1 + solve(ceilVal, idx + 1, arr1, arr2, dp);
        }

        int res = Math.min(op1, op2);
        dp.put(key, res);
        return res;
    }

    public static int ceil(int x, int arr[]) {
        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                ans = arr[mid]; // Found a possible ceil, move left to find smaller one
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
