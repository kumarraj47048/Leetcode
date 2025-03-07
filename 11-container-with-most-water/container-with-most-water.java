class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int p1=0,p2=n-1;
        int ct=0;
        while(p1<p2){
            ct=Math.max(ct,Math.min(height[p1],height[p2])*(p2-p1));
            if(height[p1]<height[p2]) p1++;
            else p2--;
        }
        return ct;
    }
}