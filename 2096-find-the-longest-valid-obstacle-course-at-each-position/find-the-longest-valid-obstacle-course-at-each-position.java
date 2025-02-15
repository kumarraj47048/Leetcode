class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int ans[] = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = obstacles[i];
            int l = 0, r = list.size() - 1;
            int idx = i;
            if (list.size() == 0 || list.get(list.size() - 1) <= num) {
                list.add(num);
                ans[i] = list.size();
            } else {
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (list.get(mid) <= num) {
                        //idx = l;
                        l = mid + 1;
                    } else
                        r = mid - 1;
                }
                list.set(l, num);
                ans[i] = l + 1;
            }
        }
        return ans;
    }
}