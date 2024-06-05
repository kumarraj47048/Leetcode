class Solution {
    public List<String> commonChars(String[] words) {
        int n=words.length;
        int count[][]=new int[n][26];
        for(int i=0;i<n;i++){
            for(char c:words[i].toCharArray()){
                count[i][c-'a']++;
            }
        }
        
        int temp[]=new int[26];
        Arrays.fill(temp,n+1);
        for(int i=0;i<26;i++){
            for(int j=0;j<n;j++){
               
                    temp[i]=Math.min(temp[i],count[j][i]);
                
            }
        }
        
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<26;i++){
            char c=(char)('a'+i);
            String s=Character.toString(c);
            if(temp[i]!=n+1){
            for(int j=0;j<temp[i];j++){
                ans.add(s);
            }
            }
        }
        return ans;
    }
}