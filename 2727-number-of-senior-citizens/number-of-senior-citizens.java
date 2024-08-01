class Solution {
    public int countSeniors(String[] details) {
        int ct=0;
        for(int i=0;i<details.length;i++){
             String s=details[i];
             String sb=s.substring(11,13);
             if(Integer.parseInt(sb)>60) ct++;
        }
    return ct;
    }
}