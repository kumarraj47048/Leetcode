class Solution {
    public boolean judgeSquareSum(int c) {
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<=(int)Math.sqrt(c);i++) map.put(i*i,1);
       for(int i=0;i<=(int)Math.sqrt(c);i++){
        if(map.containsKey(c-(i*i))) return true;
       } 
       return false;
    }
}