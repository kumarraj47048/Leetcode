class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int len=0;
        int oddMax=0;
        boolean hasOddValue=false;
        for(int val:map.values()){
            if(val%2==0){
                len+=val;
            }
            else{
                len+=val-1;
                hasOddValue=true;
            }
        }
        if(hasOddValue==true) len++;
      
    return len;
    }
}