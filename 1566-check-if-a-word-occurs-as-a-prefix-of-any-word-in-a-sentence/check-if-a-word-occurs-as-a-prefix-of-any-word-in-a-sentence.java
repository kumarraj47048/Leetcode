class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        String regex="[,\\.\\s]";
        String st[]=sentence.split(regex);
        int n=st.length;
        int m=searchWord.length();
        for(int i=0;i<n;i++){
            if(st[i].length()>=m)
            if(st[i].substring(0,m).equals(searchWord)) return i+1;
        }
        return -1;
    }
}