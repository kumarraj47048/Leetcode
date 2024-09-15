class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int max=0;
        int mask=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='a') mask^=(1<<0);
            else if(c=='e') mask^=(1<<1);
            else if(c=='i') mask^=(1<<2);
            else if(c=='o') mask^=(1<<3);
            else if(c=='u') mask^=(1<<4);

            if(map.containsKey(mask)){
                max=Math.max(max,i-map.get(mask));
            }else map.put(mask,i);
        }
        return max;
    }
}