class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int pf[]=new int[n];
        if(check(words[0])) pf[0]=1;
        for(int i=1;i<n;i++){
            pf[i]=pf[i-1];
            if(check(words[i])) pf[i]++;
        }
        int q=queries.length;
        int ans[]=new int[q];
        for(int i=0;i<q;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            if(left==0) ans[i]=pf[right];
            else ans[i]=pf[right]-pf[left-1];
        }
        return ans;
    }
    public static boolean check(String s){
        char start=s.charAt(0);
        char end=s.charAt(s.length()-1);
        if((start=='a' || start=='e' || start=='i' || start=='o' || start=='u') && (end=='a' || end=='e' || end=='i' || end=='o' || end=='u')) return true;
        return false;
    }
}