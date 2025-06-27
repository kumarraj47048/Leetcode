class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        char ch[]=s.toCharArray();
        int n=ch.length;
        Queue<String> q=new LinkedList<>();
        int ct[]=new int[26];
        for(char c:ch){
            ct[c-'a']++;
        }

        String ans="";
        for(int i=0;i<26;i++){
            if(ct[i]>=k){
                String x=Character.toString((char)(i+'a'));
                q.add(x);
                ans=x;
            }
        }

        while(q.size()>0){
            String curr=q.poll();
            for(int i=0;i<26;i++){
                String temp=curr+Character.toString((char)(i+'a'));
                if(check(ch,k,temp)){
                   // if(ans.length()<temp.length()) ans=temp;
                   // else if(ans.length()==temp.length()) ans=ans.compareTo(temp)>=0?ans:temp;
                   ans=temp;
                    q.add(temp);
                }
            }
        }

        return ans;
    }
    public static boolean check(char ch[], int k, String part){
        int n=ch.length;
        int m=part.length();
        char pt[]=part.toCharArray();
        int ct=0;
        int p1=0;
        for(char c:ch){
            if(pt[p1]==c){
                p1++;
                if(p1>=m){
                    ct++;
                    p1=0;
                }
            }
        }

        return ct>=k;
    }
}