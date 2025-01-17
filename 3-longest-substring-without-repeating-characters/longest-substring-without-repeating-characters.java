class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int len=0 ;
        char ch[]=s.toCharArray();
        int i=0;
        int j=0;
        while(j<n){
            while(i<j && check(i,j,ch)==false) i++;
            len=Math.max(len,j-i+1);
            j++;
        }
        return len;
    }
    public static boolean check(int i, int j, char ch[]){
        //int ct[]=new int[150];
        HashSet<Character> set =new HashSet<>();

        for(int k=i;k<=j;k++){
            char c=ch[k];
            if(set.contains(c)) return false;
            set.add(c);
        }

        // for(int k=0;k<150;k++){
        //     if(ct[k]>1) return false;
        // }
        return true;
    }
}