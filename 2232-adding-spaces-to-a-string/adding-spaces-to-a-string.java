class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n=s.length();
        char ch[]=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        HashSet<Integer> set=new HashSet<>();
        for(int i:spaces) set.add(i);
        if(set.contains(0)) sb.append(" ");
        for(int i=0;i<n;i++){
            sb.append(ch[i]);
            if(set.contains(i+1)) sb.append(" ");
        }
        return sb.toString();
    }
}