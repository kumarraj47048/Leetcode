class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0;
        int row=bank.length;
        int ctR=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<row;i++){
             ctR=0;
            String s=bank[i];
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='1') ctR++;
            }
            if(ctR>0){
                list.add(ctR);
            }
            if(list.size()>1){
                int sz=list.size();
                ans=ans+(list.get(sz-1)*list.get(sz-2));
                list.remove(0);
            }
            ctR=0;
        }
        return ans;
    }
}