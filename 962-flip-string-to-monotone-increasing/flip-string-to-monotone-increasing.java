class Solution {
    public int minFlipsMonoIncr(String s) {
        char ch[]=s.toCharArray();
        int n=ch.length;
        int ones=0;
        int flip=0;
        for(char c:ch){
            if(c=='0'){
                flip=Math.min(flip+1,ones);
            }
            else{
                ones++;
            }
        }
        return flip;
    }
}