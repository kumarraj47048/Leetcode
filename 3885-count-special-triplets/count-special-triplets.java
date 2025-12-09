class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, Integer> left = new HashMap<>();
        int mod = (int)1e9 + 7;
        
        for (int x : nums)
            right.put(x, right.getOrDefault(x, 0) + 1);

        long ct = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            
            right.put(x, right.get(x) - 1); // remove current from right

            int L = left.getOrDefault(x * 2, 0);
            int R = right.getOrDefault(x * 2, 0);

            ct = (ct + (long)L * R) % mod;

            left.put(x, left.getOrDefault(x, 0) + 1);
        }

        return (int)ct;
    }
}
