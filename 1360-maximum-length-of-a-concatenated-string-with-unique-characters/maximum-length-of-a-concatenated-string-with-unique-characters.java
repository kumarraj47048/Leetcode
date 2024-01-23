class Solution {
    public int maxLength(List<String> arr) {
       return dfs(arr,"",0);
          }

    public static int dfs(List<String> arr, String s, int curr){
        if(curr==arr.size())
        return s.length();
      int left=0;
      int right=0;
      String temp=s+arr.get(curr);
      if(isUnique(temp)){
          left=dfs(arr,temp,curr+1);
      }
      right=dfs(arr,s,curr+1);

      return Math.max(left,right);
    }

    public static boolean isUnique(String temp){
        int ans[]=new int[26];
        for(int i=0;i<temp.length();i++){
            ans[temp.charAt(i)-'a']++;
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]>1)
            return false;
        }
        return true;
    }
}