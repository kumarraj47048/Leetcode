class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> ans=new ArrayList<>();
        int lsize=0;
        int rsize=0;
        int xlow=low;
        int xhigh=high;
        while(xlow>0){
            lsize++;
            xlow=xlow/10;
        }
         while(xhigh>0){
            rsize++;
            xhigh=xhigh/10;
        }
        
        for(int i=lsize;i<=rsize;i++){
            
            for(int j=1;j<=9-i+1;j++){
                int num=0;
                int idx=j;
                int size=i;
                while(size>0){
                    num=num*10+idx;
                    idx++;
                    size--;
                }
                if(num>=low && num<=high) ans.add(num);
            }
        }
        return ans;
    }
   
}