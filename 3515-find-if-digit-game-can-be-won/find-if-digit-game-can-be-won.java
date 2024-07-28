class Solution {
    public boolean canAliceWin(int[] nums) {
        int n=nums.length;
        int a=0;
        int b=0;
        for(int i:nums){
            if(i<=9) a+=i;
            else b+=i;
        }
        if(a>b) return true;
        
        a=0;
        b=0;
        for(int i:nums){
            if(i>9 && i<100) a+=i;
            else b+=i;
        }
        if(a>b) return true;
        return false;
    }
}