class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode curr = root;
        queue.offer(curr);

        boolean even = true;

        while(!queue.isEmpty()) {
            int size = queue.size();

            int prev = Integer.MAX_VALUE;
            if(even) {
                prev = Integer.MIN_VALUE;
            }

            while(size > 0) {
                curr = queue.poll();

            if ((even && (curr.val % 2 == 0 || curr.val <= prev)) || 
            (!even && (curr.val % 2 == 1 || curr.val >= prev))) {
                return false;
            }

            prev = curr.val;
            if(curr.left != null) {
                queue.offer(curr.left);
            }
            if(curr.right != null) {
                queue.offer(curr.right);
            }
            size--;
        }
        even = !even;
    }
    return true;
    }
}