class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<Pair> set = new HashSet<>();
        int i = 0;
        int j = 0;
        set.add(new Pair(0, 0));
        for (int k = 0; k < path.length(); k++) {
            char c = path.charAt(k);
            if (c == 'N') j++;
            else if (c == 'S') j--;
            else if (c == 'E') i++;
            else i--;

            Pair x = new Pair(i, j);
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}

class Pair {
    int i, j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return i == pair.i && j == pair.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
