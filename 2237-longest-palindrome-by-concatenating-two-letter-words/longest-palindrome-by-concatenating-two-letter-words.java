class Solution {
    public int longestPalindrome(String[] words) {
        int length = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        boolean check=false;
        for(Map.Entry<String,Integer> mp:map.entrySet()){
            String s=mp.getKey();
            int v=mp.getValue();
            if(s.charAt(0)==s.charAt(1)){
                if(v%2==1 && check==false){
                    length+=(v*2);
                    check=true;
                }
                else if(v%2==1 && check==true){
                    length+=(v-1)*2;
                }
                else length+=v*2;
            }
            else{
                String rv=s.charAt(1)+""+s.charAt(0);
                length+=(Math.min(map.getOrDefault(s,0),map.getOrDefault(rv,0)))*2;
            }
        }
        return length;
    }
}
