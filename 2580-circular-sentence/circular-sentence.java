class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] st=sentence.split(" ");
        for(int i=0;i<st.length-1;i++){
           if(st[i].charAt(st[i].length()-1)!=st[i+1].charAt(0))
           return false;
        }
        if(st[st.length-1].charAt(st[st.length-1].length()-1)!=st[0].charAt(0)) return false;
        return true;
    }
}