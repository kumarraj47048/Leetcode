class Solution {
    public char[] ch;
    int k;
    public HashMap<Long,Integer> map=new HashMap<>();
    public int maxPartitionsAfterOperations(String s, int K) {
        k=K;
        ch=s.toCharArray();
        return solve(0,0,true)+1;
    }
    public int solve(int idx, long unique_characters, boolean canChange){
        if(idx>=ch.length) return 0;
        int set_pos=ch[idx]-'a';
        long new_set=(1<<set_pos)|unique_characters;
        int no_char=Long.bitCount(new_set);
        int x;
        if(canChange) x=1;
        else x=0;
        long key=(idx<<27)|(new_set<<1)|(x);
        if(map.containsKey(key)) return map.get(key);
        int result=0;
        if(no_char>k){
            result=1+solve(idx+1,(1<<set_pos),canChange);
        }else{
            result=solve(idx+1,new_set,canChange);
        }

        if(canChange){
           int temp_res=0;
           for(int i=0;i<26;i++){
              long new_set_change=(1<<i)|unique_characters;
              int new_no_char=Long.bitCount(new_set_change);
              if(new_no_char>k){
                temp_res=Math.max(temp_res,1+solve(idx+1,1<<i, false));
              }
              else{
                temp_res=Math.max(temp_res,solve(idx+1,new_set_change,false));
              }
           }
           result=Math.max(result, temp_res);
        }

        map.put(key,result);
        return result;
    }
}