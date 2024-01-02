class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n=nums.length;
        int ct[]=new int[201];
        for(int i=0;i<n;i++){
            ct[nums[i]]++;
        }
        int maxRow=0;
        for(int i=0;i<=200;i++){
            maxRow=Math.max(maxRow,ct[i]);
        }

        // boolean check[]=new boolean[201];
         List<List<Integer>> ans=new ArrayList<>();
         for(int i=0;i<maxRow;i++){
             ArrayList<Integer> in=new ArrayList<>();
             for(int k=1;k<=200;k++){
                 if(ct[k]>0){
                     in.add(k);
                     ct[k]--;
                 }
             }
             ans.add(in); 
         }
         System.gc();
         return ans;
    }
}