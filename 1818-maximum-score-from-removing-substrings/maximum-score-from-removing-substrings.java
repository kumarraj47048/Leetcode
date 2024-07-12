class Solution {
    public int maximumGain(String s, int x, int y) {
        char[] stack = new char[s.length()];
        int top = -1;
        int score = 0;

        char first = 'a', second = 'b';
        if (y > x) {
            first = 'b';
            second = 'a';
            int temp = x;
            x = y;
            y = temp;
        }

        for (char c : s.toCharArray()) {
            if (top >= 0 && stack[top] == first && c == second) {
                top--;
                score += x;
            } else {
                stack[++top] = c;
            }
        }

        int newTop = -1;
        for (int i = 0; i <= top; i++) {
            if (newTop >= 0 && stack[newTop] == second && stack[i] == first) {
                newTop--;
                score += y;
            } else {
                stack[++newTop] = stack[i];
            }
        }

        return score;
    }
}
