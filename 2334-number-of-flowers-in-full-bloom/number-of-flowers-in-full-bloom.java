import java.util.*;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        // Step 1: Separate start and end times
        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        
        // Step 2: Sort them
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int m = people.length;
        int[] ans = new int[m];
        
        // Step 3: For each person, find count using binary search
        for (int i = 0; i < m; i++) {
            int time = people[i];
            // Flowers started blooming <= time
            int started = upperBound(starts, time);
            // Flowers ended blooming < time
            int ended = lowerBound(ends, time);
            
            ans[i] = started - ended;
        }
        
        return ans;
    }
    
    // Returns index of first element > target (count of elements <= target)
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // Returns index of first element >= target (count of elements < target)
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
