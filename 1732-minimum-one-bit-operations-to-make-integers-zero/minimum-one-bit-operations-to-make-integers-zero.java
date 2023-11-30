class Solution {
    public int minimumOneBitOperations(int n) {
        int k=n;
        k^=k>>16;
        k^=k>>8;
        k^=k>>4;
        k^=k>>2;
        k^=k>>1;
        return k;
    }
}