class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len=0;
        int n=s.length();
        char ch1[]=new char[s.length()];
        char ch2[]=new char[t.length()];
        ch1=s.toCharArray();
        ch2=t.toCharArray();
        int sum=0;
        int j=0;
        for(int i=0;i<s.length();i++){
              sum+=Math.abs(ch1[i]-ch2[i]);
              while(j<n && sum>maxCost){
                sum-=Math.abs(ch1[j]-ch2[j]);
                j++;
              }
              len=Math.max(len,i-j+1);
        }
        return len;
    }
}