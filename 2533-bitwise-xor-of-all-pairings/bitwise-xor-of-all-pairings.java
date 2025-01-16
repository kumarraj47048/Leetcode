class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int xor1=0;
        for(int i:nums1) xor1^=i;
        int xor2=0;
        for(int i:nums2) xor2^=i;
        if(n%2==0 && m%2==0) return 0;
        else if(m%2==0) return xor2;
        else if(n%2==0) return xor1;
        else return xor1^xor2;
    }
}