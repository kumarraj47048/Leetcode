class Solution {
    int max=101;
    public int getLengthOfOptimalCompression(String s, int k) {
        char ch[]=s.toCharArray();
        int n=ch.length;
        HashMap<String,Integer> map=new HashMap<>();
        return solve(0,'#',0,ch,k,map);
    }
    public int solve(int idx, char prev,int curr, char ch[], int steps, HashMap<String,Integer> map){
        if(steps<0) return 102;
        if(idx>=ch.length && steps>=0){
           return 0;
        }
        String key=idx+","+steps+","+prev+","+curr;
        if(map.containsKey(key)) return map.get(key);
        int del=solve(idx+1,prev,curr, ch,steps-1,map);
        int not_del=0;
        if(ch[idx]==prev){
            int add_more=0;
            if(curr==1 || curr==9 || curr==99) add_more=1;
            not_del=add_more+solve(idx+1,prev,curr+1,ch,steps,map);
        }
        else{
            not_del=1+solve(idx+1,ch[idx],1,ch,steps,map);
        }
        int val=Math.min(del,not_del);
        map.put(key,val);
        return val;
    }
    public int digits(int ct){
        if(ct==1) return 1;
        if(ct<10) return 2;
        if(ct<100) return 3;
        return 4;
    }
   
}