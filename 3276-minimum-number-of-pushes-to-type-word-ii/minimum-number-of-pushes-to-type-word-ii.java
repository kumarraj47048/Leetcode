import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ct[] = new int[26];
        for (char c : word.toCharArray()) {
            ct[c - 'a']++;
        }

        // Use IntComparator for efficient sorting of int array
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:ct) list.add(i);
        Collections.sort(list,(a,b)->b-a);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (i <= 7) ans += list.get(i);
            else if (i >= 8 && i <= 15) ans += 2 * list.get(i);
            else if (i >= 16 && i <= 23) ans += 3 * list.get(i);
            else ans += 4 * list.get(i);
        }
        return ans; // Return the calculated answer
    }
}
