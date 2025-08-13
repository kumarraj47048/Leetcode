class Solution {
    public boolean isPowerOfThree(int n) {
        int x=1;
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        for(int i=1;i<=32;i++){
            set.add(x*3);
            x=x*3;
        }
        return set.contains(n);
    }
}