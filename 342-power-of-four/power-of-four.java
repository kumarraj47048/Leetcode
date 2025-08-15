class Solution {
    public boolean isPowerOfFour(int n) {
        HashSet<Integer> set=new HashSet<>();
        int temp=1;
        if(n==0) return false;
        set.add(temp);
        for(int i=1;i<=32;i++){
            set.add(temp*4);
            temp*=4;
        }
        return (set.contains(n));
    }
}