class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int c=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int left=g.length-1;
        int right=s.length-1;
        while(left>=0 && right>=0){
            if(s[right]>=g[left]){
                c++;
                left--;
                right--;
            }
            else if(s[right]<g[left]){
                left--;
            }
        }
       
        return c;
    }
}