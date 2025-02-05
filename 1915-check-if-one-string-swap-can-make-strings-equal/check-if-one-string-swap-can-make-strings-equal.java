class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n=s1.length();
        HashSet<Character> set=new HashSet<>();
        HashSet<Character> set2=new HashSet<>();
        int ct=0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(set.size()==0){
                    set.add(s1.charAt(i));
                    set2.add(s2.charAt(i));
                }
                else{
                    if(!set.contains(s2.charAt(i)) || !set2.contains(s1.charAt(i))) return false;
                    else{
                        set.remove(s2.charAt(i));
                        set2.remove(s1.charAt(i));
                    }
                }
                ct++;
                if(ct>2) return false;
            }
        }
        if(set.size()==1) return false;
        return true;
    }
}