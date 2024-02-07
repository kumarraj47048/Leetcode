class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        int ct[][]=new int[128][2];
        for(int i=0;i<n;i++){
           char c=s.charAt(i);
           ct[c][0]=(int)(c);
           ct[c][1]++;
        }
        Arrays.sort(ct,(a,b)->(b[1]-a[1]));
        String sb=new String("");
        for(int i=0;i<128;i++){
            
            if(ct[i][1]>0){
                int f=ct[i][1];
                for(int k=0;k<f;k++){
                    sb+=(char)(ct[i][0]);
                }
            }
        }
        return sb;
    }
}