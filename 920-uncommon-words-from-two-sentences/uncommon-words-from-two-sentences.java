class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String a[]=s1.split(" ");
        String b[]=s2.split(" ");
        List<String> ans=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        HashSet<String> temp=new HashSet<>();

        for(String x:a){
            if(!temp.contains(x)){
                temp.add(x);
                set.add(x);
            }
            else set.remove(x);
        }
        for(String x:b){
            if(!temp.contains(x)){
                temp.add(x);
                set.add(x);
            }
            else set.remove(x);
        }
        for(String x:set) ans.add(x);
       String ret[]=new String[ans.size()];
       int idx=0;
       for(String x:ans) ret[idx++]=x;
        return ret;
    }
}