class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;

        // Two priority queues for the left and right candidates
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        int p1 = 0;  // Pointer for the left side
        int p2 = n - 1;  // Pointer for the right side

        // Add up to 'candidates' elements to the left and right priority queues
        while (p1 <= p2 && left.size() < candidates) {
            left.add(costs[p1++]);
        }
        while (p1 <= p2 && right.size() < candidates) {
            right.add(costs[p2--]);
        }

        // Process 'k' cheapest costs
        while (k > 0) {
            k--;

            // Compare the top elements from both queues
            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {
                ans += left.poll();  // Take from the left queue
                if (p1 <= p2) {  // Add a new element to the left queue if possible
                    left.add(costs[p1++]);
                }
            } else {
                ans += right.poll();  // Take from the right queue
                if (p1 <= p2) {  // Add a new element to the right queue if possible
                    right.add(costs[p2--]);
                }
            }
        }

        return ans;
    }
}
